package kr.kspring.new_year_bible.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
public class BibleData implements Serializable {
  @Data
  @AllArgsConstructor
  @EqualsAndHashCode(callSuper = false)
  public static class Res extends BibleData{
    String targetName;
    String targetBibleImage;
  }

  @Data
  public static class Req extends BibleData{
    @NotBlank
    String name;
    @NotBlank
    String password;
  }
}
