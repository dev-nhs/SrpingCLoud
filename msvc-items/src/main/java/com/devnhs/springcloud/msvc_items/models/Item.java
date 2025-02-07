package com.devnhs.springcloud.msvc_items.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Product product;
    private int quantity;

    public Double getTotal() {
        return product.getPrice() * quantity;
    }
}
