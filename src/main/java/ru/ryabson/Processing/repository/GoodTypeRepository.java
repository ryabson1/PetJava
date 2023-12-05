package ru.ryabson.Processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryabson.Processing.entity.GoodType;

public interface GoodTypeRepository extends JpaRepository<GoodType, Long> {

    GoodType findGoodTypeByGoodTypeName(String goodTypeName);
}
