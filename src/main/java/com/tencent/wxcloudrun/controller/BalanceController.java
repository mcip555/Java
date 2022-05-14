package com.tencent.wxcloudrun.controller;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BalanceRequest;
import com.tencent.wxcloudrun.model.Balance;
import com.tencent.wxcloudrun.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* (balance)表控制层
*
* @author xxxxx
*/
@RestController
public class BalanceController {
    final BalanceService balanceService;
    final Logger logger;
    public BalanceController(@Autowired BalanceService balanceService) {
        this.balanceService = balanceService;
        this.logger = LoggerFactory.getLogger(BalanceController.class);
    }

    @PostMapping(value = "/api/balance/selectListByCardId")
    ApiResponse selectByCardId(@RequestBody BalanceRequest request){
        logger.info("/api/count post request, action: {}", request.getCardid());
        List<Balance> balanceList = balanceService.selectListByCardId(request.getCardid());
        return ApiResponse.ok(balanceList);
    }

}
