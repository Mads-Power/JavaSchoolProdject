package DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mads-power on 30.10.2017.
 */
@DatabaseTable(tableName = "city")
public class CityDTO {
    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String Countrycode;
    @DatabaseField
    private String district;
    @DatabaseField
    private String population;



    public CityDTO() {
    }
    public CityDTO(Integer id, String name, String countrycode, String district, String population) {
        this.id = id;
        this.name = name;
        Countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountrycode() {
        return Countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public String getPopulation() {
        return population;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountrycode(String countrycode) {
        Countrycode = countrycode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
