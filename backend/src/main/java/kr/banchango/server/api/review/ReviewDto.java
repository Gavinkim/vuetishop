package kr.banchango.server.api.review;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import kr.banchango.server.domain.review.ReviewStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class ReviewDto {
  private Long reviewId;

  @ApiModelProperty(value = "리뷰 등록/수정 시 필수 값 입니다.")
  private Long productId;

  @ApiModelProperty(value = "별점")
  private double ratings;

  private Long userId;

  private String content;

  @ApiModelProperty(value = "리뷰 등록/수정 시 필수 값이 아닙니다.")
  private ReviewStatus status;
  @ApiModelProperty(value = "리뷰 등록시 필수 값이 아닙니다.")
  private LocalDateTime writtenAt;


  // 리뷰 등록시 사용
  @Builder
  public ReviewDto(Long reviewId,Long productId, double ratings,
      String content, ReviewStatus status, LocalDateTime writtenAt) {
    this.reviewId = reviewId;
    this.productId = productId;
    this.ratings = ratings;
    this.content = content;
    this.status = status;
    this.writtenAt = writtenAt;
  }

  @Builder
  public ReviewDto(Long reviewId, Long userId, double ratings,
      ReviewStatus status, LocalDateTime writtenAt,String content) {
    this.reviewId = reviewId;
    this.userId = userId;
    this.ratings = ratings;
    this.status = status;
    this.writtenAt = writtenAt;
    this.content = content;
  }
}
