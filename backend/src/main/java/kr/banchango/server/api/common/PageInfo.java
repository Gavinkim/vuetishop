package kr.banchango.server.api.common;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageInfo {
  private long totalPage;
  private long totalElement;

  @Builder
  public PageInfo(long totalPage, long totalElement) {
    this.totalPage = totalPage;
    this.totalElement = totalElement;
  }
}
