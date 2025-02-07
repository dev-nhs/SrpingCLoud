package com.devnhs.springcloud.msvc_items.services;

import com.devnhs.springcloud.msvc_items.models.Item;
import com.devnhs.springcloud.msvc_items.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.*;

@Primary
@Service
@RequiredArgsConstructor
public class ItemServiceWebClient implements ItemService{

    private final WebClient.Builder webClientBuilder;

    @Override
    public List<Item> findAll() {
        return webClientBuilder.build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Product.class)
                .map(product -> new Item(product, new Random().nextInt(10)+1))
                .collectList()
                .block();
    }

    @Override
    public Optional<Item> findById(Long id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        try {
            return webClientBuilder.build().get().uri("/{id}", params)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Product.class)
                    .map(product -> new Item(product, new Random().nextInt(10)+1))
                    .blockOptional();

        }catch (WebClientResponseException e){
            return Optional.empty();
        }


    }
}
