package com.microservico.oauth.Services;

import com.microservico.oauth.Entidades.User;
import com.microservico.oauth.FeignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    private static Logger logger = LoggerFactory.getLogger(Service.class);

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("Email não existe" + email);
            throw new IllegalArgumentException("Email não existe");
        }
        logger.info("Email existente" +email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        User user = userFeignClient.findByEmail(username).getBody();
        if(user == null) {
            logger.error("Email não existe" + username);
            throw new UsernameNotFoundException("Email não existe");
        }
        logger.info("Email existente" + username);
        return user;
    }
}
