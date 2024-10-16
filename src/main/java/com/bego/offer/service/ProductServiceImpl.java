package com.bego.offer.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Map<String, List<Integer>> getDiscoutedAndPaybleItem(List<Integer> list) {
        Map<String, List<Integer>> finalDiscountAndPayableDetials = new HashMap<>();
        final List<Integer> priceList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> discountedList =  new ArrayList<>();
        List<Integer> payableList = new ArrayList<>();

        payableList = IntStream.range(0, priceList.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(priceList::get)
                .collect(Collectors.toList());

        discountedList = IntStream.range(0, priceList.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(priceList::get)
                .collect(Collectors.toList());

        finalDiscountAndPayableDetials.put("Discounted Items: ",discountedList);
        finalDiscountAndPayableDetials.put("Payable Items: ", payableList);


        return finalDiscountAndPayableDetials;
    }
}


