package com.duanxin.hwjy.infrastructure.client.file;

import com.duanxin.hwjy.infrastructure.config.FastDfsConfig;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.domain.upload.FastImageFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    private final FastDfsConfig config;

    @Override
    public String uploadFile(FileUploadRequestDto requestDto) {
        FastFile fastFile = createFile(requestDto);
        StorePath path = doUploadFile(fastFile);
        return config.getStorageResource() + Objects.requireNonNull(path).getFullPath();
    }

    @Override
    public String uploadImage(FileUploadRequestDto requestDto) {
        FastImageFile fastImageFile = createImageFile(requestDto);
        StorePath path = doUploadImage(fastImageFile);
        return config.getStorageResource() + Objects.requireNonNull(path).getFullPath();
    }

    private StorePath doUploadFile(FastFile fastFile) {
        return storageClient.uploadFile(fastFile);
    }

    private FastFile createFile(FileUploadRequestDto requestDto) {
        Set<MetaData> metaDataSet = createMetaData();
        return new FastFile.Builder().
                withFile(requestDto.getIs(), requestDto.getFileSize(), requestDto.getFileExtName()).
                withMetaData(metaDataSet).build();
    }

    private StorePath doUploadImage(FastImageFile fastImageFile) {
        return storageClient.uploadImage(fastImageFile);
    }

    private FastImageFile createImageFile(FileUploadRequestDto requestDto) {
        Set<MetaData> metaDataSet = createMetaData();
        return new FastImageFile.Builder().
                withFile(requestDto.getIs(), requestDto.getFileSize(), requestDto.getFileExtName()).
                withMetaData(metaDataSet).build();
    }

    private Set<MetaData> createMetaData() {
        Set<MetaData> set = new HashSet<>(2);
        set.add(new MetaData("Author", "duanxin"));
        set.add(new MetaData("CreateDate", LocalDateTime.now().toString()));
        return set;
    }
}
