package kr.banchango.server.api.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SearchParam {
  @ApiModelProperty(hidden = true)
  private final int DEFAULT_SIZE = 10;
  @ApiModelProperty(hidden = true)
  private final int MAX_SIZE = 50;

  private SearchType type = SearchType.POPULAR;

  private int page=1;

  private int size=DEFAULT_SIZE;

  private String q;

  private Long categoryId;

  private SortType sort = SortType.NEW;

  public void setType(SearchType type) {
    this.type = type;
  }

  public void setQ(String q) {
    this.q = q;
  }

  public void setSort(SortType sort) {
    this.sort = sort;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public void setPage(int page) {
    this.page = page <= 0 ? 1 : page;
  }

  public void setSize(int size) {
    this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
  }
}
