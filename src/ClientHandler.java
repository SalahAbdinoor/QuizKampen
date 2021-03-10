import java.io.*;
import java.net.Socket;

/**
 * Created by Daniel Bojic
 * Date: 2020-11-25
 * Time: 15:40
 * Project: Quizkampen
 * Copyright: MIT
 */
public class ClientHandler extends Thread implements Serializable {

    private final Socket player1Socket;
    private final Socket player2Socket;

    Player player1 = new Player();
    Player player2 = new Player();


    public ClientHandler(Socket socketToClient, Socket socketToClient2) {
        this.player1Socket = socketToClient;
        this.player2Socket = socketToClient2;
    }


    @Override
    public void run() {

        if (player1Socket.isConnected() && player2Socket.isConnected()) {

            while (!player2.getFinished() && !player1.getFinished()) {
                try {

                    player1 = (Player) new ObjectInputStream(player1Socket.getInputStream()).readObject();

                    player2 = (Player) new ObjectInputStream(player2Socket.getInputStream()).readObject();


                    if (player1.getPLAYER() == 0 && player2.getPLAYER() == 0){
                        player1.setPLAYER(1);
                        player2.setPLAYER(2);
                    }


                    player1.setConnected(true);
                    player2.setConnected(true);


                    new ObjectOutputStream(player1Socket.getOutputStream()).writeObject(player2);

                    new ObjectOutputStream(player2Socket.getOutputStream()).writeObject(player1);


                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


        try {
            player1Socket.close();
            player2Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    System.exit(0);
    }


}
