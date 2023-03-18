package org.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class CategoryDto {

    private Long id;

    private String name;

}
