package com.rl.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rl.model.entity.Product;
import com.rl.mapper.ProductMapper;
import com.rl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        QueryWrapper wrapper = new QueryWrapper();
        List<Product> list = productMapper.selectList(wrapper);
        return list;
    }

    @Override
    public boolean saveBatch(Collection<Product> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Product> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Product> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Product entity) {
        return false;
    }

    @Override
    public Product getOne(Wrapper<Product> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Product> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Product> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Product> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Product> getEntityClass() {
        return null;
    }
}
