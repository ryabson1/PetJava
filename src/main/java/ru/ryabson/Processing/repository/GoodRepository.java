package ru.ryabson.Processing.repository;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryabson.Processing.entity.Good;
import ru.ryabson.Processing.entity.GoodType;

public interface GoodRepository extends JpaRepository<Good, Long> {

    @Transactional
    public void deleteGoodById(Long id);

    Good findGoodById(Long id);

    List<Good> findAllByGoodActive(boolean result);

    List<Good> findByGoodTypeAndGoodPriceBetween(GoodType goodType,
            BigDecimal minPrice, BigDecimal maxPrice);

    List<Good> findByGoodType (GoodType goodType);

    List<Good> findByGoodPriceBetween (BigDecimal minPrice, BigDecimal maxPrice);
}
