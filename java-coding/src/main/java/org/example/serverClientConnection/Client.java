package org.example.serverClientConnection;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",6666);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF("Hello Server");

            dataOutputStream.flush();

            dataOutputStream.close();

            socket.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
