package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.WeatherData;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<WeatherData, Integer> {

            List<WeatherData> findAllById(Integer id);
}
