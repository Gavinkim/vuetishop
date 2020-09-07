package kr.banchango.server.api.banner;

import kr.banchango.server.domain.banner.BannerLinkType;
import lombok.Builder;
import lombok.Data;

@Data
public class BannerDto {

  private Long bannerId;
  private String link;
  private String image;
  private BannerLinkType type;

  @Builder
  public BannerDto(Long bannerId, String link, String image,
      BannerLinkType type) {
    this.bannerId = bannerId;
    this.link = link;
    this.image = image;
    this.type = type;
  }
}
