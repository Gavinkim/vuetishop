package kr.banchango.server.domain.cart;

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
import kr.banchango.server.domain.product.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartId;

  @Column(nullable = false)
  private Long productId;

  @Column(nullable = false)
  private Long userId;

  @Enumerated(value = EnumType.STRING)
  private CartStatus status;

  @Embedded
  private DateTime dateTime;

}
