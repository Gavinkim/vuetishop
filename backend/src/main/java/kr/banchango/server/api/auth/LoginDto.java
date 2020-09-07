package kr.banchango.server.api.auth;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginDto {

  private String email;
  private String password;

  @Builder
  public LoginDto(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
