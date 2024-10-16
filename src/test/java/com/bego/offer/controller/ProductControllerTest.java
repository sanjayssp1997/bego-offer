package com.bego.offer.controller;

import com.bego.offer.model.Product;
import com.bego.offer.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductServiceImpl productService;

    private Product getProduct() {
        Product product = new Product();
        product.setPriceList(List.of(10, 20, 30, 40, 50,50, 60));
        return product;
    }

    private Map<String, List<Integer>> getMapData() {
        Map<String, List<Integer>> data = new HashMap<>();
        data.put("Discounted Items: ", List.of(50, 40, 20));
        data.put("Payable Items: ", List.of( 60, 50, 30, 10));
        return data;
    }

    @Test
    void getDescountAndPayable() {
        Product product  = getProduct();
        Mockito.when(productService.getDiscoutedAndPaybleItem(Mockito.anyList())).thenReturn(getMapData());
        final ResponseEntity<Map<String, List<Integer>>> descountAndPayable = productController.getDescountAndPayable(product);
        final Map<String, List<Integer>> body = descountAndPayable.getBody();
        Assertions.assertEquals(getMapData(),body);
        Assertions.assertNotNull(product);
    }
}