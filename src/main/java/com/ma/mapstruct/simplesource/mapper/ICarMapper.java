package com.ma.mapstruct.simplesource.mapper;

import com.ma.mapstruct.simplesource.dto.CarDTO;
import com.ma.mapstruct.simplesource.dto.DriverDTO;
import com.ma.mapstruct.simplesource.dto.PartDTO;
import com.ma.mapstruct.simplesource.vo.CarVO;
import com.ma.mapstruct.simplesource.vo.DriverVO;
import com.ma.mapstruct.simplesource.vo.VehicleVO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    /* 可以用下面这个实例化，然后调用的时候就是 ICarMapper.INSTANCE.******方法，
       ICarMapper INSTANCE = Mappers.getMapper(ICarMapper.class);

       但是这样有点违背了spring的编程风格，我们可以使用另一种方式
       我们一般在接口加 @Mapper(componentModel = "spring")
       这样就可以 @Autowired去注入这个接口了，本篇的例子都是使用这种方式
    */


    /** carDTO2CarVO */
    @Mapping(source = "totalPrice", target = "totalPrice", numberFormat = "#.00" ,defaultValue = "￥0.00")
    @Mapping(source = "publishDate", target = "publishDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "color", ignore = true)
    @Mapping(source = "brand", target = "brandName")
    @Mapping(source = "driverDTO", target = "driverVO")
    CarVO carDTO2CarVO(CarDTO carDTO);

    /** 批量转换 */
    List<CarVO> carDTOs2carVOs(List<CarDTO> carDTO);

    /** driverDTO2DriverVO */
    @Mapping(source = "id", target = "driverId")
    @Mapping(source = "name", target = "fullName")
    DriverVO driverDTO2DriverVO(DriverDTO driverDTO);

    /** 表示让mapstruct在调用完自动转换的方法之后，会来自动调用本方法 */
    @AfterMapping
    default void dto2voAfter(CarDTO carDTO, @MappingTarget CarVO carVO) {
        // @MappingTarget : 表示传来的carVO对象是已经赋值过的
        List<PartDTO> partDTOS = carDTO.getPartDTOS();
        boolean hasPart = partDTOS != null && !partDTOS.isEmpty();
        carVO.setHasPart(hasPart);
    }

    /** 配置忽略mapstruct的默认映射行为，只映射那些配置了@Mapping的属性 */
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "brand", target = "brandName")
    VehicleVO carDTO2vehicleVO(CarDTO carDTO);


    /** 会继承全部配置，包括@BeanMapping和@Mapping */
    @InheritConfiguration(name = "carDTO2vehicleVO")
    void updateVehicleVO(CarDTO carDTO, @MappingTarget VehicleVO vehicleVO);

    /**
     * 测试@InheritInverseConfiguration反向继承 :反转就是你原来写了dto->vo,加了这个反转就是实现了vo->dto，它会继承@Mapping的配置
     * 只会继承@Mapping,故需要再单独写一次 @BeanMapping
     * name:指定使用哪一个方法的配置,写方法的名字
     */
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "carDTO2vehicleVO")
    CarDTO vehicleVO2CarDTO(VehicleVO vehicleVO);
}
