package com.duanxin.hwjy.infrastructure.client.file;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.domain.upload.FastImageFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author duanxin
 * @version 1.0
 * @className FdfsClient
 * @date 2021/03/20 09:45
 */
@Service
@AllArgsConstructor
@Slf4j
public class FdfsClient implements FileClient{

    private final FastFileStorageClient storageClient;

    @Override
    public String uploadFile(File file, InputStream is) {
        FastFile fastFile = createFile(file, is);
        StorePath path = doUploadFile(fastFile);
        return Objects.requireNonNull(path).getFullPath();
    }

    @Override
    public String uploadImage(File imageFile, InputStream is) {
        FastImageFile fastImageFile = createImageFile(imageFile, is);
        StorePath path = doUploadImage(fastImageFile);
        return Objects.requireNonNull(path).getFullPath();
    }

    private StorePath doUploadFile(FastFile fastFile) {
        return storageClient.uploadFile(fastFile);
    }

    private FastFile createFile(File file, InputStream is) {
        Set<MetaData> metaDataSet = createMetaData();
        String fileExtName = FilenameUtils.getExtension(file.getName());
        return new FastFile.Builder().
                withFile(is, file.length(), fileExtName).
                withMetaData(metaDataSet).build();
    }

    private StorePath doUploadImage(FastImageFile fastImageFile) {
        return storageClient.uploadImage(fastImageFile);
    }

    private FastImageFile createImageFile(File imageFile, InputStream is) {
        Set<MetaData> metaDataSet = createMetaData();
        String fileExtName = FilenameUtils.getExtension(imageFile.getName());
        return new FastImageFile.Builder().
                withFile(is, imageFile.length(), fileExtName).
                withMetaData(metaDataSet).build();
    }

    private Set<MetaData> createMetaData() {
        Set<MetaData> set = new HashSet<>(2);
        set.add(new MetaData("Author", "duanxin"));
        set.add(new MetaData("CreateDate", LocalDateTime.now().toString()));
        return set;
    }
}
