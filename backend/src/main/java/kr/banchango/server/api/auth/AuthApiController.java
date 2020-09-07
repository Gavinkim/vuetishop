package kr.banchango.server.api.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.time.LocalDateTime;
import kr.banchango.server.api.AbstractApiController;
import kr.banchango.server.api.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api(tags = {"인증"},description = "인증 정보를 제공 합니다.")
@Slf4j
@RestController
public class AuthApiController extends AbstractApiController {

  @ApiOperation(value = "로그인",notes = "userId 와 productId 는 필수 입니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = AuthDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/auth/login")
  public Mono<ResponseDTO> login(@RequestBody LoginDto loginDto) {
    return Mono.just(ResponseDTO.success(AuthDto.builder()
        .expiredAt(LocalDateTime.now().plusDays(1))
        .token("asdkfalsdkfalsdkfjalskdfjlaksdfjlalsdf2323alksdfa")
        .refresh("asdkfalsdkfalsdkfjalskdfjlaksdfjlalsdf2323alksdfa")
        .build()));
  }

  @ApiOperation(value = "토큰 갱신",notes = "헤더값에는 반드시 토큰값, 그리고 payload 값에는 반드시 리프레시 토큰이 반드시 존재 해야 합니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = AuthDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/auth/refresh")
  public Mono<ResponseDTO> refresh(@RequestBody RefreshDto refreshDto) {
    return Mono.just(ResponseDTO.success(AuthDto.builder()
        .expiredAt(LocalDateTime.now().plusDays(1))
        .token("asdkfalsdkfalsdkfjalskdfjlaksdfjlalsdf2323alksdfa")
        .refresh("asdkfalsdkfalsdkfjalskdfjlaksdfjlalsdf2323alksdfa")
        .build()));
  }

  @ApiOperation(value = "비밀번호 변경",notes = "패스워드 변경 후 반드시 재 로그인이 필요 합니다.\n 토큰을 다시 발급 받습니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = AuthDto.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/auth/change/password")
  public Mono<ResponseDTO> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
    return Mono.just(ResponseDTO.success());
  }

  @ApiOperation(value = "이메일 인증",notes = "발송된 이메일에는 \n<h3>https://banchango.com/api/auth/verify/ss3s3i</h3> 와 같이 인증 번호와 함께 제공되는 url 이 발급 됩니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @PostMapping(path = "/auth/verify/{uid}")
  public Mono<ResponseDTO> refresh(@RequestParam String uid) {
    return Mono.just(ResponseDTO.success());
  }

  @ApiOperation(value = "로그아웃",notes = "헤더값에 반드시 토큰 값이 존재 해야 합니다.\n 토큰,리프레시 토큰, 세션 정보가 모두 삭제 됩니다.")
  @ApiResponses({
      @ApiResponse(code=200,message = "success",response = ResponseDTO.class),
      @ApiResponse(code=200,message = "error",response = ResponseDTO.class) //todo: 수정.
  })
  @DeleteMapping(path = "/auth/logout")
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseDTO> delete() {
    return Mono.just(ResponseDTO.success());
  }

}
