package org.leyi.gmall.admin.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.leyi.gmall.admin.util.JwtTokenUtils;
import org.leyi.gmall.mbg.ums.entity.Admin;
import org.leyi.gmall.mbg.ums.service.IAdminService;
import org.leyi.gmall.mbg.ums.vo.UmsLoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;

@CrossOrigin
@Api("用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Reference
    private IAdminService adminService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Value("${gmall.jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${gmall.jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("/login")
    @ApiOperation("登陆")
    public R login(@Valid @RequestBody UmsLoginParam loginParam, BindingResult result) {

        Admin admin = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        if (admin == null) return R.failed("用户名或密码错误");

        // jwtToken 的组成部分：header + payLoad/负载 + sign/签名
        String jwtToken = jwtTokenUtils.generateToken(admin);

        HashMap<Object, Object> tokenMap = Maps.newHashMapWithExpectedSize(2);
        tokenMap.put("token", jwtToken);
        tokenMap.put("tokenHead", tokenHead);
        return R.ok(tokenMap).setCode(200);
    }

    @GetMapping("/info")
    @ApiOperation("查询用户信息")
    public R getAdminInfo(HttpServletRequest request) {

        String userName = jwtTokenUtils.getUserNameFromToken(request.getHeader(tokenHeader).substring(tokenHead.length()));

        Admin admin = adminService.getByUserName(userName);
        // MyBatisPlus的service简单方法可以用，复杂的方法（参数是QueryWrapper、参数是IPage的都不要用）
        // Admin admin = adminService.getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, userName));
        HashMap<Object, Object> dataMap = Maps.newHashMapWithExpectedSize(3);
        dataMap.put("username", userName);
        dataMap.put("roles", new String[]{"Test"});
        dataMap.put("icon", admin.getIcon());
        return R.ok(dataMap).setCode(200);
    }

}
