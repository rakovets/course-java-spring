package by.rakovets.course.java.spring.rest.client.client;

import by.rakovets.course.java.spring.rest.client.dto.Greeting;
import by.rakovets.course.java.spring.rest.client.dto.Tweet;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BlockingRestClient {
    public List<Tweet> getTweetsBlocking() {
        final String uri = "http://localhost:8080/api/tweet";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Tweet>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Tweet>>() {
                });

        List<Tweet> result = response.getBody();
        result.forEach(tweet -> System.out.println(tweet.toString()));
        return result;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        restTemplate.setMessageConverters(List.of(converter));
        ResponseEntity<Greeting> responseEntity = restTemplate.getForEntity("http://localhost:8081/greeting", Greeting.class);
        System.out.println(responseEntity);
    }
}
