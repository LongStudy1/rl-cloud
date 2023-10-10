package com.rl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rl.common.Result;
import com.rl.model.entity.Doc;
import com.rl.model.req.DocReq;
import com.rl.model.resp.DocResp;

public interface DocService extends IService<Doc> {

    Result findAll(Integer pageSize, Integer pageNum);

    DocResp findById(Integer id);

    Result insertToUrl(DocReq docReq);

    Result myDocPublish(DocReq docReq);

    Result myDocFindAll(Integer pageSize, Integer pageNum);

    Result myDocCreate(DocReq docReq);

    Result updateMyDoc(DocReq docReq);

}