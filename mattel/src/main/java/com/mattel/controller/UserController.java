package com.mattel.controller;
import com.mattel.exception.UserException;
import com.mattel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<Object> login(@PathVariable String email, @PathVariable String password){
        try {
            return new ResponseEntity<Object>(userService.login(email, password), HttpStatus.OK);
        }catch(UserException e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
