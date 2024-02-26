package com.ox.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends Tcp{
    private static Socket socket;

    public static void connectToServer() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 5001), 1000);
        System.out.println("Connection Successful!");
    }

    public static void close() throws IOException {
        socket.close();
    }


}
