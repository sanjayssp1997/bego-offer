package com.bego.offer.controller;

import com.bego.offer.model.Product;
import com.bego.offer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-discount-and-payable")
    public ResponseEntity<Map<String, List<Integer>>> getDescountAndPayable(@RequestBody Product product) {
        final Map<String, List<Integer>> discoutedAndPaybleItem = productService.getDiscoutedAndPaybleItem(product.getPriceList());
        return ResponseEntity.accepted().body(discoutedAndPaybleItem);
    }

}
