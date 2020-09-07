package kr.banchango.server.api.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Arrays;
import java.util.List;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"카테고리"},description = "상품 카테고리 정보를 제공 합니다.")
@Slf4j
@RestController
public class CategoryApiController extends AbstractApiController {

  @ApiOperation(value = "카테고리 조회",notes = "카테고리를 요청합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = CategoryDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/categories")
  public Mono<CategoryDto> categories() {
    return makeCategory();
  }


  private Mono makeCategory(){
    List<CategoryDto> categoryDtos = Arrays.asList(
        CategoryDto.builder()
            .categoryId(1l)
            .name("해산물")
            .build(),
        CategoryDto.builder()
            .categoryId(2l)
            .name("육류")
            .build(),
        CategoryDto.builder()
            .categoryId(2l)
            .name("채소")
            .build(),
        CategoryDto.builder()
            .categoryId(3l)
            .name("일회용")
            .build()
    );

    return Mono.just(
        ResponseDTO.success(categoryDtos)
    );
  }
}
