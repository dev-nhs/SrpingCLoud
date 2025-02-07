package com.devnhs.springcloud.msvc_items.controllers;

import com.devnhs.springcloud.msvc_items.models.Item;
import com.devnhs.springcloud.msvc_items.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<Item> list() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional<Item> itemOptional = itemService.findById(id);

        if(itemOptional.isPresent()){
            return ResponseEntity.ok(itemOptional.orElseThrow());
        }

        return ResponseEntity.status(404).body(Collections.singletonMap("message", "Item not found in msvc-products"));

    }
}
