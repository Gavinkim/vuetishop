package kr.banchango.server.api.cart;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"장바구니"},description = "장바구니 상품에 대한 정보를 제공 합니다.")
@Slf4j
@RestController
public class CartApiController extends AbstractApiController {

  @ApiOperation(value = "장바 구니 등록 요청",notes = "productId 는 필수 입니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/cart/add/{productId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> add(@PathVariable Long productId) {
    return Mono.just(ResponseDTO.success());
  }

  @ApiOperation(value = "장바 구니 등록 취소 요청",notes = "cartId 는 필수 입니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @DeleteMapping(path = "/cart/cancel/{cartId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> delete(@PathVariable Long cartId) {
    return Mono.just(ResponseDTO.success());
  }

}
