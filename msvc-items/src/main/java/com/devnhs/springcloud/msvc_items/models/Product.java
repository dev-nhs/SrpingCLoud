package com.devnhs.springcloud.msvc_items.models;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Double price;
    private LocalDate createAt;
    private int port;
}
