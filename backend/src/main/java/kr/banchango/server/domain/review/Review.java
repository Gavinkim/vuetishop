package kr.banchango.server.domain.review;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import kr.banchango.server.domain.common.DateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long reviewId;

  @Column(nullable = false)
  private Long productId;

  @Column(nullable = false)
  private Long userId;

  @Enumerated(value = EnumType.STRING)
  private ReviewStatus status;

  private String content;

  @Embedded
  private DateTime dateTime;

}
