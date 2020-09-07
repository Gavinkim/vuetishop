package kr.banchango.server.domain.review;

import lombok.Getter;

@Getter
public enum ReviewStatus {
  ENABLE("enable"),DISABLE("disable");

  private String description;

  ReviewStatus(String description) {
    this.description = description;
  }
}
