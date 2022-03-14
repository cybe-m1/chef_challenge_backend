package chefchallenge.backend.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepostiory extends JpaRepository<Stock, Integer> {
}
