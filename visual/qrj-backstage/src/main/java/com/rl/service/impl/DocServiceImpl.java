package com.rl.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rl.common.Result;
import com.rl.mapper.DocMapper;
import com.rl.model.entity.Doc;
import com.rl.model.req.DocReq;
import com.rl.model.resp.DocResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service("docService")
public class DocServiceImpl implements com.rl.service.DocService {

    @Autowired
    private DocMapper docMapper;

    @Override
    public Result findAll(Integer pageSize,Integer pageNum) {
        QueryWrapper wrapper = new QueryWrapper();
        return Result.ok(docMapper.selectPage(new Page<>(pageSize,pageNum),wrapper));
    }

    // 通过链接添加
    @Override
    public Result insertToUrl(DocReq docReq) {
        String title = docReq.getTitle();
        String url = docReq.getUrl();
        String docReqAbstract = docReq.getDocAbstract();
        String coverUrl = docReq.getCoverUrl();
        if(title==null || title.length()==0){
            return Result.build(500,"标题不能为空");
        }
        if(docReqAbstract==null || docReqAbstract.length()==0){
            return Result.build(500,"摘要不能为空且不超过20");
        }
        if(url==null || url.length()==0){
            return Result.build(500,"链接不能为空");
        }
        if(coverUrl==null || coverUrl.length()==0){
            return Result.build(500,"封面图不能为空");
        }
        // 发布状态为未发布
        docReq.setPublishStatus(0);
        // 设置创建时间
        docReq.setCreateTime(LocalDateTime.now());
        Doc doc = new Doc();
        BeanUtils.copyProperties(docReq,doc);
        docMapper.insert(doc);
        return Result.build(200,"添加成功");
    }

    // 我的文档-发布
    @Override
    public Result myDocPublish(DocReq docReq) {
        String title = docReq.getTitle();
        String docReqAbstract = docReq.getDocAbstract();
        String coverUrl = docReq.getCoverUrl();
        if(title==null||title.length()==0){
            return Result.build(500,"标题不能为空");
        }
        if(docReqAbstract==null||docReqAbstract.length()==0){
            return Result.build(500,"摘要不能为空且不超过20");
        }
        if(docReqAbstract.length()>=20){
            return Result.build(500,"摘要不能为空且不超过20");
        }
        if(coverUrl==null||coverUrl.length()==0){
            return Result.build(500,"封面图不能为空");
        }

        // 设置为未发布状态
        docReq.setPublishStatus(0);
        // 设置发布时间
        //docReq.setPublishTime(null);

        Doc doc = new Doc();
        BeanUtils.copyProperties(docReq,doc);
        // 更新文档
        docMapper.updateById(doc);
        return Result.build(200,"发布成功");
    }

    // 查看所有我的文档
    @Override
    public Result myDocFindAll(Integer pageSize,Integer pageNum) {
        QueryWrapper<Doc> wrapper = new QueryWrapper<>();
        wrapper.isNull("url");
        return Result.ok(docMapper.selectPage(new Page<>(pageSize,pageNum),wrapper));
    }

    // 我的文档-创建
    @Override
    public Result myDocCreate(DocReq docReq) {
        // 设置创建时间
        docReq.setCreateTime(LocalDateTime.now());
        try {
            Doc doc = new Doc();
            BeanUtils.copyProperties(docReq,doc);
            docMapper.insert(doc);
        }
        catch (Exception e){
            return Result.build(500,"创建状态错误");
        }
        return Result.build(200,"创建成功");
    }

    // 编辑我的文档
    public DocResp findById(Integer id){
        Doc doc = docMapper.selectById(id);
        DocResp docResp = new DocResp();
        BeanUtils.copyProperties(doc,docResp);
        return docResp;
    }

    // 更新我的文档
    @Override
    public Result updateMyDoc(DocReq docReq) {
        String title = docReq.getTitle();
        try {
            Doc doc = new Doc();
            if(title == null || title.length() == 0){
                return Result.fail();
            }
            BeanUtils.copyProperties(docReq,doc);
            doc.setUpdateTime(LocalDateTime.now());
            docMapper.updateById(doc);
        }catch (Exception e){
            System.out.println(e);
            return Result.fail();
        }
        return Result.ok();
    }

    @Override
    public boolean saveBatch(Collection<Doc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Doc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Doc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Doc entity) {
        return false;
    }

    @Override
    public Doc getOne(Wrapper<Doc> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Doc> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Doc> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Doc> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Doc> getEntityClass() {
        return null;
    }

}
