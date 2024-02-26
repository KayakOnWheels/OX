package com.ox.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Tcp {
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void setUp() throws IOException {


        serverSocket = new ServerSocket(5001);
        System.out.println("Listening for clients...");

        socket = serverSocket.accept();
        String clientSocketIP = socket.getInetAddress().toString();
        int clientSocketPort = socket.getPort();
        System.out.println("[IP: " + clientSocketIP + " ,Port: " + clientSocketPort +"]  " + "Client Connection Successful!");
    }


    public static void close() throws IOException{
        serverSocket.close();
        socket.close();
    }

}
