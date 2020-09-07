package kr.banchango.server.domain.order;

public enum OrderStatus {
  WAIT("주문중"),CANCEL("주문취소"),DONE("주문 완료");
  private String description;

  OrderStatus(String description) {
    this.description = description;
  }
}
