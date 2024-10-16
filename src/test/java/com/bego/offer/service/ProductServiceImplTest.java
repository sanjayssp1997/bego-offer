package com.bego.offer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;


    private Map<String, List<Integer>> getMapData() {
        Map<String, List<Integer>> data = new HashMap<>();
        data.put("Discounted Items: ", List.of(50, 40, 20));
        data.put("Payable Items: ", List.of( 60, 50, 30, 10));
        return data;
    }

    @Test
    void getDiscoutedAndPaybleItem() {
        List<Integer> list  = List.of(10, 20, 30, 40, 50,50, 60);
        final Map<String, List<Integer>> discoutedAndPaybleItem = productService.getDiscoutedAndPaybleItem(list);
        Assertions.assertEquals(discoutedAndPaybleItem,getMapData());
        Assertions.assertNotNull(list);
    }
}