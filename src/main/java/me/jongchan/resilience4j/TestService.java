package me.jongchan.resilience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.io.IOException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TestService {

  private static final String TEST_CIRCUIT_BREAKER = "testCircuitBreaker";

  @CircuitBreaker(name = TEST_CIRCUIT_BREAKER, fallbackMethod = "fallback")
  public Mono<String> getHello() throws IOException {
    throw new IOException();
//    return Mono.just("Hello");
  }

  private Mono<String> fallback(IOException e) {
    return Mono.just("fallback");
  }
}
