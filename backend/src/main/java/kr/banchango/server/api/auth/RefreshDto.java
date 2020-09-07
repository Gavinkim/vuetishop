package kr.banchango.server.api.auth;

import lombok.Data;

@Data
public class RefreshDto {
  private String refreshToken;
}
