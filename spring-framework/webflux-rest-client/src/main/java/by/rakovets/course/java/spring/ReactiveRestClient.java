package by.rakovets.course.java.spring;

import by.rakovets.course.java.spring.dto.Greeting;
import by.rakovets.course.java.spring.dto.Tweet;
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

    public static void main(String[] args) throws InterruptedException {
        Flux<Greeting> greetingFlux = WebClient.create()
                .get()
                .uri("http://localhost:8081/greeting")
                .retrieve()
                .bodyToFlux(Greeting.class);
        System.out.println("Next code");
        greetingFlux.subscribe(greeting -> System.out.println(greeting.toString()));
        Thread.sleep(3000);
        System.out.println("Last code");
    }
}
