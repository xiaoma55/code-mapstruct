package com.ma.mapstruct.multisource.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Customer {
    private String firstName;
    private String lastName;
}