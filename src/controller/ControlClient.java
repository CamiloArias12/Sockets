package controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ControlClient {
    private Socket socket;

    public ControlClient(Socket socket) {
        this.socket = socket;
    }

    public void enviarArchivo(String nombreArchivo) throws IOException {
        try {
            File archivo = new File(nombreArchivo);
            long tamanoArchivo = archivo.length();

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF(nombreArchivo);
            dataOutputStream.writeLong(tamanoArchivo);

            FileInputStream fis = new FileInputStream(archivo);
            byte[] buffer = new byte[1024];
            int leidos;
            long enviados = 0;

            while ((leidos = fis.read(buffer)) != -1) {
                dataOutputStream.write(buffer, 0, leidos);
                enviados += leidos;
            }

            fis.close();
            dataOutputStream.close();
            socket.close();
            System.out.println("Archivo enviado: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}