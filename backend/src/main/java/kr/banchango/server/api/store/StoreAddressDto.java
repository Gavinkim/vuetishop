package kr.banchango.server.api.store;

import lombok.Builder;
import lombok.Data;

@Data
public class StoreAddressDto {

  private String address;
  private double latitude;
  private double longitude;

  @Builder
  public StoreAddressDto(String address, double latitude, double longitude) {
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
