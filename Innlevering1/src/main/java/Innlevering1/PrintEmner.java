package Innlevering1;


import java.sql.*;

/**
 * Klasse som printer ut info fra tabellen emner.
 *
 * Created by Mads-power on 25.09.2017.
 */
public class PrintEmner {
    public static void PrintInfo(Connection con) throws SQLException{

        try {
            Statement stmt;
            stmt = con.createStatement();
            String sql = "SELECT emneID, emneNavn, facilities, RegisteredStudents, teacher FROM emne";
            ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){

                String emneID  = rs.getString("emneID");
                String EmneNavn = rs.getString("emneNavn");
                String facilities = rs.getString("facilities");
                int RegisteredStudents = rs.getInt("RegisteredStudents");
                String lærer = rs.getString("teacher");


                System.out.print("\nEmne ID: " + emneID);
                System.out.print("\nEmne Navn: " + EmneNavn);
                System.out.print("\nCampus: " + facilities);
                System.out.println("\nAntall Registrerte Studenter: " + RegisteredStudents);
                System.out.print("Lærer: " + lærer+"\n");
            }
        }catch (Exception e){
            System.out.println("Finner ingen tabell, lag en først");
            e.printStackTrace();

        }

    }

}
