package kr.banchango.server.api.auth;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class AuthDto {

  private String token;
  private String refresh;
  private LocalDateTime expiredAt;

  @Builder
  public AuthDto(String token, String refresh,LocalDateTime expiredAt) {
    this.token = token;
    this.refresh = refresh;
    this.expiredAt = expiredAt;
  }
}
