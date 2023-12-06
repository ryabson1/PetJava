package ru.ryabson.Processing.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class FilteredResponseDto {

    private Long goodId;
    private String goodName;
    private String goodTypeName;
    private BigDecimal goodPrice;

}
