package ru.ryabson.Processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryabson.Processing.entity.Good;

public interface GoodRepository extends JpaRepository<Good, Long> {



}
