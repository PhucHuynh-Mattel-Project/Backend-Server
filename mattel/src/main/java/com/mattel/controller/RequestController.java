package com.mattel.controller;

import com.mattel.exception.UserException;
import com.mattel.model.Request;
import com.mattel.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/request")
    public ResponseEntity<Object> submitRequest(@RequestBody Request request) {
        try {
            return new ResponseEntity<Object>(requestService.submitRequest(request), HttpStatus.OK);
        }catch(UserException e)
        {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/adjust-status/{requestId}/{status}")
    public ResponseEntity<Object> adjustRequestStatus(@PathVariable int requestId, @PathVariable String status){
        try {
            return new ResponseEntity<Object>(requestService, HttpStatus.OK);
        }catch(UserException e)
        {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/requests/{status}")
    public ResponseEntity<Object> getRequests(@PathVariable String status){
        try {
            return new ResponseEntity<Object>(requestService.getRequests(status), HttpStatus.OK);
        }catch(UserException e)
        {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
