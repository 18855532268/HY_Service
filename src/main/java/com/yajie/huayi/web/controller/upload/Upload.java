package com.yajie.huayi.web.controller.upload;


import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.util.CommonUtil;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/upload")
public class Upload {
    @Value("${upload.temp}")
    private String tempFilePath;
    @Value("${visit.path}")
    private String visitFilePath;

    @PostMapping("/uploadDoc")
    public ReturnVO uploadImage(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String id = CommonUtil.getUUID();
        log.info("上传文件:{}",fileName);
        String substring = fileName.substring(fileName.lastIndexOf("."));
        if (StringUtils.isBlank(fileName) ) {
            throw new ErrorMessageException("上传的文件名错误或格式受限");
        }
        log.info("上传后缀:{}",substring);

        String transFilePath = tempFilePath + "/" + id + substring;
        log.info("上传路径:{}", transFilePath);
        File filePath = new File(transFilePath);

        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }

        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            log.error("上传文件失败");
            log.error("", e);
            throw new ErrorMessageException("服务器接收文件失败");
        }

        String basePath = request.getScheme() + "://" + request.getServerName() + visitFilePath + "/" + id + substring;
        log.info("访问地址:{}", basePath);
        return ReturnVO.getSuccess(basePath);
    }


    /**
     * 配置上传文件大小的配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("5MB");
        /// 总上传数据大小
        factory.setMaxRequestSize("5MB");
        return factory.createMultipartConfig();
    }
}
