package ORMConnect;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by Mads-power on 30.10.2017.
 */
public class ConnectORM {

    public JdbcConnectionSource getConnection() throws SQLException {
        String dataBaseUrl = "jdbc:mysql://localhost:3306/world";
        ConnectionSource connectionSource = new JdbcConnectionSource(dataBaseUrl, "mads", "kolkin123");
    return (JdbcConnectionSource) connectionSource;
    }
}
