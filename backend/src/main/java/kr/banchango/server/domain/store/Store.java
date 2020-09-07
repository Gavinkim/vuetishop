package kr.banchango.server.domain.store;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
public class Store {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  private String name;

  private String thumbnail;

  @Column(unique = true)
  private String tel;

  private StoreStatus status;

  @Embedded
  private DateTime dateTime;

  @Embedded
  private Address address;

}
