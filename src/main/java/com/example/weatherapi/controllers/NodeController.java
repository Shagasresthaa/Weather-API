package com.example.weatherapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.weatherapi.exceptions.*;
import com.example.weatherapi.models.Nodes;
import com.example.weatherapi.services.NodeService;

@RestController
public class NodeController {
    @Autowired
    private NodeService nodeService;

    //POST Methods

    // Create a new node
    // Throw exception if required fields are missing
    // Throw exception if node already exists
    // Else return node
    @PostMapping("/nodes")
    public Nodes createNode(@RequestBody Nodes node) throws Exception {
        try{
            return nodeService.saveNode(node);
        } catch(EmptyFieldException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        } catch(NodeAlreadyExists e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    //GET Methods

    // Get all nodes
    // Return list of nodes
    @GetMapping("/nodes")
    public List<Nodes> getAllNodes() throws Exception {
        try {
            return nodeService.getAllNodes();
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // Get a specific node
    // Throw exception if node not found
    // Else return node
    @GetMapping("/nodes/{id}")
    public Nodes getNode(@PathVariable long id) throws Exception {
        try {
            return nodeService.getNode(id);
        } catch(NodeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // PUT Methods

    // Update an existing node
    // Throw exception if required fields are missing
    // Throw exception if node not found
    // Else return node
    @PutMapping("/nodes/{id}")
    public Nodes updateNode(@PathVariable int id, @RequestBody Nodes node) throws Exception {
        try {
            return nodeService.updateNode(id, node);
        } catch(NodeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(EmptyFieldException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    //DELETE Methods

    // Delete a node
    // Throw exception if node not found
    // Else return node
    @DeleteMapping("/nodes/{id}")
    public ResponseEntity<String> deleteNode(@PathVariable long id) throws Exception {
        try {
            final HttpHeaders httpHeaders= new HttpHeaders();
    		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			nodeService.deleteNode(id);
            try {
                Nodes node = nodeService.getNode(id);
                return new ResponseEntity<String>("{\"message\": \"Node Deletion Failed\"}", httpHeaders, HttpStatus.CONFLICT);
            } catch(NodeNotFoundException e) {
                return new ResponseEntity<String>("{\"message\": \"Node Deleted Successfully\"}", httpHeaders, HttpStatus.ACCEPTED);
            }
			
        } catch(NodeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
