package kr.banchango.server.api.common;

import lombok.Getter;

@Getter
public enum SearchType {
  NEW("신규"),DISCOUNT("할인"),POPULAR("인기");

  private String desc;

  SearchType(String desc) {
    this.desc = desc;
  }
}
