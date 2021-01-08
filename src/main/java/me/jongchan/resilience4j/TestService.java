package me.jongchan.resilience4j;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
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
