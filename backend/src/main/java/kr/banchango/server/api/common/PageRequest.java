package kr.banchango.server.api.common;

import lombok.Builder;
import lombok.Getter;

public final class PageRequest {
  @Getter
  private int page;
  @Getter
  private int size;

  @Builder
  public PageRequest(int page, int size) {
    final int DEFAULT_SIZE = 10;
    final int MAX_SIZE = 50;
    this.page = page <= 0 ? 1 : page;
    this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
  }
}
