package ru.ryabson.Processing.controller;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ryabson.Processing.dto.GoodCreateRequestDto;
import ru.ryabson.Processing.dto.GoodListResponseDto;
import ru.ryabson.Processing.entity.Good;
import ru.ryabson.Processing.entity.GoodType;
import ru.ryabson.Processing.service.GoodService;
import ru.ryabson.Processing.service.GoodTypeService;

@Controller
@AllArgsConstructor
@RequestMapping("/goods")
public class GoodController {

    private final GoodService goodService;
    private final GoodTypeService goodTypeService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<GoodType> goodTypeList = goodTypeService.getAllGoodTypes();
        model.addAttribute("goodTypes", goodTypeList);
        model.addAttribute("createRequest", new GoodCreateRequestDto());
        return "create-good";
    }

    @PostMapping("/create")
    public String createGood(
            @ModelAttribute("createRequest") GoodCreateRequestDto createRequestDto) {
        goodService.createNewGood(createRequestDto);
        return "redirect:/goods/create?success";
    }

    @GetMapping("/all")
    public String getAllGoods(Model model) {
        //  List<GoodListResponseDto> goodList = goodService.getAllGoods();
        List<GoodListResponseDto> goodList = goodService.getAllActiveGoods();
        model.addAttribute("goods", goodList);
        return "allGoods";
    }

    @GetMapping("/delete/{id}")
    public String deleteGood(@PathVariable Long id) {
        goodService.deleteGood(id);
        return "redirect:/goods/all";
    }

    @GetMapping("/buy/{id}")
    public String showBuyForm(@PathVariable Long id, Model model) {
        // Передайте необходимые данные для отображения на форме, например, имя товара
        Good good = goodService.getGoodById(id);
        model.addAttribute("goodName", good.getGoodName());
        model.addAttribute("goodId", id);
        return "buyForm";
    }

    @PostMapping("/buy")
    public String buyGood(
            @RequestParam Long goodId,
            @RequestParam BigDecimal goodPrice) {
        goodService.bouGood(goodId, goodPrice);
        return "redirect:/goods/all";
    }


}
