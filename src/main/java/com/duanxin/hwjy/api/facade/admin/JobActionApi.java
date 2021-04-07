package com.duanxin.hwjy.api.facade.admin;

import com.duanxin.hwjy.api.job.service.JobActionManagerService;
import com.duanxin.hwjy.api.job.service.JobActionType;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanxin
 * @version 1.0
 * @className JobActionApi
 * @date 2021/02/20 22:03
 */
@RestController
@RequestMapping("/api/v1/admin/job")
@AllArgsConstructor
public class JobActionApi {

    private final JobActionManagerService jobActionManagerService;

    @GetMapping("/{jobActionType}")
    public ResponseResult jobAction(@PathVariable JobActionType jobActionType) {
        jobActionManagerService.jobAction(jobActionType);
        return ResponseResult.success();
    }
}
