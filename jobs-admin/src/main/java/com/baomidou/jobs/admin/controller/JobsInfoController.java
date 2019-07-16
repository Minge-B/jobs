package com.baomidou.jobs.admin.controller;

import com.baomidou.jobs.starter.service.IJobsInfoService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.jobs.starter.api.JobsResponse;
import com.baomidou.jobs.starter.model.JobsInfo;

import javax.annotation.Resource;

/**
 * 任务信息
 *
 * @author xxl jobob
 * @since 2019-05-31
 */
@RestController
@RequestMapping("/v1/jobs-info")
public class JobsInfoController extends BaseController {
    @Resource
    private IJobsInfoService jobInfoService;

    /**
     * 分页
     */
    @GetMapping("/page")
    public JobsResponse<Object> page(JobsInfo jobInfo) {
        return success(null);//jobInfoService.page(request, jobInfo));
    }

    /**
     * 总任务数
     */
    @GetMapping("/count")
    public JobsResponse<Integer> count() {
        return success(jobInfoService.count());
    }

    /**
     * 执行
     */
    @PostMapping("/execute-{id}")
    public JobsResponse<Boolean> execute(@PathVariable("id") Long id, String param) {
        return success(jobInfoService.execute(id, param));
    }

    /**
     * 启动
     */
    @PostMapping("/start-{id}")
    public JobsResponse<Boolean> start(@PathVariable("id") Long id) {
        return success(jobInfoService.start(id));
    }

    /**
     * 停止
     */
    @PostMapping("/stop-{id}")
    public JobsResponse<Boolean> stop(@PathVariable("id") Long id) {
        return success(jobInfoService.stop(id));
    }

    /**
     * 删除
     */
    @PostMapping("/remove-{id}")
    public JobsResponse<Boolean> remove(@PathVariable("id") Long id) {
        return success(jobInfoService.remove(id));
    }
}