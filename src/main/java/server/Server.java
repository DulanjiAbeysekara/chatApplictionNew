package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Handler;

public class Server {
    private static ArrayList<Handler>clients=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(4500);

        Socket accept;

        while (true){

            System.out.println("waiting for client.... ");
            accept=serverSocket.accept();

            System.out.println("Client connected");
            Handler clientThread=new Handler(accept,clients);
            clients.add(clientThread);
            clientThread.start();

        }


    }
}
