package pl.camp.it.rest.clinet.rest;

import org.springframework.web.client.RestTemplate;
import pl.camp.it.rest.clinet.model.User;

import java.util.HashMap;

public class Client {
    RestTemplate restTemplate = new RestTemplate();
    public User cos2() {
        /****** GET ******/
        String URL = "http://localhost:8080/cos2";

        User user = restTemplate.getForObject(URL, User.class, new HashMap<>());

        return user;
    }

    public User cos4() {
        String URL2 = "http://localhost:8080/cos4";

        User user1 = new User();
        user1.setId(1);
        user1.setName("Mateusz");
        user1.setSurname("Kowalski");
        user1.setAge(20);

        User user3 = restTemplate.postForObject(URL2, user1, User.class, new HashMap<>());
        return user3;
    }
}
