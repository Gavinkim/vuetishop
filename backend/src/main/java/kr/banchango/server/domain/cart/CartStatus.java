package kr.banchango.server.domain.cart;

public enum CartStatus {
  IN("장바구니 담은 상태"),OUT("장바구니에서 제거 한 상"),ORDER("주문 한 상태");
  private String description;

  CartStatus(String description) {
    this.description = description;
  }
}
