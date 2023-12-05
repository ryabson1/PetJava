package ru.ryabson.Processing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryabson.Processing.dto.GoodCreateRequestDto;
import ru.ryabson.Processing.entity.Good;
import ru.ryabson.Processing.repository.GoodRepository;
import ru.ryabson.Processing.repository.GoodTypeRepository;

@Service
@AllArgsConstructor
public class GoodService {

    private final GoodTypeRepository goodTypeRepository;
    private final GoodRepository goodRepository;

    public void createNewGood(GoodCreateRequestDto requestDto) {
        Good good = new Good();
        good.setGoodName(requestDto.getGoodName());
        good.setGoodType(
                goodTypeRepository.findGoodTypeByGoodTypeName(requestDto.getGoodTypeName()));
        goodRepository.save(good);
    }


}
