package io.whiskyhuntr.service.resources.mapper;

import io.whiskyhuntr.contracts.domain.ProductDTO;
import io.whiskyhuntr.service.resources.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductDTO toProductDto(Product product);
    Product toProduct(ProductDTO productDTO);
}
