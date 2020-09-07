package kr.banchango.server.api.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Arrays;
import java.util.List;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.PageInfo;
import kr.banchango.server.api.common.ResponseDTO;
import kr.banchango.server.api.common.SearchParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"상품"},description = "상품에 대한 정보를 제공 합니다.")
@Slf4j
@RestController
public class ProductApiController extends AbstractApiController {

  @ApiOperation(value = "상품 리스트 조회",notes = "페이징 형태의 상품 정보 를 제공 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ProductDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/products")
  public Mono<ResponseDTO> products(SearchParam search) {
    return makeProducts();
  }

  @ApiOperation(value = "상품 상세보기 ",notes = "\n 상품 상세 정보")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ProductDetailDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/products/detail/{productId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> detail(@PathVariable Long productId) {
    return Mono.just(ResponseDTO.success(
        ProductDetailDto.builder()
            .storeName("대박이")
            .description("상세 설명.상세 설명.상세 설명.상세 설명.상세 설명")
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .addWish(true)
            .name("해물김치찌개")
            .price(20000l)
            .wishs(11l)
            .productId(productId)
            .storeId(1l)
            .ratings(3.5)
            .reviews(100l)
            .build()
    ));
  }

  private Mono makeProducts(){
    List<ProductDto> productList= Arrays.asList(
        ProductDto.builder()
            .description("product 1")
            .wishs(11l)
            .name("product")
            .storeName("대박이네")
            .price(10000)
            .productId(1l)
            .storeId(1l)
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .ratings(3.5)
            .addWish(true)
            .reviews(100l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build(),
        ProductDto.builder()
            .description("product 2")
            .wishs(2l)
            .storeName("대박이네2")
            .name("product2")
            .price(20000)
            .productId(2l)
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .storeId(1l)
            .ratings(4.5)
            .addWish(true)
            .reviews(100l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build(),
        ProductDto.builder()
            .description("product 2")
            .wishs(2l)
            .name("product2")
            .storeName("대박이네3")
            .price(20000)
            .productId(3l)
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .storeId(1l)
            .ratings(4.5)
            .reviews(100l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build(),
        ProductDto.builder()
            .description("product 2")
            .wishs(2l)
            .storeName("대박이네4")
            .name("product2")
            .price(20000)
            .productId(4l)
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .storeId(1l)
            .ratings(4.5)
            .reviews(100l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build(),
        ProductDto.builder()
            .description("product 2")
            .storeName("대박이네5")
            .wishs(2l)
            .name("product2")
            .price(20000)
            .productId(5l)
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .storeId(1l)
            .ratings(4.5)
            .reviews(100l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build(),
        ProductDto.builder()
            .description("product 2")
            .storeName("대박이네6")
            .wishs(2l)
            .name("product2")
            .price(20000)
            .productId(6l)
            .storeId(1l)
            .storeThumbnail("https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg")
            .ratings(4.5)
            .reviews(100l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build()
    );

    return Mono.just(ResponseDTO.success(productList, PageInfo.builder().totalPage(12).totalElement(120).build()));
  }
}
