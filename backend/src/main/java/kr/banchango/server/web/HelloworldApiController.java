package kr.banchango.server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloworldApiController{

  @GetMapping("/hello")
  public Mono hello(){
    return Mono.just("hello");
  }

}
