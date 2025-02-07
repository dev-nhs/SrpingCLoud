package com.devnhs.springcloud.msvc_items.services;

import com.devnhs.springcloud.msvc_items.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> findAll();
    Optional<Item> findById(Long id);
}
