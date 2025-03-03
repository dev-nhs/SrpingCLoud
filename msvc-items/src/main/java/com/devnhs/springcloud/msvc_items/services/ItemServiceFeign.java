package com.devnhs.springcloud.msvc_items.services;

import com.devnhs.springcloud.msvc_items.clients.ProductFeignClient;
import com.devnhs.springcloud.msvc_items.models.Item;
import com.devnhs.springcloud.msvc_items.models.Product;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceFeign implements ItemService{

    private final ProductFeignClient client;

    @Override
    public List<Item> findAll() {
        return client.findAll()
                .stream()
                .map(product -> new Item(product, new Random().nextInt(10)+1))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {

        try {
            Product product = client.details(id);
            return Optional.of( new Item(product, new Random().nextInt(10)+1));
        }catch (FeignException e){
            return Optional.empty();
        }

    }
}
