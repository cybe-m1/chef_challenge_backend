package chefchallenge.backend.Stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PDOStockAdd {
    private int id_user;
    private String name;
    private int quantity;
    private String url;
}
