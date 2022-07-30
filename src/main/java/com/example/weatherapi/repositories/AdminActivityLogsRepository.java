package com.example.weatherapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminActivityLogsRepository extends JpaRepository<AdminActivityLogs, Long> {

}
