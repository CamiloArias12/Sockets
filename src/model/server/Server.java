package model.server;

import java.net.*;

import controller.ControlServer;

import java.io.*;

public class Server {
    private ServerSocket server = null;


    public void startServer() throws IOException {
        int puerto = 12345;
        ServerSocket serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor esperando conexiones en el puerto " + puerto);

        while (true) {
            Socket clienteSocket = serverSocket.accept();
            ControlServer controlador = new ControlServer(clienteSocket);
            controlador.start();
        }
    }
}
