package kr.banchango.server.api.common;

import lombok.Getter;

@Getter
public enum ResponseCode {
  SUCCESS("20000","success")
  ,FAIL("40000","fail.");

  private String code;
  private String message;

  ResponseCode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
