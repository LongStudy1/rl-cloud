package com.rl.controller;

import com.rl.model.entity.Product;
import com.rl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Product> findAll(){
        return productService.findAll();
    }

}
