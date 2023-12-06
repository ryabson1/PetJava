package ru.ryabson.Processing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public List<GoodListResponseDto> getAllActiveGoods() {
        List<GoodListResponseDto> activeList = new ArrayList<>();
        for (Good good : goodRepository.findAllByGoodActive(false)) {
            GoodListResponseDto responseDto = new GoodListResponseDto();
            responseDto.setGoodId(good.getId());
            responseDto.setGoodName(good.getGoodName());
            responseDto.setGoodTypeName(good.getGoodType().getGoodTypeName());
            activeList.add(responseDto);
        }
        return activeList;
    }

    public void deleteGood(Long id) {
        goodRepository.deleteGoodById(id);
    }

    public Good getGoodById(Long id) {
        return goodRepository.findGoodById(id);
    }

    public void bouGood(Long goodId, BigDecimal goodPrice) {
        Good good = goodRepository.findGoodById(goodId);
        good.setGoodPrice(goodPrice);
        good.setGoodActive(true);
        goodRepository.save(good);
    }

}
