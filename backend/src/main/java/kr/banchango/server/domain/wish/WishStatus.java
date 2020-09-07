package kr.banchango.server.domain.wish;

public enum WishStatus {
  IN("위시리스트에 담은 상태"),OUT("위시리트스에서 제거 한 상태");
  private String description;

  WishStatus(String description) {
    this.description = description;
  }
}
