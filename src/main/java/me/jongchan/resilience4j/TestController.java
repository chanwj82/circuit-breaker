package me.jongchan.resilience4j;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping("test")
  public Mono<String> getHello() throws IOException {
    return testService.getHello();
  }
}
