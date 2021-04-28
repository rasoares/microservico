package com.microservico.user.Resources;

import com.microservico.user.Entidades.User;
import com.microservico.user.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value= "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)
    {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value= "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email)
    {
        User user = service.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }

//    @GetMapping(value= "/searchCpf")
//    public ResponseEntity<User> findByCpf(@RequestParam String cpf)
//    {
//        User user = service.findByCpf(cpf);
//        return ResponseEntity.ok().body(user);
//    }

}
