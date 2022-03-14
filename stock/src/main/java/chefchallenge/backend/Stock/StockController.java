package chefchallenge.backend.Stock;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStock(){
        return stockService.getAllStock();
    }

    @GetMapping("/{id_stock}")
    public Stock getStockById(@PathVariable int id_stock){
        return stockService.getStock(id_stock);
    }

    @GetMapping("user/{id_user}")
    public List<Stock> getStockByIdUser(@PathVariable int id_user){
        return stockService.getStockByUser(id_user);
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
