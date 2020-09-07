package kr.banchango.server.api.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"사용자"},description = "사용자 정보를 제공 합니다.")
@Slf4j
@RestController
public class UserApiController extends AbstractApiController {

  @ApiOperation(value = "회원가입",notes = "userId 와 productId 는 필수 입니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/user/register")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> add(@RequestBody RegisterDto registerDto) {
    return Mono.just(ResponseDTO.success());
  }

  @ApiOperation(value = "회원정보 변경",notes = "회원정보 변경시 패스워드 변경은 별도의 인증 api 를 사용하도록 합니다.\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/user/change")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> change(@RequestBody UserInfoDto userInfoDto) {
    return Mono.just(ResponseDTO.success());
  }


  @ApiOperation(value = "회원정보",notes = "\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @GetMapping(path = "/user/me")
  public Mono<ResponseDTO> me() {
    return Mono.just(ResponseDTO.success(
        UserInfoDto.builder()
            .email("test@test.com")
            .image("https://avataaars.io/")
            .name("테스트")
            .phone("010-1234-5673")
            .build()
    ));
  }

  @ApiOperation(value = "회원 탈퇴 요청",notes = "\n로그인 사용자이며, 헤더에 토큰이 있어야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @DeleteMapping(path = "/user")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> delete() {
    return Mono.just(ResponseDTO.success());
  }

}
