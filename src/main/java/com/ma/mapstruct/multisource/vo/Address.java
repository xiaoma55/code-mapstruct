package com.ma.mapstruct.multisource.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
    private String street;
    private String postalcode;
    private String county;
}