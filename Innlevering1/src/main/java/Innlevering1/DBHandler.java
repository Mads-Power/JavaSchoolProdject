package Innlevering1;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Mads-power on 20.09.2017.
 */
public class DBHandler implements Serializable{

    public static  void CreateDB(Connection con){
        Statement stmt = null;
        MysqlCon s = new MysqlCon();
        try{
            System.out.println("Creating a database Called innlevering1");
            stmt = con.createStatement();
            String sql = "CREATE DATABASE innlevering1";

            stmt.execute(sql);
            System.out.println("Database Created");

        }catch (SQLException e){
            System.out.println("DataBase Existerer allerede, slett eksisterende før du kan bruke dette kallet");
          //  e.printStackTrace();

        }
    }

    public static void Create(Connection con) throws SQLException{
        Statement stmt = null;
        try {
            System.out.println("connected");

            // create Table in Database
            System.out.println("Creating table in given database...");
            stmt = con.createStatement();

            String CreateSql = "CREATE TABLE emne" + "(emneID VARCHAR(255), " +
                    " emneNavn VARCHAR(255), " +
                    " facilities VARCHAR(255), " +
                    " RegisteredStudents INT (255), " +
                    " teacher VARCHAR (255))";
            stmt.executeUpdate(CreateSql);
            System.out.println("Table created");

        }catch (Exception e){
            System.out.println("Table already exists..");
        }
    }
    static void read(Connection con)throws SQLException{

        File file = new File("Emne.txt");

        String emneID;
        String emneNavn;
        String facilities;
        String regStudents;
        String teacher;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            java.sql.PreparedStatement ps = null;

            while ((line=br.readLine()) != null) {
                String temp[] = line.split(",");
                emneID = temp[0];
                emneNavn = temp[1];
                facilities = temp[2];
                regStudents = temp[3];
                teacher = temp[4];

                String sql2 = "INSERT INTO emne(EmneID,emneNavn, facilities, RegisteredStudents, teacher)values('" + emneID + "','" + emneNavn + "',' " + facilities + "',' " + regStudents + "',' " + teacher+"')";

                ps = con.prepareStatement(sql2);
                ps.executeUpdate(sql2);
            }
        }catch (Exception e){
            System.out.println("Error ");
           // e.printStackTrace();
        }
    }

    static void Delete(Connection con) {
        System.out.println("Delete table & Database ...");
         try {
           Statement stmt = con.createStatement();
            String DeleteTableSql = "DROP TABLE emne";
             stmt.executeUpdate(DeleteTableSql);
             System.out.println("Table Deleted in Given Database...");

             String sql = "DROP DATABASE innlevering1";
             stmt.executeUpdate(sql);
             System.out.println("Database deleted successfully...");

         } catch (SQLException e) {
            System.out.println(e.getMessage());
         }

    }
    static void setInfoFromTable(Connection con) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Statement stmt = con.createStatement();
        System.out.println("Plese Enter emneID to get Info: ");
        String name = sc.next();

        String sql = "SELECT * FROM emne WHERE emneID='" + name +"'";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            System.out.println("Emne ID:" + rs.getString("emneID"));
            System.out.println("Emne Navn: " + rs.getString("emneNavn"));
            System.out.println("Fasiliteter: " + rs.getString("facilities"));
            System.out.println("Registrerte Studenter: " + rs.getInt("RegisteredStudents"));
            System.out.println("Lærer: " + rs.getString("teacher") + "\n");
        }
    }
}

