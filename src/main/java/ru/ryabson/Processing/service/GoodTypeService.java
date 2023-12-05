package ru.ryabson.Processing.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryabson.Processing.entity.GoodType;
import ru.ryabson.Processing.repository.GoodTypeRepository;

@Service
@AllArgsConstructor
public class GoodTypeService {

    private final GoodTypeRepository goodTypeRepository;

    public List<GoodType> getAllGoodTypes() {
        return goodTypeRepository.findAll();
    }

}
