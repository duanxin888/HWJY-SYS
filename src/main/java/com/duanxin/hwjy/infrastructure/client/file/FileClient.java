package com.duanxin.hwjy.infrastructure.client.file;

/**
 * @author duanxin
 * @version 1.0
 * @className FileClient
 * @date 2021/03/20 09:29
 */
public interface FileClient {

    /**
     * upload file
     * @param requestDto upload request dto of {@link FileUploadRequestDto}
     * @date 2021/3/20 9:31
     * @return the path {@link String} of the file on the remote server
     */
    String uploadFile(FileUploadRequestDto requestDto);

    /**
     * upload image file
     * @param requestDto requestDto upload request dto of {@link FileUploadRequestDto}
     * @date 2021/3/20 9:41
     * @return the path {@link String} of the image file on the remote server
     */
    String uploadImage(FileUploadRequestDto requestDto);
}
