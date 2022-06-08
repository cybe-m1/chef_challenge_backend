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
    private String ingredient_url="http://localhost:9998/ingredient/";

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
            stockToAdd.setId_stock(stockOfAllIngredient.get(i).getId_stock());
            stockToAdd.setId_user(id_user);
            stockToAdd.setId_ingredient(response.getId_ingredient());
            stockToAdd.setName(response.getName());
            stockToAdd.setUrl(response.getUrl());
            stockToAdd.setQuantity(stockOfAllIngredient.get(i).getQuantity());

            finalList.add(stockToAdd);
        }
        return finalList;
    }

    @GetMapping("particularStock/{id_stock}")
    public PDOStock getStockByIdStock(@PathVariable int id_stock) throws JsonProcessingException {
        Stock stock = stockService.getStock(id_stock);
        PDOStock pdoStock = new PDOStock();

        String url = ingredient_url + stock.getId_ingredient();
        IngredientDTO response = restTemplate.getForObject(url, IngredientDTO.class);
        pdoStock.setId_stock(stock.getId_stock());
        pdoStock.setId_ingredient(stock.getId_ingredient());
        pdoStock.setId_user(stock.getId_user());
        pdoStock.setName(response.getName());
        pdoStock.setUrl(response.getUrl());
        pdoStock.setQuantity(stock.getQuantity());

        return pdoStock;
    }

    @PutMapping
    public Stock modifyStock(@RequestBody PDOStock pdoStock) {
        Stock stockPut = new Stock();
        stockPut.setId_stock(pdoStock.getId_stock());
        stockPut.setId_ingredient(pdoStock.getId_ingredient());
        stockPut.setId_user(pdoStock.getId_user());
        stockPut.setQuantity(pdoStock.getQuantity());
        return stockService.modifyStock(stockPut);
    }

    @PostMapping
    public Stock addStock(@RequestBody PDOStockAdd PDOStockAdd) {
        String url = ingredient_url + "/search/" + PDOStockAdd.getName();
        IngredientDTO response = restTemplate.getForObject(url, IngredientDTO.class);

        Stock stock = new Stock();
        stock.setId_user(PDOStockAdd.getId_user());
        stock.setQuantity(PDOStockAdd.getQuantity());

        if(response == null){
            IngredientDTO toSend = new IngredientDTO();
            toSend.setName(PDOStockAdd.getName());
            toSend.setUrl(PDOStockAdd.getUrl());
            IngredientDTO creationIngredient = restTemplate.postForObject("http://localhost:9998/ingredient", toSend, IngredientDTO.class);
            stock.setId_ingredient(creationIngredient.getId_ingredient());
        } else {
            stock.setId_ingredient(response.getId_ingredient());
        }

        return stockService.addStock(stock);
    }

    @DeleteMapping("/{id_stock}")
    public String deleteStock(@PathVariable int id_stock) {
        return stockService.suppStock(id_stock);
    }
}
