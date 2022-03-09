package com.ma.mapstruct;

import com.ma.mapstruct.multisource.mapper.IDeliveryAddressMapper;
import com.ma.mapstruct.multisource.vo.Address;
import com.ma.mapstruct.multisource.vo.Customer;
import com.ma.mapstruct.multisource.vo.DeliveryAddress;
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
public class MultiSourceTest {
    @Autowired
    private IDeliveryAddressMapper deliveryAddressMapper;

    /** 测试 @InheritInverseConfiguration反向继承 */
    @Test
    public void test1() {
        Customer customer = new Customer()
                .setFirstName("张")
                .setLastName("三");
        Address homeAddress = new Address()
                .setStreet("科技二路")
                .setCounty("雁塔区")
                .setPostalcode("89123");
        DeliveryAddress deliveryAddress = deliveryAddressMapper.from(customer, homeAddress);
        System.out.println(deliveryAddress);
    }
}
