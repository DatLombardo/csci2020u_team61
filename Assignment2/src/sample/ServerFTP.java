package sample;

import java.io.*;
import java.net.*;

/**
 * Created by michael on 27/03/17.
 */
public class ServerFTP {
    protected ServerSocket serverSocket;
    private static Socket clientSocket = null;
    public static int SERVER_PORT = 3333;

    public ServerFTP() throws IOException {
        serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server Initialized");
    }

    public void handleRequests() throws IOException {
        System.out.println("Server FTP is listening on port: " + SERVER_PORT);
        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Accepted connection : " + clientSocket);
            ClientConnectionHandler handler =
                    new ClientConnectionHandler(clientSocket);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();
        }
    }
    public static void main(String[] args) {
        try{
            ServerFTP server = new ServerFTP();
            server.handleRequests();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}