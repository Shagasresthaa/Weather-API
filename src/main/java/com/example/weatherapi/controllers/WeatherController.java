package com.example.weatherapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.weatherapi.exceptions.*;
import com.example.weatherapi.models.WeatherData;
import com.example.weatherapi.services.WeatherService;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // POST Actions

    // Save Weather Data
    // Throw exception if required fields are missing
    // Throw exception if node not found
    // Throw exception if node api key is invalid
    @PostMapping("/weather")
    public WeatherData saveWeatherData(@RequestBody WeatherData weatherData, @RequestHeader(value="auth") String auth) throws Exception {
        try {
            return weatherService.saveWeatherData(weatherData, auth);
        } catch(EmptyFieldException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch(NodeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(InvalidNodeApiKeyException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // GET Actions

    // Get Weather Data by Node ID
    // Throw exception if node not found
    // Throw exception if node api key is invalid

    @GetMapping("/weather/{id}")
    public List<WeatherData> getWeatherData(@PathVariable long id, @RequestHeader(value="auth") String auth, @RequestHeader(value="uid") int uid) throws Exception {
        try {
            return weatherService.getWeatherData(id, auth, uid);
        } catch(NodeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(InvalidNodeApiKeyException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // Get all Weather Data
    // Throw exception if API key is invalid
    @GetMapping("/weather")
    public List<WeatherData> getAllWeatherData(@RequestHeader(value="auth") String auth, @RequestHeader(value="uid") int uid) throws Exception {
        try {
            return weatherService.getAllWeatherData(auth, uid);
        } catch(InvalidNodeApiKeyException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // DELETE Actions

    // Delete Weather Data by Node ID
    // Throw exception if node not found
    // Throw exception if node api key is invalid

    @DeleteMapping("/weather/{id}/delete")
    public void deleteWeatherData(@PathVariable long id, @RequestHeader(value="auth") String auth, @RequestHeader(value="uid") int uid) throws Exception {
        try {
            weatherService.deleteWeatherData(id, auth, uid);
        } catch(NodeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(InvalidUserApiKeyException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        } catch(NotAdminException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        } catch(DataDeletedSuccessfullyException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage());
        } catch(DataNotDeletedException e) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, e.getMessage());
        }
    }    
}
