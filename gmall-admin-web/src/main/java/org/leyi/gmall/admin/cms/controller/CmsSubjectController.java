package org.leyi.gmall.admin.cms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.leyi.gmall.cms.service.ISubjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api("关联专题管理")
@RestController
@RequestMapping("/subject")
public class CmsSubjectController {

    @Reference
    private ISubjectService subjectService;

    @GetMapping("listAll")
    public R get(){

        return R.ok(subjectService.list()).setCode(200);
    }

}
