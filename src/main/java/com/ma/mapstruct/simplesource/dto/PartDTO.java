package com.ma.mapstruct.simplesource.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 汽车零件
 */
@Data
@Accessors(chain = true)
public class PartDTO {
    /** 汽车零件的id */
    private Long partId;
    /** 零件的名字，比如:多功能方向盘 */
    private String partName;
}
