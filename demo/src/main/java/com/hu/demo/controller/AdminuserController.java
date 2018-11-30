package com.hu.demo.controller;


import com.hu.demo.service.impl.AdminuserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
@RestController
@Slf4j
public class AdminuserController {
    @Autowired
    private AdminuserServiceImpl adminuserService;

    @RequestMapping(value = "/callable", method = RequestMethod.GET, produces = "text/html")
    public Callable<String> executeSlowTask() {
        log.info("Request received");
        Callable<String> callable = adminuserService::execute;
        log.info("Servlet thread released");

        return callable;
    }


    @RequestMapping(value = "/deferred", method = RequestMethod.GET, produces = "text/html")
    public DeferredResult<String> executeSlowTask1() {
        log.info("Request received");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(adminuserService::execute)
                .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
        log.info("Servlet thread released");

        return deferredResult;
    }
}

