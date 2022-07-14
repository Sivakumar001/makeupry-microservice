package com.skproject.makeuprycustomers.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems {
    private Long customerId;
    private Long productId;
    private int quantity;
}
