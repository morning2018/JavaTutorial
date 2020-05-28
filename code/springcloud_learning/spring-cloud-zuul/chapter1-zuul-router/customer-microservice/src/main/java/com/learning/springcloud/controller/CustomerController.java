package com.learning.springcloud.controller;

import com.learning.springcloud.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 *  客户相关服务
 * @author morning
 * @date 2020/4/30 13:52
 * @version v0.0.1
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    /**
     * 日志打印
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    /**
      * 功能描述:
      *  新增客户
      * @author morning
      * @date 2020/4/30 13:57
      * @version v0.0.1
       * @param customer
       * @return  void
      */
    @PostMapping
    public void save(CustomerDto customer) {
        LOG.info("新增：", customer);
    }


    @GetMapping("/{id}")
    public CustomerDto getInfo(@PathVariable("id") Long id) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(id);
        customerDto.setCustomerName("zhangsan");
        return customerDto;
    }
}
