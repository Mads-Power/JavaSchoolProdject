package Innlevering1;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.*;
import java.sql.Connection;

public class ReadFromFile {
    public static void main(String[] args)  {
        File file = new File("Emne.txt");
        String emneID;
        String emneNavn;
        String facilities;
        String regStudents;
        String teacher;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
             String line;
            java.sql.PreparedStatement ps = null;

            MysqlDataSource ds = new MysqlDataSource();
            ds.setDatabaseName("innlevering1");
            ds.setServerName("localhost");
            ds.setUser("mads");
            ds.setPassword("kolkin123");
            Connection  con = ds.getConnection();
            while ((line=br.readLine()) != null) {
                String temp[] = line.split(",");
                 emneID = temp[0];
                 emneNavn = temp[1];
                 facilities = temp[2];
                 regStudents = temp[3];
                 teacher = temp[4];
                System.out.println(emneID + "\t" + emneNavn + "\t" + facilities + "\t" + regStudents + "\t" + teacher);
                 String sql = "INSERT INTO emne(EmneID,emneNavn, facilities,RegisteredStudents,teacher)values('" + emneID + "','" + emneNavn + "',' " + facilities + "',' " + regStudents + "',' " + teacher + "')";

                 ps = con.prepareStatement(sql);
                     ps.executeUpdate();
             }
                 br.close();
                 con.close();
                 ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}