package kr.banchango.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
//    SpringApplication application = new SpringApplication(ServerApplication.class);
//    application.setWebApplicationType(WebApplicationType.REACTIVE);
//    // starter-web은 SERVLET으로 자동으로 선택한다. 이것을 강제로 REACTIVE로 바꾼다.
//    application.run(args);
  }

}
