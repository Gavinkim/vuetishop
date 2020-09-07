package kr.banchango.server.api.auth;

import lombok.Data;

@Data
public class ChangePasswordDto {
  private String oldPassword;
  private String newPassword;
}
