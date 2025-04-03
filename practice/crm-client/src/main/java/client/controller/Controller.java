package client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/com")
public class Controller {
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/user")
    public String getuser(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/com/hello", String.class);
        String body = forEntity.getBody();
        System.out.println(body);
        return body;
    }

    @GetMapping("/users")
    public String getusers(){
        int id =0;
        String user = restTemplate.getForObject("http://localhost:8080/com/getUsers", String.class);
        System.out.println(user);
        return user;
    }
}
