package ru.ryabson.Processing.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryabson.Processing.dto.GoodCreateRequestDto;
import ru.ryabson.Processing.dto.GoodListResponseDto;
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

    public List<GoodListResponseDto> getAllGoods() {
        List<GoodListResponseDto> goodList = new ArrayList<>();
        for (Good good : goodRepository.findAll()) {
            GoodListResponseDto response = new GoodListResponseDto();
            response.setGoodId(good.getId());
            response.setGoodName(good.getGoodName());
            response.setGoodTypeName(good.getGoodType().getGoodTypeName());
            goodList.add(response);
        }
        return goodList;
    }

    public void deleteGood(Long id) {
        goodRepository.deleteGoodById(id);
    }


}
