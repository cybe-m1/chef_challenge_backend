package chefchallenge.backend.Stock;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    private final StockRepostiory stockRepostiory;

    public StockService(StockRepostiory stockRepostiory) {
        this.stockRepostiory = stockRepostiory;
    }

    public List<Stock> getAllStock() {
        return stockRepostiory.findAll();
    }

    public List<Stock> getStockByUser(int id_user) {
        List<Stock> listStockUser = stockRepostiory.findAll();
        listStockUser = listStockUser.stream().filter(value -> value.getId_user() == id_user).collect(Collectors
                .toCollection(ArrayList::new));
        return listStockUser;
    }

    public Stock getStock(int id_stock) {
        List<Stock> listStock = stockRepostiory.findAll();
        Stock stockToReturn = new Stock();
        for (int i = 0; i < listStock.size() ; i++) {
            if(listStock.get(i).getId_stock() == id_stock) {
                stockToReturn = listStock.get(i);
                break;
            }
        }
        return stockToReturn;
    }

    public Stock addStock(Stock newStock) {
        if (stockRepostiory.existsById(newStock.getId_stock())) {
            throw new IllegalArgumentException("Id: " + newStock.getId_stock() + " already used");
        } else {
            return stockRepostiory.save(newStock);
        }
    }

    public Stock modifyStock(Stock stock) {
        if (stockRepostiory.existsById(stock.getId_stock())) {
            return stockRepostiory.save(stock);
        } else {
            throw new IllegalArgumentException("Id: " + stock.getId_stock() + " not found");
        }
    }

    public String suppStock(int idtruck) {
        if (stockRepostiory.existsById(idtruck)) {
            Stock stockToDelete = stockRepostiory.getById(idtruck);
            stockRepostiory.delete(stockToDelete);
            return "The stock have been deleted";
        } else {
            return"Id: " + idtruck + " dosen't exist";
        }
    }
}
