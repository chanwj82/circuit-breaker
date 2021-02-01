package me.jongchan.resilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  private final TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("fail")
  public Mono<String> getFailHello() {
    return testService.getFailHello();
  }

  @GetMapping("success")
  public Mono<String> getSuccessHello() {
    return testService.getSuccessHello();
  }

  @GetMapping("data")
  public Mono<String> getDataFromRemoteServer() {
    return testService.getDataFromRemoteServer();
  }

}
