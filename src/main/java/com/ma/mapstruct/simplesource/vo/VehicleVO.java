package com.ma.mapstruct.simplesource.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
@Accessors(chain = true)
public class VehicleVO {
    /** 编号id */
    private Long id;
    /** 裸车的价格 */
    private Double price;
    /** 品牌名字 */
    private String brandName;
}
