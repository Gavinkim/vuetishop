package kr.banchango.server.api.review;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.PageInfo;
import kr.banchango.server.api.common.PageRequest;
import kr.banchango.server.api.common.ResponseDTO;
import kr.banchango.server.domain.review.ReviewStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"리뷰"},description = "상품 리뷰 정보를 제공 합니다.")
@Slf4j
@RestController
public class ReviewApiController extends AbstractApiController {

  @ApiOperation(value = "상품 리뷰 리스트 ",notes = "size, page,productId 는 필수 입니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ReviewDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/review/{productId}")
  public Mono<ResponseDTO> recommend(@PathVariable Long productId, PageRequest page) {
    return makeReviews();
  }

  @ApiOperation(value = "상품 리뷰 등록",notes = "\n 상품 상세 정보 페이지 에서 리뷰 등록 / 수정 / 삭제 가능 여부 확인 가능 합니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/review")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> add(@RequestBody ReviewDto review) {
    return Mono.just(ResponseDTO.success());
  }

  @ApiOperation(value = "상품 리뷰 수정.",notes = "\n 상품 상세 정보 페이지 에서 리뷰 등록 / 수정 / 삭제 가능 여부 확인 가능 합니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PutMapping(path = "/review")
  public Mono<ResponseDTO> update(@RequestBody ReviewDto review) {
    return Mono.just(ResponseDTO.success());
  }

  @ApiOperation(value = "상품 리뷰 삭제 .",notes = "\n 상품 상세 정보 페이지 에서 리뷰 등록 / 수정 / 삭제 가능 여부 확인 가능 합니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @DeleteMapping(path = "/review/{reviewId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> delete(@PathVariable Long reviewId) {
    return Mono.just(ResponseDTO.success());
  }


  private Mono makeReviews(){
    List<ReviewDto> reviewList= Arrays.asList(
        ReviewDto.builder()
            .ratings(3.5)
            .reviewId(1l)
            .status(ReviewStatus.ENABLE)
            .writtenAt(LocalDateTime.now())
            .build(),
        ReviewDto.builder()
            .ratings(3.5)
            .reviewId(1l)
            .status(ReviewStatus.ENABLE)
            .userId(1l)
            .writtenAt(LocalDateTime.now())
            .build(),
        ReviewDto.builder()
            .ratings(3.5)
            .reviewId(1l)
            .status(ReviewStatus.ENABLE)
            .userId(1l)
            .writtenAt(LocalDateTime.now())
            .build()
    );

    return Mono.just(ResponseDTO.success(reviewList, PageInfo.builder().totalPage(12).totalElement(120).build()));
  }
}
