package me.jongchan.resilience4j;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.io.IOException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TestService {

  private static final String TEST_CIRCUIT_BREAKER = "testCircuitBreaker";

  @CircuitBreaker(name = TEST_CIRCUIT_BREAKER, fallbackMethod = "fallback")
  public Mono<String> getHello() {
    return Mono.error(new IOException());
  }

  /**
   * Before Circuit becomes open
   * @param e
   * @return
   */
  private Mono<String> fallback(IOException e) {
    return Mono.just("fallback");
  }

  /**
   * When Circuit is open
   * @param e
   * @return
   */
  private Mono<String> fallback(CallNotPermittedException e) {
    return Mono.just("CallNotPermittedException Working");
  }
}
