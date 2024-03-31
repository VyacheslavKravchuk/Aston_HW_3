package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Weather_in_the_city")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "date_and_time")
    private String dateTime;

    @Column(name = "temperature", nullable = false, length = 50)
    private String temperature;

    @Column(name = "feel_temperature", nullable = false, length = 50)
    private String feelTemperature;

    @Column(name = "wind", nullable = false, length = 50)
    private String wind;

    @Column(name = "pressure", nullable = false, length = 50)
    private String pressure;

    public WeatherData() {
    }

    public WeatherData(String city, String dateTime, String temperature,
                       String feelTemperature, String wind, String pressure) {
        this.city = city;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.feelTemperature = feelTemperature;
        this.wind = wind;
        this.pressure = pressure;
    }

    public WeatherData(int id, String city, String dateTime, String temperature,
                       String feelTemperature, String wind, String pressure) {
        this.id = id;
        this.city = city;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.feelTemperature = feelTemperature;
        this.wind = wind;
        this.pressure = pressure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(String feelTemperature) {
        this.feelTemperature = feelTemperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", temperature='" + temperature + '\'' +
                ", feelTemperature='" + feelTemperature + '\'' +
                ", wind='" + wind + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
