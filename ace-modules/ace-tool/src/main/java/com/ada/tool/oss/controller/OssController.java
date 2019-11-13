package com.ada.tool.oss.controller;

import com.ada.common.exception.BaseException;
import com.ada.common.response.ObjectRestResponse;
import com.ada.tool.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName:OssController
 * @author: Ada
 * @date 2019/11/13 16:36
 * @Description:
 */
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @RequestMapping("/upload")
    public ObjectRestResponse<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new BaseException("上传文件不能为空");
        }
        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = ossService.build().uploadSuffix(file.getBytes(), suffix);
        return new ObjectRestResponse<>().data(url);
    }
}
