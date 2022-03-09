package com.ma.mapstruct;

import com.ma.mapstruct.simplesource.dto.CarDTO;
import com.ma.mapstruct.simplesource.dto.DriverDTO;
import com.ma.mapstruct.simplesource.dto.PartDTO;
import com.ma.mapstruct.simplesource.mapper.ICarMapper;
import com.ma.mapstruct.simplesource.vo.CarVO;
import com.ma.mapstruct.simplesource.vo.VehicleVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class SimpleSourceTest {
    @Autowired
    private ICarMapper carMapper;

    /** 测试 @InheritInverseConfiguration反向继承 */
    @Test
    public void test5() {
        VehicleVO vehicleVO = new VehicleVO()
                .setId(9999L)
                .setBrandName("别克")
                .setPrice(66554322d);
        CarDTO carDTO = carMapper.vehicleVO2CarDTO(vehicleVO);
        System.out.println(carDTO);
    }


    /** 测试 @InheritConfiguration继承配置 */
    @Test
    public void test4() {
        CarDTO carDTO = buildCarDTO();
        VehicleVO vehicleVO = carMapper.carDTO2vehicleVO(carDTO).setPrice(888d);
        CarDTO carDTO2 = new CarDTO()
                .setId(330L)
                .setPrice(789d)
                .setBrand("迈巴赫");
        // 通过carDTO2的属性值来更新已存在的vehicleVO对象
        carMapper.updateVehicleVO(carDTO2, vehicleVO);
        System.out.println(vehicleVO);
    }

    /** 测试 @BeanMapping */
    @Test
    public void test3() {
        CarDTO carDTO = buildCarDTO();
        VehicleVO vehicleVO = carMapper.carDTO2vehicleVO(carDTO);
        System.out.println(vehicleVO);
    }

    /** 测试 批量转换 */
    @Test
    public void test2() {
        CarDTO carDTO1 = buildCarDTO();
        CarDTO carDTO2 = new CarDTO().setId(1L);
        List<CarDTO> carDTOList = Arrays.asList(carDTO1, carDTO2);
        List<CarVO> carVOList = carMapper.carDTOs2carVOs(carDTOList);
        System.out.println(carVOList);
    }

    /** 测试 carDTO2CarVO */
    @Test
    public void test1() {
        CarDTO carDTO = buildCarDTO();
        CarVO carVO = carMapper.carDTO2CarVO(carDTO);
        System.out.println(carDTO);
        System.out.println(carVO);
    }

    /** 模拟业务构造出的CarDTO对象 */
    private CarDTO buildCarDTO() {
        // 驾驶员
        DriverDTO driverDTO = new DriverDTO()
                .setId(88L)
                .setName("小明");
        // 零件
        PartDTO partDTO1 = new PartDTO()
                .setPartId(1L)
                .setPartName("多功能方向盘");
        PartDTO partDTO2 = new PartDTO()
                .setPartId(2L)
                .setPartName("智能车门");
        // 汽车
        CarDTO carDTO = new CarDTO()
                .setId(330L)
                .setVin("vin123456789")
                .setPrice(123789.126d)
                .setTotalPrice(143789.126d)
                .setPublishDate(new Date())
                .setColor("白色")
                .setBrand("大众")
                .setDriverDTO(driverDTO)
                .setPartDTOS(Arrays.asList(partDTO1, partDTO2));
        return carDTO;
    }
}
