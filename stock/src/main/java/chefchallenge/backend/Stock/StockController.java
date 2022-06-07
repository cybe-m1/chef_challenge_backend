package chefchallenge.backend.Stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Autowired
    private RestTemplate restTemplate;
    private String ingredient_url="http://localhost:8083/ingredient/";

    @GetMapping
    public List<Stock> getAllStock(){
        return stockService.getAllStock();
    }

    @GetMapping("/{id_stock}")
    public Stock getStockById(@PathVariable int id_stock){
        return stockService.getStock(id_stock);
    }

    @GetMapping("user/{id_user}")
    public List<PDOStock> getStockByIdUser(@PathVariable int id_user) throws JsonProcessingException {
        List<Stock> stockOfAllIngredient = stockService.getStockByUser(id_user);
        List<PDOStock> finalList = new ArrayList<PDOStock>();

        for (int i = 0; i < stockOfAllIngredient.size(); i++) {
            String url = ingredient_url + stockOfAllIngredient.get(i).getId_ingredient();
            IngredientDTO response = restTemplate.getForObject(url, IngredientDTO.class);
            PDOStock stockToAdd = new PDOStock();
            stockToAdd.setName(response.getName());
            stockToAdd.setUrl(response.getUrl());
            stockToAdd.setQuantity(stockOfAllIngredient.get(i).getQuantity());

            finalList.add(stockToAdd);
        }
        return finalList;
    }

    @PutMapping
    public Stock modifyStock(@RequestBody Stock stock) {
        return stockService.modifyStock(stock);
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @DeleteMapping("/{id_stock}")
    public String deleteStock(@PathVariable int id_stock) {
        return stockService.suppStock(id_stock);
    }
}
