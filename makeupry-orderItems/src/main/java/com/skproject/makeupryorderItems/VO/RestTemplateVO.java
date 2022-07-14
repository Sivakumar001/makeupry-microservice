package com.skproject.makeupryorderItems.VO;

import java.util.List;

import com.skproject.makeupryorderItems.entity.OrderItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestTemplateVO {
    private List<OrderItems> orders;
}
