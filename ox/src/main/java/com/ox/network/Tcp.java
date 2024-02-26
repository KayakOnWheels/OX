package com.ox.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public abstract class Tcp {

    private static Socket socket;

    public static String readData() throws IOException {
        DataInputStream dataIn = new DataInputStream(socket.getInputStream());

        dataIn.close();
        return dataIn.readUTF();
    }

    public static void sendData(String message) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

        dataOut.writeUTF(message);
        dataOut.close();

    }

    public static void close() throws IOException{}
}
