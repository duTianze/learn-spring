package com.dutianze.guide.flux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GreetingWebClient {
	private WebClient client = WebClient.create("http://localhost:8081");

	private Mono<ClientResponse> result = client.get()
			.uri("/hello")
			.accept(MediaType.TEXT_PLAIN)
			.exchange();

	public String getResult() {
		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
