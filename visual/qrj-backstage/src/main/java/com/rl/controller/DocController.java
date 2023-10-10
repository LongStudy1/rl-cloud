package com.rl.controller;

import com.rl.common.Result;
import com.rl.model.req.DocReq;
import com.rl.model.resp.DocResp;
import com.rl.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doc")
public class DocController {

    @Autowired
    private DocService docReqService;

    // 查询所有文档
    @GetMapping("findAll")
    public Result findAll(@RequestParam(defaultValue = "1") Integer pageSize,
                          @RequestParam(defaultValue = "10") Integer pageNum){
        return Result.ok(docReqService.findAll(pageSize,pageNum));
    }

    // 根据链接添加文档
    @PostMapping("addToUrl")
    public Result addToUrl(DocReq docReq){
       return docReqService.insertToUrl(docReq);
    }

    // 我的文档-发布
    @PutMapping("myDocPublish")
    public Result myDocPublish(DocReq docReq){
       return docReqService.myDocPublish(docReq);
    }

    // 查看我的文档
    @GetMapping("myDocFindAll")
    public Result myDocFindAll(@RequestParam(defaultValue = "1") Integer pageSize,
                               @RequestParam(defaultValue = "10") Integer pageNum){
        return docReqService.myDocFindAll(pageSize,pageNum);
    }

    // 我的文档-创建
    @PostMapping("myDocCreate")
    public Result myDocCreate(DocReq docReq){
        return docReqService.myDocCreate(docReq);
    }

    // 编辑文档
    @GetMapping("editDoc")
    public Result editDoc(Integer id){
        return Result.ok(docReqService.findById(id));
    }

    // 更新我的文档
    @PutMapping("updateMyDoc")
    public Result updateMyDoc(DocReq docReq){
        return docReqService.updateMyDoc(docReq);
    }



}
