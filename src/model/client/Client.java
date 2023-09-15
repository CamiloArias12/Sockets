package model.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.ControlClient;

public class Client {
    public void client() throws UnknownHostException, IOException{
                String servidorDireccion = "localhost";
        int puerto = 12345;

        Socket socket = new Socket(servidorDireccion, puerto);
        ControlClient controlador = new ControlClient(socket);
        controlador.enviarArchivo("archivo.txt");
    }
}
