package chefchallenge.backend.Stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PDOStock {
    private int id_stock;
    private int id_user;
    private int id_ingredient;
    private String name;
    private int quantity;
    private String url;
}
