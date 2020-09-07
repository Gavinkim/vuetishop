package kr.banchango.server.domain.wish;

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
import kr.banchango.server.domain.order.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Wish {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long wishId;

  @Column(nullable = false)
  private Long productId;

  @Column(nullable = false)
  private Long userId;

  @Enumerated(value = EnumType.STRING)
  private WishStatus status;

  @Embedded
  private DateTime dateTime;

}
