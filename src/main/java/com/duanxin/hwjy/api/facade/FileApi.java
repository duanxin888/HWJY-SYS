package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.FileAssembler;
import com.duanxin.hwjy.infrastructure.client.file.FileClient;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author duanxin
 * @version 1.0
 * @className FileApi
 * @date 2021/03/20 15:37
 */
@RestController
@RequestMapping("/api/v1/file")
@AllArgsConstructor
public class FileApi {

    private final FileClient fileClient;

    @PostMapping
    public ResponseResult uploadImage(MultipartFile file) {
        return ResponseResult.success(fileClient.uploadImage(FileAssembler.multipartFile2UploadRequestDto(file)));
    }
}
