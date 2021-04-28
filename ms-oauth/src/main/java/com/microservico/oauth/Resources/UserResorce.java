package com.microservico.oauth.Resources;

import com.microservico.oauth.Entidades.User;
import com.microservico.oauth.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value="/v1/users")
public class UserResorce {

    @Autowired
    private UserService service;

    @GetMapping(value="/search")
    public ResponseEntity<UserDetails> findByEmail(@RequestParam String email){

        try {
            UserDetails user = service.loadUserByUsername(email);
            return ResponseEntity.ok().body(user);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
