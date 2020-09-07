package kr.banchango.server.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.net.URI;
import java.util.Optional;
import kr.banchango.server.api.common.ResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableOpenApi
public class SwaggerConfig {
  @Bean
  public Docket apiConfig() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("version_1.0")
        .enable(true)
        .select()
        .apis(RequestHandlerSelectors.basePackage("kr.banchango.server.api"))
        //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build()
        .genericModelSubstitutes(Optional.class, Flux.class, Mono.class, ResponseDTO.class)
        .apiInfo(
            new ApiInfoBuilder()
                .version("version 1")
                .title("BanchanGo API Documents")
                .description("Banchango API 문서 입니다. \n api 서버 문제 발생시 <admin@banchango.com> 으로 문의 바랍니다.")
                .version("v_1")
                .build());
  }

  @Bean
  RouterFunction<ServerResponse> routerFunction() {
    return  route(GET("/api"), req ->
        ServerResponse.temporaryRedirect(URI.create("/swagger-ui/index.html"))
            .build());
  }
}