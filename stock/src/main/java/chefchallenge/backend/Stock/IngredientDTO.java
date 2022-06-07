package chefchallenge.backend.Stock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientDTO {
    private int id_ingredient;
    private String name;
    private String url;
}
