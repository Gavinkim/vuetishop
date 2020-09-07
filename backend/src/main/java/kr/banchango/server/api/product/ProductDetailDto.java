package kr.banchango.server.api.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import kr.banchango.server.domain.product.Product;
import kr.banchango.server.domain.product.ProductStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
public class ProductDetailDto {

  private Long productId;
  private Long storeId;
  private String storeName;
  private String storeThumbnail;
  private String name;
  private String description;

  @ApiModelProperty(value = "찜 카운트 ")
  private Long wishs;
  @ApiModelProperty(value = "리뷰 카운트 ")
  private Long reviews;
  private Long price;
  private ProductStatus status;
  @ApiModelProperty(value = "평점")
  private double ratings;
  @ApiModelProperty(value = "찜 리스트 추가 여부")
  private boolean addWish;
  @ApiModelProperty(value = "상품에 대한 이미지 리스트")
  private List<String> images;

  @ApiModelProperty(value = "상점 상품 리스트")
  private List<ProductDto> productList;


  @Builder
  public ProductDetailDto(String storeName,Long productId, Long storeId, String name, String description,
      Long wishs, Long reviews, Long price, ProductStatus status, double ratings, boolean addWish,
      String storeThumbnail,
      List<String> images,
      List<ProductDto> productList) {
    this.productId = productId;
    this.storeName = storeName;
    this.storeThumbnail = storeThumbnail;
    this.productList = productList;
    this.storeId = storeId;
    this.name = name;
    this.description = description;
    this.wishs = wishs;
    this.reviews = reviews;
    this.price = price;
    this.status = status;
    this.ratings = ratings;
    this.addWish = addWish;
    this.images = images;
  }
}
