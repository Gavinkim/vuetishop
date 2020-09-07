package kr.banchango.server.domain.store;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
  //@NotEmpty
  @Column(nullable = false)
  private String address;

  //@NotEmpty
  private double latitude;

  //@NotEmpty
  private double longitude;

  @Builder
  public Address(String address, double latitude, double longitude) {
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
