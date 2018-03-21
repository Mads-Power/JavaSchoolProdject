package Innlevering1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * klient klassen kaller på alle de andre klassene den trenger for å utføre oppgaven.
 * Etter du har kjørt MainMethod, gå til MysqlCon og still inn sånn at du kobler deg til innlevering1 DB
 * Created by Mads-power on 25.09.2017.
 */

public class MainMethod {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        MysqlCon c = new MysqlCon();
        Connection con = null;
        con = c.getConnection();

       PopulateByUserChoice.PopulateWithUserInput(con);



    }
}
