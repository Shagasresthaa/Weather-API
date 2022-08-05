package com.example.weatherapi.services;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherapi.exceptions.*;
import com.example.weatherapi.models.Nodes;
import com.example.weatherapi.repositories.NodesRepository;

@Service
public class NodeService {
    
    @Autowired
    private NodesRepository nodeRepository;

    // Create a new node
    // Throw exception if required fields are missing
    // Throw exception if node already exists
    // Else return node
    public Nodes saveNode(Nodes node) throws Exception {
        Boolean usr = nodeRepository.findByNodeId(node.getNodeId()) != null;
        if(node.getNodeMacAddress() == null || node.getNodeGpsAltitude() == null || node.getNodeGpsLatitude() == null || node.getNodeGpsLongitude() == null) {
            throw new EmptyFieldException("Required fields are missing");
        }
        else if(usr){
            throw new NodeAlreadyExists("Node already exists");
        }
        else {

            node.setNodeId(nodeIdGenerator());
            node.setNodeApiKey(apiKeyGenerator());
            return nodeRepository.save(node);
        }
    }

    // Generate random Node ID
    // Return generated Node ID
    // Regenerate Node ID if it already exists
    // Additional Work Required:
    public long nodeIdGenerator(){
        long id = 100000000 + (int)(Math.random() * ((999999999 - 100000000) + 1));
        if(nodeRepository.findByNodeId(id) != null){
            return nodeIdGenerator();
        }
        else {
            return id;
        }
    }

    // Generate random API Key
    // Additional Work Required:
    public String apiKeyGenerator(){
        return RandomStringUtils.randomAlphanumeric(64);
    }

    // Get all nodes
    public List<Nodes> getAllNodes() {
        return nodeRepository.findAll();
    }

    // Get a specific node
    // Throw exception if node not found
    // Else return node
    public Nodes getNode(long id) throws Exception {
        Nodes node = nodeRepository.findByNodeId(id);
        if(node == null){
            throw new NodeNotFoundException("Node Not Found");
        }
        else {
            return node;
        }
    }

    // Update an existing node
    // Throw exception if node not found
    // Else return updated node
    public Nodes updateNode(int id, Nodes node) throws Exception{
        Nodes dbNode = nodeRepository.findByNodeId(id);
        if(dbNode == null){
            throw new NodeNotFoundException("Node Not Found");
        }
        else {
            return nodeRepository.save(node);
        }
    }

    // Delete a node
    // Throw exception if node not found
    // Else return deleted node
    public Nodes deleteNode(long id) throws Exception{
        Nodes node = nodeRepository.findByNodeId(id);
        if(node == null){
            throw new NodeNotFoundException("Node Not Found");
        }
        else {
            nodeRepository.delete(node);
            return node;
        }
    }

    
}
