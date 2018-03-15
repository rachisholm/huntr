package io.whiskyhuntr.contracts;


import io.swagger.annotations.ApiOperation;
import io.whiskyhuntr.contracts.domain.ProductDTO;
import io.whiskyhuntr.contracts.domain.StoreDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/hunter")
public interface HunterContract {

    @RequestMapping(value = "/stores/{storeId}", method= RequestMethod.GET)
    @ApiOperation(value = "Get Store Data", response = StoreDTO.class, tags = "store")
    StoreDTO getStore(
            @PathVariable int storeId
    );

    @RequestMapping(value = "/stores", method= RequestMethod.GET)
    @ApiOperation(value = "Get All Store Data", response = List.class, tags = "store")
    List<StoreDTO> getStoreList();

    @RequestMapping(value = "/stores", method= RequestMethod.POST)
    @ApiOperation(value = "Create Store Data", response = StoreDTO.class, tags = "store")
    StoreDTO createStore(
            StoreDTO store
    );

    @RequestMapping(value = "/products/{productId}", method= RequestMethod.GET)
    @ApiOperation(value = "Get Product Data", response = ProductDTO.class, tags = "product")
    ProductDTO getProduct(
            @PathVariable int productId
    );

    @RequestMapping(value = "/products", method= RequestMethod.GET)
    @ApiOperation(value = "Get All Product Data", response = List.class, tags = "product")
    List<ProductDTO> getProductList();

    @RequestMapping(value = "/products", method= RequestMethod.POST)
    @ApiOperation(value = "Create Product Data", response = ProductDTO.class, tags = "product")
    ProductDTO createProduct(
            ProductDTO product
    );


}