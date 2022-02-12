package cn.knightzz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.knightzz.entity.Products;
import cn.knightzz.service.ProductsService;
import cn.knightzz.mapper.ProductsMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author knightzz98
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
    implements ProductsService{

    @Override
    public Products findById(Integer id) {
        // 可以直接使用 baseMapper 查询数据
        Products products = baseMapper.selectById(id);
        System.out.println(products);
        return products;
    }
}




