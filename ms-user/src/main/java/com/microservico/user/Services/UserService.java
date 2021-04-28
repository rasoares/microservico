package com.microservico.user.Services;

import com.microservico.user.Entidades.User;
import com.microservico.user.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserRepository repo;

    public User findByEmail (String email){

        Optional<User> user = Optional.of(repo.findByEmail(email));
        return user.orElse(null);
    }

//    public User findByCpf (String cpf){
//        Optional<User> user = Optional.of(repo.findByCpf(cpf));
//        return user.orElse(null);
//    }

    public User findById (Long id){
        Optional<User> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
