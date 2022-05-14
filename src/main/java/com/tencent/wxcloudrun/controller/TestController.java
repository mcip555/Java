package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BillInfoRequest;
import com.tencent.wxcloudrun.dto.TestRequest;
import com.tencent.wxcloudrun.model.BillInfo;
import com.tencent.wxcloudrun.service.BillInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
* (balance)表控制层
*
* @author xxxxx
*/
@RestController
public class TestController {
    final Logger logger;
    public TestController() {
        this.logger = LoggerFactory.getLogger(TestController.class);
    }

    @GetMapping(value = "/test")
    ApiResponse test(@RequestBody TestRequest request){

        logger.info("/api/count post request, action: {}", "ok");

        return ApiResponse.ok("ok");
    }



}
