package kr.banchango.server.api.store;

import java.util.List;
import kr.banchango.server.api.product.ProductDto;
import kr.banchango.server.domain.store.StoreStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreDto {

  private Long storeId;
  private String name;
  private String thumbnail;
  private String tel;
  private StoreAddressDto address;
  private StoreStatus status;
  private List<ProductDto> productDtos;

  @Builder
  public StoreDto(Long storeId, String name, String thumbnail, String tel,
      StoreAddressDto address, StoreStatus status,
      List<ProductDto> productDtos) {
    this.storeId = storeId;
    this.name = name;
    this.thumbnail = thumbnail;
    this.tel = tel;
    this.address = address;
    this.status = status;
    this.productDtos = productDtos;
  }
}
