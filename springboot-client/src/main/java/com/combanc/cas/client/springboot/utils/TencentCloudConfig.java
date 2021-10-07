package com.combanc.cas.client.springboot.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration

@AllArgsConstructor
@NoArgsConstructor
public class TencentCloudConfig {
    @Value("${COSupload.Bucket}")
    public  String UPLOAD_Bucket;
    @Value("${COSupload.Region}")
    public  String UPLOAD_Region;

    @Value("${COSupload.secretId}")
    public  String UPLOAD_SecretId;

    @Value("${COSupload.secretKey}")
    public  String UPLOAD_SecretKey;
    @Value("${COSupload.key.prefix}")
    public  String UPLOAD_KEY_PREFIX;
}
