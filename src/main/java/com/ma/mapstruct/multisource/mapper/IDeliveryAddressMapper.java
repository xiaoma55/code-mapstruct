package com.ma.mapstruct.multisource.mapper;

import com.ma.mapstruct.multisource.vo.Customer;
import com.ma.mapstruct.multisource.vo.Address;
import com.ma.mapstruct.multisource.vo.DeliveryAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IDeliveryAddressMapper {
    @Mapping(source = "customer.firstName", target = "forename")
    @Mapping(source = "customer.lastName", target = "surname")
    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.postalcode", target = "postalcode")
    @Mapping(source = "address.county", target = "county")
    DeliveryAddress from(Customer customer, Address address);
}
