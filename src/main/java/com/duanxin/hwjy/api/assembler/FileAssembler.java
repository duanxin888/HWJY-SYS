package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.infrastructure.client.file.FileUploadRequestDto;
import com.duanxin.hwjy.infrastructure.common.constants.ImageFileSufConstants;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author duanxin
 * @version 1.0
 * @className FileAssembler
 * @date 2021/03/29 09:03
 */
@Slf4j
public class FileAssembler {

    private FileAssembler() {
    }

    public static FileUploadRequestDto multipartFile2UploadRequestDto(MultipartFile file) {
        FileUploadRequestDto dto = new FileUploadRequestDto();
        try {
            dto.setIs(new ByteArrayInputStream(file.getBytes()));
            dto.setFileSize(file.getSize());
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            if (ImageFileSufConstants.matchSufName(extension)) {
                dto.setFileExtName(extension);
            }
            return dto;
        } catch (IOException e) {
            log.warn("get MultipartFile [{}] byte exception", file.getOriginalFilename(), e);
            throw new HWJYCheckException(ResultEnum.ASSEMBLER_FILE2DTO_FAILED);
        }
    }
}
