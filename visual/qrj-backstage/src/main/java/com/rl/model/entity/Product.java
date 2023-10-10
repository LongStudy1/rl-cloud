package com.rl.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @TableId
    private Integer pid;
    private String productName;
    private Integer price;
    private String hotline;
    private Integer status;
    private String productDesc;
    private String pImage;
    private Integer cid;
}
