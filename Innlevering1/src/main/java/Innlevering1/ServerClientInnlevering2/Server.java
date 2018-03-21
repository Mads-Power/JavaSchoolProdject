package Innlevering1.ServerClientInnlevering2;
import java.io.*;
import java.net.*;
import java.sql.SQLException;



public class Server {
    private static final String logoutMessage = "Logged Out";

    public static void main(String[] args) throws  IOException, SQLException {
        int serverPort = 7;
        String message;
        new Server();

        if (args.length == 1) serverPort = Integer.parseInt(args[0]);
        try {
            ServerSocket myConnectionSocket = new ServerSocket(serverPort);
            System.out.println("Server ready.");
            while (true) {
                System.out.println("Waiting for a  Client connection.");
                ServerThreads myDataSocket = new ServerThreads(myConnectionSocket.accept());

                System.out.println("connection accepted");
                boolean done = false;
                while (!done) {
                    message = myDataSocket.receiveMessage();
                    System.out.println("message received: " + message);

                    if ((message.trim()).equals("400")) {
                        myDataSocket.sendMessage(logoutMessage);
                        myDataSocket.close();
                        done = true;
                    }

                    if ((message.trim()).equals("100")) {
                        myDataSocket.sendObject();
                    }
                 }
            }
        } catch(Exception ex){ex.printStackTrace();}
    }

}

