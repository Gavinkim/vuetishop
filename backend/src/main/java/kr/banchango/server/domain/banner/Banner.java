package kr.banchango.server.domain.banner;

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
public class Banner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bannerId;
  private String link;
  private String content;
  private String image;
  @Enumerated(value = EnumType.STRING)
  private BannerLinkType type;
  @Embedded
  private DateTime dateTime;

}
