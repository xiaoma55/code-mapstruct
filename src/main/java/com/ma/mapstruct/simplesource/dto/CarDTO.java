package com.ma.mapstruct.simplesource.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 汽车
 */
@Data
@Accessors(chain = true)
public class CarDTO {
    /** 车辆的编号 */
    private String vin;
    /** 车的颜色,不想映射给vo */
    private String color;
    /** 品牌名字 */
    private String brand;
    /** 编号id */
    private Long id;
    /** 裸车的价格,单位:元 */
    private Double price;
    /** 上路的价格,单位:元 */
    private Double totalPrice;
    /** 生产日期 */
    private Date publishDate;
    /** 汽车的司机 */
    private DriverDTO driverDTO;
    /** 汽车包含的零件列表 */
    private List<PartDTO> partDTOS;
}
