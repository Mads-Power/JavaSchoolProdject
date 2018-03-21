package DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mads-power on 30.10.2017.
 */
@DatabaseTable(tableName = "countryLanguage")
public class CountryLanguageDTO {
    @DatabaseField
    private String countryCode;
    @DatabaseField
    private String language;
    @DatabaseField
    private char isOffical;
    @DatabaseField
    private float percentage;

    public CountryLanguageDTO(){}

    public CountryLanguageDTO(String countryCode, String language, char isOffical, float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOffical = isOffical;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return countryCode;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public char getIsOffical() {
        return isOffical;
    }

    public void setIsOffical(char isOffical) {
        this.isOffical = isOffical;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
