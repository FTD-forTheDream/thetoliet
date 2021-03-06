package com.orange.wc.mouldes.toilet.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.orange.wc.common.ResultData;
import com.orange.wc.common.ToiletDataUtils;
import com.orange.wc.mouldes.toilet.service.ToiletService;

import io.swagger.annotations.ApiOperation;

/**
 * @Title: ToiletController
 * @Prject: wc
 * @Package: com.orange.wc.mouldes.toilet.controller
 * @Description: 主要服务路由地址
 * @author: willinggod
 * @date: 2018/9/29 11:18
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
@RestController("/main")
public class ToiletController {
    @Autowired
    private ToiletService toiletService;

    /**
     * 查询当前所有蹲位信息
     * @return ResultData
     * @throws Exception
     * @author willinggod
     */
    @ApiOperation("查询所有蹲位")
    @GetMapping("/queryToiletList")
    public ResultData queryToiletList() throws IOException {
        //TODO  之后需要考虑根据位置进行定位，给出附近的厕所信息
        ResultData resultData=new ResultData();
        resultData.put("data",ToiletDataUtils.getAllToiletList());
        return resultData;
    }

    /**
     * 更新蹲位信息
     * @return ResultData
     * @throws Exception
     * @author willinggod
     */
    @ApiOperation("更新蹲位状态")
    @GetMapping("/updateToiletStatus/{toiletId}/{status}")
    public ResultData updateToiletStatus(@PathVariable("toiletId")String toiletId,@PathVariable("status")String status) throws IOException {
        return toiletService.changeToiletStatus(status,toiletId);
    }
}
