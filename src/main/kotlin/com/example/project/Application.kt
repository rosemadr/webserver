package com.example.project
import java.net.ServerSocket
import java.io.OutputStream

fun main(args: Array<String>) {
    print("application is running")

    val host = "127.0.0.1"
    val port = 8080

    ServerSocket(port).use { server ->
        print("listing on $host:$port")

        while (true) {
            val client = server.accept()

            Thread {
                client.use { socket ->
                    try {
                        val out: OutputStream = socket.getOutputStream()

                        val body = "<h1>Hello!</h1>".toByteArray()
                        val headers = "HTTP/1.1 200 OK\r\nContent-Length: ${body.size}\r\n\r\n"

                        out.write(headers.toByteArray())
                        out.write(body)
                        out.flush()
                    } catch (e: Exception) {
                        println("Error handling client: ${e.message}")
                    }
                }
            }.start()
        }
    }
}