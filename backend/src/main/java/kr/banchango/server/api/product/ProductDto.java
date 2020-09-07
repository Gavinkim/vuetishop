package kr.banchango.server.api.product;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import kr.banchango.server.domain.product.ProductStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

  private Long productId;
  @ApiModelProperty(value = "상점 아이디")
  private Long storeId;
  @ApiModelProperty(value = "상점 섬네일 이미지.")
  private String storeThumbnail;
  @ApiModelProperty(value = "상점 이.")
  private String storeName;
  private String name;
  private String description;
  @ApiModelProperty(value = "상품에 대한 찜 카운트")
  private Long wishs;
  @ApiModelProperty(value = "상품에 대한 리뷰 카운트 ")
  private Long reviews;
  private long price;
  private ProductStatus status;
  @ApiModelProperty(value = "평점")
  private double ratings;
  @ApiModelProperty(value = "상품 이미지 리스트")
  private List<String> images;
  @ApiModelProperty(value = "찜 리스트 추가 여부")
  private boolean addWish;

  @Builder
  public ProductDto(Long productId, Long storeId, String name, String description,
      Long wishs, Long reviews, long price, double ratings, List<String> images,ProductStatus status,
      boolean addWish,
      String storeName,
      String storeThumbnail) {
    this.addWish = addWish;
    this.storeName = storeName;
    this.productId = productId;
    this.storeId = storeId;
    this.name = name;
    this.description = description;
    this.wishs = wishs;
    this.reviews = reviews;
    this.price = price;
    this.ratings = ratings;
    this.images = images;
    this.status = status;
    this.storeThumbnail = storeThumbnail;
  }
}
