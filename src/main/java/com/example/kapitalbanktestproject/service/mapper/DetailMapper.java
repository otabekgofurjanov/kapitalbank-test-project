package com.example.kapitalbanktestproject.service.mapper;


import com.example.kapitalbanktestproject.domain.Detail;
import com.example.kapitalbanktestproject.service.dto.DetailDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, ProductMapper.class})
public interface DetailMapper extends EntityMapper<DetailDTO, Detail> {

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "product.id", target = "productId")
    DetailDTO toDto(Detail detail);

    @Mapping(source = "orderId", target = "order")
    @Mapping(source = "productId", target = "product")
    Detail toEntity(DetailDTO detailDTO);

    default Detail fromId(Long id) {
        if (id == null) {
            return null;
        }

        Detail detail = new Detail();
        detail.setId(id);
        return detail;
    }
}
