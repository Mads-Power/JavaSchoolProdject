package Innlevering1;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;


public class IncjectToTable{


    static final String DB_URL = "jdbc:mysql://localhost/innlevering1";

    static final String USER = "mads";
    static final String PASS = "kolkin123";

    public static void main(String[] args) {
       // MysqlCon b = new MysqlCon();
        Connection conn = null;
        Statement stmt = null;
        ArrayList emneList = new ArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            try {
                conn = getConnection(DB_URL, USER,PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Connected database successfully...");

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO emne " +
                    "VALUES (14, 'tredje', 'alliii', 18, 'mads')";
            stmt.executeUpdate(sql);

            String sqlm = "INSERT INTO teacher " +
                    "VALUES (4, 'Kolkin', 'Mads',  'ledig')";
            stmt.executeUpdate(sqlm);

            emneList.add(sqlm);
            emneList.add(sql);

            System.out.println("Inserted records into the table..." + emneList);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample


