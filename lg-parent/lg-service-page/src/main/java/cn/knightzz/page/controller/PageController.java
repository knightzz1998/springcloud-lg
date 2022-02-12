package cn.knightzz.page.controller;

import cn.knightzz.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author 王天赐
 * @title: PageController
 * @projectName springcloud-lg
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/2/11 11:55
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id){

        Products product = restTemplate.getForObject("http://localhost:9000/products/query/" + id, Products.class);
        System.out.println("从 lg-service-product 模块得到的数据 " + product);
        return product;
    }
}
