package com.duanxin.hwjy.infrastructure.client.file;

import java.io.File;
import java.io.InputStream;

/**
 * @author duanxin
 * @version 1.0
 * @className FileClient
 * @date 2021/03/20 09:29
 */
public interface FileClient {

    /**
     * upload file
     * @param file upload of file {@link File}
     * @date 2021/3/20 9:31
     * @return the path {@link String} of the file on the remote server
     */
    String uploadFile(File file, InputStream is);

    /**
     * upload image file
     * @param imageFile upload of image file {@link File}
     * @date 2021/3/20 9:41
     * @return the path {@link String} of the image file on the remote server
     */
    String uploadImage(File imageFile, InputStream is);
}
