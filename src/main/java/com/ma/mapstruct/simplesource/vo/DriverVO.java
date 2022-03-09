package com.ma.mapstruct.simplesource.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 驾驶员
 */
@Data
@Accessors(chain = true)
public class DriverVO {
    /** 驾驶员id */
    private Long driverId;
    /** 驾驶员的名字 */
    private String fullName;
}
