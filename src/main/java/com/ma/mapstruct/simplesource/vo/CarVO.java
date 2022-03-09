package com.ma.mapstruct.simplesource.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 汽车
 */
@Data
@Accessors(chain = true)
public class CarVO {
    /** 车辆的编号 */
    private String vin;
    /** 车的颜色 */
    private String color;
    /** 品牌名字 */
    private String brandName;
    /** 编号id */
    private Long id;
    /** 裸车的价格 */
    private Double price;
    /** 上路的价格,保留两位小数 */
    private String totalPrice;
    /** 生产日期，格式yyyy-MM-dd HH:mm:ss */
    private String publishDate;
    /** 汽车的司机 */
    private DriverVO driverVO;
    /** 是否配置了零件 */
    private Boolean hasPart;
}
