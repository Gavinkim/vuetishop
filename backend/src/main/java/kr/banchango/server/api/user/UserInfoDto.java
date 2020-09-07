package kr.banchango.server.api.user;

import lombok.Builder;
import lombok.Data;

@Data
public class UserInfoDto {

  private String name;
  private String email;
  private String phone;
  private String image;

  @Builder
  public UserInfoDto(String name, String email, String phone, String image) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.image = image;
  }
}
