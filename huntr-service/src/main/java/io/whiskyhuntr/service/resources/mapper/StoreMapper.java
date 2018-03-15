package io.whiskyhuntr.service.resources.mapper;

import io.whiskyhuntr.contracts.domain.StoreDTO;
import io.whiskyhuntr.service.resources.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper( StoreMapper.class );

    StoreDTO toStoreDto(Store store);
    Store toStore(StoreDTO storeDTO);
}
