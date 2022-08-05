package com.example.weatherapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.weatherapi.models.Nodes;

@Repository
public interface NodesRepository extends JpaRepository<Nodes, Long> {

    Nodes findByNodeId(long nodeId);

}
