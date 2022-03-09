package com.ma.mapstruct.simplesource.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 驾驶员
 */
@Data
@Accessors(chain = true)
public class DriverDTO {
    /** id */
    private Long id;
    /** 驾驶员的名字 */
    private String name;
}
