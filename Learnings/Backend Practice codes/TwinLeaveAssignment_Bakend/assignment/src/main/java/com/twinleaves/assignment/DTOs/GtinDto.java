package com.twinleaves.assignment.DTOs;

import com.twinleaves.assignment.Entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class GtinDto {
    private Long gtinId;

    private String gtinCode;
    private Product product;

}
