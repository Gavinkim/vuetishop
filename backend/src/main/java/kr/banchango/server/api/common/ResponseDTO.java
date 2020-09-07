package kr.banchango.server.api.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
  private String code;
  private String message;
  private T data;
  private PageInfo page;

  public static <T> ResponseDTO<T> success(){
    return (ResponseDTO) ResponseDTO.builder()
        .code(ResponseCode.SUCCESS.getCode())
        .message(ResponseCode.SUCCESS.getMessage())
        .build();
  }

  @Builder
  public static <T> ResponseDTO<T> success(T data,PageInfo page){
    return (ResponseDTO) ResponseDTO.builder()
        .code(ResponseCode.SUCCESS.getCode())
        .message(ResponseCode.SUCCESS.getMessage())
        .data(data)
        .page(page)
        .build();
  }

  @Builder
  public static <T> ResponseDTO<T> success(T data){
    return (ResponseDTO) ResponseDTO.builder()
        .code(ResponseCode.SUCCESS.getCode())
        .message(ResponseCode.SUCCESS.getMessage())
        .data(data)
        .build();
  }

  @Builder
  public static <T> ResponseDTO<T> error(ResponseCode code){
    return (ResponseDTO) ResponseDTO.builder()
        .code(ResponseCode.FAIL.getCode())
        .message(ResponseCode.FAIL.getMessage())
        .build();
  }


}
