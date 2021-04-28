package com.microservico.oauth.FeignClients;

import com.microservico.oauth.Entidades.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name="ms-user", path = "/v1/users")
public interface UserFeignClient {

    @GetMapping(value= "/search")
    ResponseEntity<User> findByEmail(@RequestParam String email);

}
