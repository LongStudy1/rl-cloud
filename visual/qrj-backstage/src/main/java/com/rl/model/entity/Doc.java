package com.rl.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName(value = "doc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doc implements Serializable {

    /**
     * 文档id
     */
    @TableId
    private Integer id;

    /**
     * 乐享文档id
     */
    private String docId;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 摘要
     */
    @Length(max = 20,message = "最大长度不超过20")
    @TableField(value = "abstract")
    private String docAbstract;

    /**
     * 文档链接
     */
    private String url;

    /**
     * 文档地址
     */
    private String docAddress;

    /**
     * 封面地址
     */
    private String coverUrl;

    /**
     * 1:住宅梯首页，2:bivale
     */
    private Integer publishAddress;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 发布状态 1:发布了 0:未发布
     */
    private Integer publishStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private String createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     *
     */
    private String updateBy;
}
