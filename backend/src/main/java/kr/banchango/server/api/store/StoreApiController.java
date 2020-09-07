package kr.banchango.server.api.store;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Arrays;
import java.util.List;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.PageRequest;
import kr.banchango.server.api.common.ResponseDTO;
import kr.banchango.server.api.product.ProductDto;
import kr.banchango.server.domain.store.StoreStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"상점"},description = "상점에 대한 정보를 제공 합니다.")
@Slf4j
@RestController
public class StoreApiController extends AbstractApiController {

  @ApiOperation(value = "상점 상품 조회",notes = "가게의 상품을 요청합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = StoreDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/stores/{storeId}")
  public Mono<ResponseDTO> stores(@PathVariable Long storeId, PageRequest page) {
    return makeStore();
  }

  private Mono makeStore() {
    List<StoreDto> list = Arrays.asList(
        StoreDto.builder()
            .status(StoreStatus.ENABLE)
            .storeId(1l)
            .name("store1")
            .thumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .address(StoreAddressDto.builder()
                .address("address1")
                .latitude(32.1)
                .longitude(34.5)
                .build())
            .productDtos(Arrays.asList(
                ProductDto.builder()
                    .description("product 1")
                    .wishs(11l)
                    .name("product")
                    .price(10000)
                    .productId(1l)
                    .ratings(3.5)
                    .reviews(12l)
                    .images(Arrays.asList(
                        "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                        "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
                    ))
                    .build(),
                ProductDto.builder()
                    .description("product 2")
                    .wishs(1l)
                    .name("product2")
                    .price(20000)
                    .productId(2l)
                    .ratings(4.5)
                    .reviews(3l)
                    .images(Arrays.asList(
                        "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                        "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
                    ))
                    .build()
            ))
            .build()
    );

    return Mono.just(
        ResponseDTO.success(list)
    );
  }
}
