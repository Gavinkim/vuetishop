package kr.banchango.server.api.category;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {

  private Long categoryId;
  private String name;

  @Builder
  public CategoryDto(Long categoryId, String name) {
    this.categoryId = categoryId;
    this.name = name;
  }
}
