package kr.banchango.server.api.user;

import lombok.Builder;
import lombok.Data;

@Data
public class RegisterDto {

  private String name;
  private String email;
  private String password;
  private String phone;
  private String image;

  @Builder
  public RegisterDto(String name, String email, String password, String phone, String image) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.image = image;
  }
}
