package com.ada.tool.oss.service;

import com.ada.tool.config.CloudStorageConfig;
import com.ada.tool.oss.constant.OSSConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName:OssService
 * @author: Ada
 * @date 2019/11/13 16:37
 * @Description:
 */
@Component
public class OssService {
    @Autowired
    private CloudStorageConfig config;

    public CloudStorageService build() {
        if (config.getType().equals(OSSConstant.TYPE_QINIU)) {
            return new QiniuCloudStorageService(config);
        } else if (config.getType().equals(OSSConstant.TYPE_ALIYUN)) {
            return new AliyunCloudStorageService(config);
        } else if (config.getType().equals(OSSConstant.TYPE_QCLOUD)) {
            return new QcloudCloudStorageService(config);
        }
        return null;
    }
}

