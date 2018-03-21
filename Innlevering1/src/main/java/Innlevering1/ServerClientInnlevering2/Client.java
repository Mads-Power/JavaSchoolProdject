package Innlevering1.ServerClientInnlevering2;

import java.io.*;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String host = "localhost";
        String portNumber = "7";

        try {
            System.out.println("Welcome to the client.\n"
                    + "What is the name of the server host?");
            String hostName = br.readLine();
            if( host.equals(hostName)/*hostName.length() == 0*/) {
                hostName = "localhost";

            } else  { System.out.println("Wrong HostName, Try again. Hint: localhost");
                hostName = br.readLine(); }

            System.out.println("What is the port number of the server host?(hint: it's 7)");
            String portNum = br.readLine();

            if(  portNumber.equals(portNum)/*portNum.length() == 0*/) {
                portNum = "7";
            }else {
                System.out.println("Come on dude, i gave you a hint..sigh..It's 7 bro/sis, try again!");
                portNum = br.readLine();
            }
                ServerThreads socket = new ServerThreads(InetAddress.getByName(hostName), Integer.parseInt(portNum));
                boolean done = false;
                String echo;
            while(!done) {

                System.out.println("Enter Code: 100 = Search File, 400 = Logout");
                String message = br.readLine();
                boolean messageOK = false;

                if( (message.trim()).equals("400") ) {

                    System.out.println("Logged Out");
                    done = true;
                    socket.sendMessage("400");
                    socket.close();
                    break;
                }
                if((message.trim()).equals("100")){
                    messageOK = true;
                    System.out.println("Enter a name to get info: (eks: PGR200-1 or IS3200-1)");
                    socket.sendObject();
                    System.out.println("Enter a name to get info: (eks: PGR200-1 or IS3200-1)");
                    socket.sendObject();
                }
                if( ! messageOK ) {
                    System.out.println("Invalid input");
                    continue;
                }echo = socket.receiveMessage();
                System.out.println(echo);}
        } catch (Exception ex) {ex.printStackTrace();
        }
    }
}