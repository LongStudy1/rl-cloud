package com.rl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rl.model.entity.Product;

import java.util.List;

public interface ProductService extends IService<Product> {

    List<Product> findAll();

}
