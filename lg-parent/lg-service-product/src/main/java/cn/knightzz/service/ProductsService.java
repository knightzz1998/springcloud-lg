package cn.knightzz.service;

import cn.knightzz.entity.Products;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 * @author knightzz98
 */
public interface ProductsService extends IService<Products> {


    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    public Products findById(Integer id);
}
