package pl.camp.it.rest.clinet;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.camp.it.rest.clinet.model.User;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        /****** GET ******/
        String URL = "http://localhost:8080/cos2";

        User user = restTemplate.getForObject(URL, User.class, new HashMap<>());

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getSurname());

        /****** POST *******/
        String URL2 = "http://localhost:8080/cos4";

        User user1 = new User();
        user1.setId(1);
        user1.setName("Mateusz");
        user1.setSurname("Kowalski");
        user1.setAge(20);

        User user3 = restTemplate.postForObject(URL2, user1, User.class, new HashMap<>());
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getSurname());
        System.out.println(user3.getAge());

        /***** HttpEntity *****/
        //String URL3 = generateURL(5,10);

        /*Map<String, String> queryParams = new HashMap<>();
        queryParams.put("parametr1", "abcd");
        queryParams.put("parametr2", "efgh");*/
        String URL4 = "http://localhost:8080/user/{id}/{id2}";

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("id", "5");
        uriParams.put("id2", "10");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(URL4)
                .queryParam("parametr1", "abcd")
                .queryParam("parametr2", "efgh")
                .build();


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("naglowek1", "n1");
        httpHeaders.add("naglowek2", "n2");

        HttpEntity<User> httpEntity = new HttpEntity<>(user3, httpHeaders);
        ResponseEntity<User> odpowiedz = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.POST, httpEntity, User.class, uriParams);

        if(odpowiedz.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("asdf");
        }
        User user4 = odpowiedz.getBody();

        System.out.println(user4.getId());
        System.out.println(user4.getAge());
        System.out.println(user4.getName());
        System.out.println(user4.getSurname());
    }

    private static String generateURL(int id, int id2) {
        return "http://localhost:8080/user/" + id + "/" + id2 + "?parametr1=abcd&parametr2=efgh";
    }
}
