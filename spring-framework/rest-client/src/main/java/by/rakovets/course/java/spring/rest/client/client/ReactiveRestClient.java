package by.rakovets.course.java.spring.rest.client.client;

import by.rakovets.course.java.spring.rest.client.dto.Tweet;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class ReactiveRestClient {
    public Flux<Tweet> getTweetsNonBlocking() {
        Flux<Tweet> tweetFlux = WebClient.create()
                .get()
                .uri("http://localhost:8080/api/tweet")
                .retrieve()
                .bodyToFlux(Tweet.class);

        tweetFlux.subscribe(tweet -> System.out.println(tweet.toString()));
        return tweetFlux;
    }
}
