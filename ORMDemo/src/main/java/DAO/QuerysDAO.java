package DAO;

import DTO.CityDTO;
import DTO.CountryDTO;
import ORMConnect.ConnectORM;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mads-power on 30.10.2017.
 */
public class QuerysDAO {
    ConnectORM con = new ConnectORM();
    JdbcConnectionSource ConnectionSource = con.getConnection();

    public QuerysDAO() throws SQLException {
    }

    public Dao<CountryDTO, String> getDao() throws SQLException {
        Dao<CountryDTO, String> CountryDao = DaoManager.createDao(ConnectionSource, CountryDTO.class);
        return CountryDao;
    }

    public PreparedQuery<CountryDTO> getCountryesOnContinent(String continent) throws SQLException {
        Dao<CountryDTO, String> countryDAO = getDao();
        QueryBuilder<CountryDTO, String> queryBuilder = countryDAO.queryBuilder();
        Where<CountryDTO, String> where = queryBuilder.where();
        SelectArg selectArg = new SelectArg();
        selectArg.setValue(continent);
        where.in("continent", selectArg);

        return queryBuilder.prepare();
    }

    public void printResult(PreparedQuery prep) throws SQLException {
        List<CountryDTO> country = getDao().query(prep);
        for (int i = 0; i < country.size(); i++) {
            System.out.println("Country Name: " + country.get(i).getName() + " \n population: " + country.get(i).getPopulation()
                    + "\n Life Expectancy: " + country.get(i).getLifeExpectancy()+ "\n");
        }
    }

    public int create(String code,String name, String continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy,
                      float Gnp, float GnpOld) throws SQLException {
        Dao<CountryDTO,String> newCountry = getDao();
        CountryDTO newCreatedCountryDTO = new CountryDTO();

        newCreatedCountryDTO.getCode();

    }
    public void read(PreparedQuery prepR){

    }
    public void update(PreparedQuery prepU){

    }
    public void delete(PreparedQuery prepD){

    }

}
