package io.whiskyhuntr.service.services;

import io.swagger.annotations.Api;
import io.whiskyhuntr.contracts.HunterContract;
import io.whiskyhuntr.contracts.domain.ProductDTO;
import io.whiskyhuntr.contracts.domain.StoreDTO;
import io.whiskyhuntr.service.dao.StoreDao;
import io.whiskyhuntr.service.resources.Product;
import io.whiskyhuntr.service.resources.Store;
import io.whiskyhuntr.service.resources.mapper.ProductMapper;
import io.whiskyhuntr.service.resources.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value="hunter", description="happy hunting")
public class HunterService implements HunterContract {

    @Autowired
    private StoreDao storeDao;

    @Override
    public StoreDTO getStore(int storeId){
        Store store = storeDao.getStoreById(storeId);
        return StoreMapper.INSTANCE.toStoreDto(store);
    }

    @Override
    public List<StoreDTO> getStoreList(){
        return new ArrayList<StoreDTO>();
    }

    @Override
    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = StoreMapper.INSTANCE.toStore(storeDTO);
        return StoreMapper.INSTANCE.toStoreDto(store);
    }

    @Override
    public ProductDTO getProduct(int productId){
        return new ProductDTO();
    }

    @Override
    public List<ProductDTO> getProductList(){
        return new ArrayList<ProductDTO>();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        return ProductMapper.INSTANCE.toProductDto(product);
    }
}
