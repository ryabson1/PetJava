package ru.ryabson.Processing.repository;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryabson.Processing.entity.Good;

public interface GoodRepository extends JpaRepository<Good, Long> {

       @Transactional
       public void deleteGoodById(Long id);

       Good findGoodById(Long id);

       List<Good> findAllByGoodActive(boolean result);
}
