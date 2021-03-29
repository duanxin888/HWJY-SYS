package com.duanxin.hwjy.infrastructure.client.file;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

/**
 * @author duanxin
 * @version 1.0
 * @className FileUploadRequestDto
 * @date 2021/03/29 08:53
 */
@Setter
@Getter
public class FileUploadRequestDto {

    private String fileExtName;

    private InputStream is;

    private long fileSize;
}
