package model.server;

import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket server = null;

    public Server() throws IOException {
        server = new ServerSocket(4400);
    }

    public void startServer() {
        while (true) {
            try {
                Socket client = server.accept();

                DataInputStream input = new DataInputStream(client.getInputStream());
                
                String nameFile = input.readUTF().toString();

                int tam = input.readInt();
                FileOutputStream output = new FileOutputStream("c://Users//jairg//Music//m");
                BufferedOutputStream out = new BufferedOutputStream(output);
                BufferedInputStream in = new BufferedInputStream(client.getInputStream());

                // Creamos el array de bytes para leer los datos del archivo
                byte[] buffer = new byte[tam];

                // Obtenemos el archivo mediante la lectura de bytes enviados
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) in.read();
                }

                // Escribimos el archivo
                out.write(buffer);

                // Cerramos flujos
                out.flush();
                in.close();
                out.close();
                client.close();

                System.out.println("Archivo Recibido "+nameFile);
            } catch (Exception e) {
            }
        }
    }
}
