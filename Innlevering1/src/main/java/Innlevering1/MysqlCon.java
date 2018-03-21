package Innlevering1;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

/**
 * Etter du har laget databasen, sett ds.databasename("") navnet til innlevering1
 * kjør mainMethod på nytt
 * Created by Mads-power on 05.09.2017.
 */

public class MysqlCon {
    String databaseName, ServerName, User, PassW;
    Connection con;



    public MysqlCon() {
      this.databaseName = databaseName;
      this.ServerName = ServerName;
      this.User = User;
      this.PassW = PassW;
      this.con = null;
    }

    public Connection getConnection() throws SQLException{

        MysqlDataSource ds = new MysqlDataSource();

        ds.setDatabaseName("innlevering1");
        ds.setServerName("localhost");
        ds.setUser("mads");
        ds.setPassword("kolkin123");
        Connection con = ds.getConnection();
        System.out.println("connected to Database");
        return con;

    }
}


