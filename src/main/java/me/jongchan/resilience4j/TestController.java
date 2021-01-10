package me.jongchan.resilience4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping("fail")
  public Mono<String> getFailHello() {
    return testService.getFailHello();
  }

  @GetMapping("success")
  public Mono<String> getSuccessHello() {
    return testService.getSuccessHello();
  }
}
