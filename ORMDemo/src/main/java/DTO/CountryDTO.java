package DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mads-power on 30.10.2017.
 */
@DatabaseTable(tableName = "country")
public class CountryDTO {
    @DatabaseField(id = true)
    private String code;
    @DatabaseField
    private String name;
    @DatabaseField
    private String continent;
    @DatabaseField
    private String region;
    @DatabaseField
    private float surfaceArea;
    @DatabaseField
    private int indepYear;
    @DatabaseField
    private int population;
    @DatabaseField
    private float lifeExpectancy;
    @DatabaseField
    private float Gnp;
    @DatabaseField
    private float GnpOld;

    @DatabaseField
    private String localName;
    @DatabaseField
    private String headOfState;
    @DatabaseField
    private String capital;
    @DatabaseField
    private String code2;

    public CountryDTO(){}

    public CountryDTO(String code, String name, String continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float gnp, float gnpOld, String localName, String headOfState, String capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        Gnp = gnp;
        GnpOld = gnpOld;
        this.localName = localName;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGnp() {
        return Gnp;
    }

    public void setGnp(float gnp) {
        Gnp = gnp;
    }

    public float getGnpOld() {
        return GnpOld;
    }

    public void setGnpOld(float gnpOld) {
        GnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
