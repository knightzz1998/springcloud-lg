package cn.knightzz.controller;

import cn.knightzz.entity.Products;
import cn.knightzz.service.ProductsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王天赐
 * @title: ProductController
 * @projectName springcloud-lg
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/2/11 10:56
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Resource
    ProductsService productsService;

    @RequestMapping("/query/{id}")
    public Products query(@PathVariable Integer id){
        return productsService.findById(id);
    }
}
