package org.example.dao;

import org.example.entity.WeatherData;

import java.util.List;
import java.util.Optional;

public interface WeatherDao {

    List<WeatherData> findAll();

    WeatherData create(WeatherData weatherData);
    Optional<WeatherData> readById(int id);
    WeatherData updateAmountById(WeatherData weatherData);
    Optional<WeatherData> deleteById(WeatherData weatherData);
}

