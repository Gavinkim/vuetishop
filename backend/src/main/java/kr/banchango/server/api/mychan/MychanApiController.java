package kr.banchango.server.api.mychan;

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
import kr.banchango.server.api.product.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"마이찬"},description = "사용자 의 주문/장바구니/위시 내역을 보여줍니다.")
@Slf4j
@RestController
public class MychanApiController extends AbstractApiController {

  @ApiOperation(value = "주문 내역 조회", notes = "페이징 형태의 상품 정보 를 제공 합니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ProductDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/mychan/orders")
  public Mono<ResponseDTO> mychanOrders(SearchParam search) {
    return makeProducts();
  }

  @ApiOperation(value = "위시 리스트 조회 ", notes = "페이징 형태의 상품 정보 를 제공 합니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ProductDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/mychan/wish")
  public Mono<ResponseDTO> mychanWish(SearchParam search) {
    return makeWishList();
  }

  @ApiOperation(value = "장바 구니 조회 ", notes = "페이징 형태의 상품 정보 를 제공 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ProductDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/mychan/cart")
  public Mono<ResponseDTO> mychanCart(SearchParam search) {
    return makeProducts();
  }


  private Mono makeWishList(){
    List<ProductDto> productList= Arrays.asList(
        ProductDto.builder()
            .description("product 1")
            .name("product")
            .price(10000)
            .productId(1l)
            .storeId(1l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build(),
        ProductDto.builder()
            .description("product 2")
            .name("product2")
            .price(20000)
            .productId(2l)
            .storeId(1l)
            .images(Arrays.asList(
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg",
                "https://cdn.thebanchan.co.kr/upload/C00001/goods/prd/326/372/190920000024372.jpg"
            ))
            .build()
    );

    return Mono.just(ResponseDTO.success(productList, PageInfo.builder().totalPage(12).totalElement(120).build()));
  }

  private Mono makeProducts(){
    List<ProductDto> productList= Arrays.asList(
        ProductDto.builder()
            .description("product 1")
            .wishs(11l)
            .name("product")
            .price(10000)
            .productId(1l)
            .storeId(1l)
            .ratings(3.5)
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
            .price(20000)
            .productId(2l)
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
            .name("product2")
            .price(20000)
            .productId(3l)
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
            .name("product2")
            .price(20000)
            .productId(4l)
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
            .name("product2")
            .price(20000)
            .productId(5l)
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
            .name("product2")
            .price(20000)
            .productId(6l)
            .storeId(1l)
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
