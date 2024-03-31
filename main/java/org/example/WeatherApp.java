package org.example;

import org.example.dao.WeatherDao;
import org.example.entity.WeatherData;
import org.example.impl.WeatherDaoImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) {

//        //css query language
        try {
            Document page = getPage();

            System.out.println(page);

            // Извлечение города
            String city = page.select(".page-title").text();
            System.out.println("Локация: " +  city );

            // Извлечение даты и времени
            String dateTime = page.select(".now-localdate").text();
            System.out.println("Дата и время: " + dateTime);

            // Извлечение температуры
            String temperature = page.select(".now-weather " +
                    ".unit_temperature_c").text();
            System.out.println("Температура: " + temperature + "°C");

            // Извлечение температуры по ощущению
            String feelTemperature = page.select(".now-feel " +
                    ".unit_temperature_c").text();
            System.out.println("Температура по ощущению: " + feelTemperature + "°C");

            // Извлечение информации о ветре
            String wind = page.select(".now-info-item.wind " +
                    ".unit_wind_m_s").text();
            System.out.println("Ветер: " + wind);

            // Извлечение информации о давлении
            String pressure = page.select(".now-info-item.pressure " +
                    ".unit_pressure_mm_hg").text();
            System.out.println("Давление: " + pressure);

            WeatherDao weatherDao = new WeatherDaoImpl();

            WeatherData weatherData = new WeatherData(city,
                    dateTime, temperature, feelTemperature, wind, pressure);

            WeatherData weatherData2 = new WeatherData(city,
                    dateTime, temperature, feelTemperature, wind, pressure);

            weatherDao.create(weatherData);
            weatherDao.create(weatherData2);

            System.out.println("Получаем нашу погоду: "+weatherDao.readById(0));
            System.out.println("Получаем нашу погоду: "+weatherDao.readById(1));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.ru/weather-ryazan-4394/now/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

}