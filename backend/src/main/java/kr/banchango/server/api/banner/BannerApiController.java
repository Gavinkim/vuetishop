package kr.banchango.server.api.banner;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Arrays;
import java.util.List;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.ResponseDTO;
import kr.banchango.server.domain.banner.BannerLinkType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"배너"},description = "배너 정보를 제공 합니다.")
@Slf4j
@RestController
public class BannerApiController extends AbstractApiController {

  @ApiOperation(value = "배너 리스트 조회",notes = "배너 리스트 를 요청합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = BannerDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/banners")
  public Mono<ResponseDTO> banners() {
    return makeBanners();
  }

  private Mono makeBanners(){
    List<BannerDto> bannerList= Arrays.asList(
        BannerDto.builder()
            .bannerId(1l)
            .image("https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg")
            .link("https://naver.com")
            .type(BannerLinkType.OUT)
            .build(),
        BannerDto.builder()
            .bannerId(2l)
            .image("https://cdn.vuetifyjs.com/images/carousel/sky.jpg")
            .link("https://daum.net")
            .type(BannerLinkType.IN)
            .build(),
        BannerDto.builder()
            .bannerId(3l)
            .image("https://cdn.vuetifyjs.com/images/carousel/bird.jpg")
            .link("https://daum.net")
            .type(BannerLinkType.IN)
            .build(),
        BannerDto.builder()
            .bannerId(4l)
            .image("https://cdn.vuetifyjs.com/images/carousel/planet.jpg")
            .link("https://daum.net")
            .type(BannerLinkType.IN)
            .build(),
        BannerDto.builder()
            .bannerId(5l)
            .image("https://images.pexels.com/photos/929245/pexels-photo-929245.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
            .link("https://ncsoft.com")
            .type(BannerLinkType.OUT)
            .build()
    );

    return Mono.just(ResponseDTO.success(bannerList));
  }
}
