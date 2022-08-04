package com.example.weatherapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.weatherapi.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUserEmail(String userEmail);

}
