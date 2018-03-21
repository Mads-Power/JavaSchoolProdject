package Innlevering1.ServerClientInnlevering2;

import Innlevering1.MysqlCon;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

 class ServerThreads {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;


   ServerThreads(InetAddress acceptorHost, int acceptorPort)
            throws  IOException {
        socket = new Socket(acceptorHost, acceptorPort);
       setStreams();
    }

    ServerThreads(Socket socket) throws IOException {
        this.socket = socket;
        setStreams();
    }

    private void setStreams() throws IOException {
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }


    void sendMessage(String message) throws IOException {
        output.writeUTF(message);
        output.flush();
    }

    String receiveMessage() throws IOException {
        String message = input.readUTF();
        return message;
    }

    void close() throws IOException {
        socket.close();
    }

    void sendObject() throws SQLException, IOException, NullPointerException {
        MysqlCon ds = new MysqlCon();
        Connection con = ds.getConnection();
        Scanner sc = new Scanner(System.in);
        Statement stmt = con.createStatement();
        String name = sc.next();
        String sql = "SELECT * FROM emne WHERE emneID='" + name +"'";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

                System.out.println("Emne ID:" + rs.getString("emneID"));
                System.out.println("Emne Navn: " + rs.getString("emneNavn"));
                System.out.println("Fasiliteter: " + rs.getString("facilities"));
                System.out.println("Registrerte Studenter: " + rs.getInt("RegisteredStudents"));
                System.out.println("Lærer: " + rs.getString("teacher") + "\n");
            }
    }
 }


