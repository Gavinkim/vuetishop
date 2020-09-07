package kr.banchango.server.api.common;

public enum SortType {
  NEW(true), REVIEW(false), WISH(false), ORDER(false), REGISTERD(false);
  private boolean type;

  SortType(boolean type) {
    this.type = type;
  }
}
