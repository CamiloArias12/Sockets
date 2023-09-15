package controller;
// ControladorServidor.java
import java.io.*;
import java.net.*;

public class ControlServer extends Thread {
    private Socket clienteSocket;

    public ControlServer(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    public void run() {
        try {
            // Lógica para recibir y guardar el archivo desde el cliente
            InputStream inputStream = clienteSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            String nombreArchivo = dataInputStream.readUTF();
            long tamanoArchivo = dataInputStream.readLong();

            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            byte[] buffer = new byte[1024];
            int leidos;
            long recibidos = 0;
            
            while (recibidos < tamanoArchivo && (leidos = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, tamanoArchivo - recibidos))) != -1) {
                fos.write(buffer, 0, leidos);
                recibidos += leidos;
            }

            fos.close();
            dataInputStream.close();
            clienteSocket.close();
            System.out.println("Archivo recibido: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
