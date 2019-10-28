package lukasz.nowogorski.SpringBoot.Json.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;

public class Weather {

    private int id;

@JsonProperty("temperature")
    private int temp;

@JsonProperty("kind of Weather")
    private String kindOfWeather;

@JsonIgnore
    private String country;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private DateFormat date;

    private int lenght;

    public Weather(int id, int temp, String kindOfWeather, String country, DateFormat date, int lenght) {
        this.id = id;
        this.temp = temp;
        this.kindOfWeather = kindOfWeather;
        this.country = country;
        this.date = date;
        this.lenght = lenght;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getKindOfWeather() {
        return kindOfWeather;
    }

    public void setKindOfWeather(String kindOfWeather) {
        this.kindOfWeather = kindOfWeather;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public DateFormat getDate() {
        return date;
    }

    public void setDate(DateFormat date) {
        this.date = date;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
