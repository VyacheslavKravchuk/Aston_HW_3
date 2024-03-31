package org.example;

import org.example.dao.WeatherDao;
import org.example.entity.WeatherData;
import org.example.impl.WeatherDaoImpl;

public class Main {

    public static void main(String[] args) {
        WeatherDao weatherDao = new WeatherDaoImpl();

        WeatherData weatherData = new WeatherData("city",
                "dateTime", "temperature", "feelTemperature",
                "wind", "pressure");

        WeatherData weatherData2 = new WeatherData("city",
                "dateTime", "temperature", "feelTemperature",
                "wind", "pressure");

        weatherDao.create(weatherData);
        weatherDao.create(weatherData2);

        System.out.println("Получаем нашу погоду: "+weatherDao.readById(0));
        System.out.println("Получаем нашу погоду: "+weatherDao.readById(1));
    }
}
