import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Daniel Bojic
 * Date: 2020-11-26
 * Time: 09:59
 * Project: Quizkampen
 * Copyright: MIT
 */
public class ServerListener extends Thread implements Serializable {

    private final ServerSocket serverSocket;

    ServerListener() throws IOException {
        serverSocket = ServerSocketFactory.getDefault().createServerSocket(7777);
    }

    @Override
    public void run() {
        while (true){
            try {

                final Socket socketToClient = serverSocket.accept();
                final Socket socketToClient2 = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socketToClient, socketToClient2);
                clientHandler.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ServerListener sl = new ServerListener();

        sl.start();
    }
}
