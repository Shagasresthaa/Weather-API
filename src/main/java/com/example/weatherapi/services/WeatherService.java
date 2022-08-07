package com.example.weatherapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherapi.exceptions.*;
import com.example.weatherapi.models.Users;
import com.example.weatherapi.models.Nodes;
import com.example.weatherapi.models.WeatherData;
import com.example.weatherapi.repositories.WeatherDataRepository;
import com.example.weatherapi.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import com.example.weatherapi.repositories.NodesRepository;

@Service
public class WeatherService {

    @Autowired
    private WeatherDataRepository weatherRepository;
    @Autowired
    private NodesRepository nodeRepository;
    @Autowired
    private UserRepository userRepository;

    // Save Weather Data
    // Throw exception if required fields are missing
    // Throw exception if node not found
    // Throw exception if node api key is invalid
    public WeatherData saveWeatherData(WeatherData weatherData, String auth) throws Exception {
        if(weatherData.getNodeIPAddress() == null || weatherData.getNodeTimeStamp() == null) {
            throw new EmptyFieldException("Required fields are missing");
        }
        else if(!(nodeRepository.findByNodeId(weatherData.getNodeId()) != null)){
            throw new NodeNotFoundException("Node not found");
        } else if(!(nodeRepository.findByNodeId(weatherData.getNodeId()).getNodeApiKey().equals(auth))) {
            throw new InvalidNodeApiKeyException("Invalid node api key");
        }
        else {
            weatherRepository.save(weatherData);
            return weatherData;
        }
    }

    // Get Weather Data by Node ID
    // Throw exception if node not found
    // Throw exception if node api key is invalid

    public List<WeatherData> getWeatherData(long id, String auth, int uid) throws Exception {
        Optional<Users> user = userRepository.findById(uid);
        if(user == null ){
            throw new UserNotFoundException("User not found");
        } else if(!user.get().getUserAccessKey().equals(auth)) {
            throw new InvalidUserApiKeyException("Invalid user api key");
        } else {
            if(!(nodeRepository.findByNodeId(id) != null)) {
                throw new NodeNotFoundException("Node not found");
            } else {
                return weatherRepository.findAllByNodeId(id);
            }
        }
        
    }

    // Get Weather Data 
    // Throw exception if API key is invalid

    public List<WeatherData> getAllWeatherData(String auth, int uid) throws Exception {
        Optional<Users> user = userRepository.findById(uid);
        if(user == null ){
            throw new UserNotFoundException("User not found");
        } else if(!user.get().getUserAccessKey().equals(auth)) {
            throw new InvalidUserApiKeyException("Invalid user api key");
        } else {
            return weatherRepository.findAll();
        }
    }

    // Delete Weather Data by Node ID
    // Throw exception if node not found
    // Throw exception if node api key is invalid

    public void deleteWeatherData(long id, String auth, int uid) throws Exception {
        Optional<Users> user = userRepository.findById(uid);
        if(user == null ){
            throw new UserNotFoundException("User not found");
        } else if(!user.get().getUserAccessKey().equals(auth)) {
            throw new InvalidUserApiKeyException("Invalid user api key");
        } else if(!user.get().getUserAdmin()){
            throw new NotAdminException("User is not admin");
        } else {
            if(!(nodeRepository.findByNodeId(id) != null)) {
                throw new NodeNotFoundException("Node not found");
            } else {
                nodeRepository.deleteById(id);
                List<WeatherData> data = weatherRepository.findAllByNodeId(id);
                weatherRepository.deleteAll(data);

                Optional<Nodes> node1 = nodeRepository.findById(id);
                List<WeatherData> data1 = weatherRepository.findAllByNodeId(id);

                if(node1.isEmpty() && data1.isEmpty()) {
                    throw new DataDeletedSuccessfullyException("Data deleted successfully");
                } else {
                    throw new DataNotDeletedException("Data not deleted");
                }

            }
        }
    }
}

