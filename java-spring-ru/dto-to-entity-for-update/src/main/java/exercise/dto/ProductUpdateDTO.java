package exercise.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

// BEGIN
@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateDTO {
    private String title;
    private int price;
}
// END
