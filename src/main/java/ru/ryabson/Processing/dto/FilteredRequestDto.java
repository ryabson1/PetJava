package ru.ryabson.Processing.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class FilteredRequestDto {

    private String typeName;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
