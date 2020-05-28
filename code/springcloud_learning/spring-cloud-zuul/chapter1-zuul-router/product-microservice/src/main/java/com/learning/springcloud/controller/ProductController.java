package com.learning.springcloud.controller;

import com.learning.springcloud.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *  产品服务
 * @author morning
 * @date 2020/4/30 13:52
 * @version v0.0.1
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    /**
     * 日志打印
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    /**
      * 功能描述:
      *  新增用户
      * @author morning
      * @date 2020/4/30 13:57
      * @version v0.0.1
       * @param product
       * @return  void
      */
    @PostMapping
    public void save(ProductDto product) {
        LOG.info("新增：", product);
    }
}
