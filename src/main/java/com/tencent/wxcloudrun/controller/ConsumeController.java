package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ConsumeRecordRequest;
import com.tencent.wxcloudrun.dto.TestRequest;
import com.tencent.wxcloudrun.model.Bill;
import com.tencent.wxcloudrun.model.ConsumeRecord;
import com.tencent.wxcloudrun.service.ConsumeRecordService;
import com.tencent.wxcloudrun.service.ConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* (balance)表控制层
*
* @author xxxxx
*/
@RestController
public class ConsumeController {
    final Logger logger;
    final ConsumeService consumeService;
    final ConsumeRecordService consumeRecordService;
    public ConsumeController(@Autowired ConsumeService consumeService,@Autowired ConsumeRecordService consumeRecordService) {
        this.consumeService = consumeService;
        this.consumeRecordService = consumeRecordService;
        this.logger = LoggerFactory.getLogger(ConsumeController.class);
    }

    @PostMapping(value = "/api/consume/showConsumeList")
    ApiResponse showConsumeList(){
        logger.info("/api/count post request, action: {}", "ok");
        List<Bill> billList = consumeService.showConsumeListPage();
        return ApiResponse.ok(billList);
    }

    @PostMapping(value = "/api/consume/showConsumeInfo")
    ApiResponse showConsumeInfo(@RequestBody ConsumeRecordRequest request){
        logger.info("/api/count post request, action: {}", "ok");
        List<ConsumeRecord> consumeRecordList = consumeRecordService.selectByConsumeId(request.getConsumeId());
        return ApiResponse.ok(consumeRecordList);
    }


}
