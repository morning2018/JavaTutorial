package com.learning.springcloud.dto;

import lombok.Data;

/**
 * 功能描述：
 *  产品信息
 * @author morning
 * @date 2020/4/30 13:54
 * @version v0.0.1
 */
@Data
public class ProductDto {
    private Long productId;
    private String productName;
}
