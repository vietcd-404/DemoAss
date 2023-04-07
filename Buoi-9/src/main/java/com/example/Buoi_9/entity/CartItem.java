package com.example.Buoi_9.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartItem {
    private String productId;
    private String productName;
    private int quantity=1;

    private double price;
}
