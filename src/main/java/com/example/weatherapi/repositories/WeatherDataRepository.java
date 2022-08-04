package com.example.weatherapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.weatherapi.models.WeatherData;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

}
