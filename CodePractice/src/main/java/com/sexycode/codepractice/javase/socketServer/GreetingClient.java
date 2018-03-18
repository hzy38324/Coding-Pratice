package com.sexycode.codepractice.javase.socketServer;

import java.io.*;
import java.net.Socket;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/10
 */
public class GreetingClient {

    public static final String SERVER_NAME = "localhost";
    public static final int PORT = 6066;

    public static void main(String [] args) {
        String serverName = SERVER_NAME;
        int port = PORT;

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}