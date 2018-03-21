import DAO.QuerysDAO;
import DTO.CityDTO;

import DTO.CountryDTO;
import ORMConnect.ConnectORM;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mads-power on 30.10.2017.
 */
public class main {
    public static void main(String[] args) throws SQLException {


        QuerysDAO q = new QuerysDAO();

        System.out.println("Choose Continent: ");
        Scanner sc = new Scanner(System.in);
        String countryChoose = sc.nextLine();
        q.printResult(q.getCountryesOnContinent(countryChoose));
       
      /* CountryDTO c = new CountryDTO("code","name","continent", "region",  20, 1880, 10, 20, 5,
               3, "localName", "headOfState", "capital","yeeeahh");*/
        
        
    }


}
