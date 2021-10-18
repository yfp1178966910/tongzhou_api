package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.utils.TencentCloudConfig;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static java.util.UUID.randomUUID;


@Controller
@RequestMapping(path = {"/upload","/applets/upload"})
public class UploadController {
    @Autowired
    TencentCloudConfig tencentCloudConfig;

    COSClient cosClient;

    private void createCOSClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = tencentCloudConfig.UPLOAD_SecretId;
        String secretKey = tencentCloudConfig.UPLOAD_SecretKey;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(tencentCloudConfig.UPLOAD_Region);
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
    }

    private COSClient getCOSClient() {
        if (cosClient == null) {
            createCOSClient();
        }
        return cosClient;
    }

    @PostMapping("putFile")
    @ResponseBody
    public Result putFile(@RequestParam(name = "multipartFile") MultipartFile multipartFile, @RequestParam(name = "key", required = false) String key) {

        COSClient cosClient = getCOSClient();
        if (multipartFile.isEmpty()) {
            throw new RuntimeException("获取不到上传文件");
        }

        try {
            if (key == null || key.equals("")) {
                String fileName = multipartFile.getOriginalFilename();

                String suffixName = fileName.contains(".")?  fileName.substring(fileName.lastIndexOf(".")):"";
                key = randomUUID().toString() + suffixName;
            }

//            multipartFile.transferTo(dest);
            PutObjectRequest putObjectRequest = new PutObjectRequest(tencentCloudConfig.UPLOAD_Bucket, key, multipartFile.getInputStream(), null);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
//            GeneratePresignedUrlRequest req =
//                    new GeneratePresignedUrlRequest(tencentCloudConfig.Bucket, key, HttpMethodName.GET);
// 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
// 这里设置签名在半个小时后过期
//            Date expirationDate = new Date(System.currentTimeMillis() + 30L*60L*10000000L);
//            req.setExpiration(expirationDate);
//            URL url = cosClient.generatePresignedUrl(req);
//            System.out.println(url.toString());
            return new Result(ResultCode.SUCCESS, "", tencentCloudConfig.UPLOAD_KEY_PREFIX + key);
        } catch (Exception e) {
            e.printStackTrace();
            cosClient.shutdown();
            return new Result(ResultCode.FAILED, "服务器错误", null);
        }

    }


}
//            this.cosClient.shutdown();
//            BucketWebsiteConfiguration bucketWebsiteConfiguration = cosClient.getBucketWebsiteConfiguration(tencentCloudConfig.Bucket);
//            //todo:
//            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
//// 设置bucket名称
//            listObjectsRequest.setBucketName(tencentCloudConfig.Bucket);
//// prefix表示列出的object的key以prefix开始
//            listObjectsRequest.setPrefix("");
//// deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
//            listObjectsRequest.setDelimiter("");
//// 设置最大遍历出多少个对象, 一次listobject最大支持1000
//            listObjectsRequest.setMaxKeys(1000);
//            ObjectListing objectListing = null;
//            do {
//                objectListing = cosClient.listObjects(listObjectsRequest);
//                // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
//                List<String> commonPrefixs = objectListing.getCommonPrefixes();
//
//                // object summary表示所有列出的object列表
//                List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
//                COSObjectSummary cosObjectSummary1 = cosObjectSummaries.get(cosObjectSummaries.size() - 1);
//                for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
//                    // 文件的路径key
//                    String key2 = cosObjectSummary.getKey();
//                    // 文件的etag
//                    String etag = cosObjectSummary.getETag();
//                    // 文件的长度
//                    long fileSize = cosObjectSummary.getSize();
//                    // 文件的存储类型
//                    String storageClasses = cosObjectSummary.getStorageClass();
//                }
//
//                String nextMarker = objectListing.getNextMarker();
//                listObjectsRequest.setMarker(nextMarker);
//            } while (objectListing.isTruncated());
//
//            String bucketName = "examplebucket-1250000000";

//
//    @PostMapping("initiatePartUpload")
//    @ResponseBody
//    public Result initiatePartUpload() {
//        createCOSClient();
//        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(tencentCloudConfig.Bucket, tencentCloudConfig.UPLOAD_SecretKey);
//        InitiateMultipartUploadResult initResponse = cosClient.initiateMultipartUpload(initRequest);
//        String uploadId = initResponse.getUploadId();
//        return new Result(200, "", uploadId);
//    }
//    @PostMapping("uploadPart")
//    @ResponseBody
//    public Result uploadPart(@RequestParam MultipartFile multipartFile,
//                                          @RequestParam(name ="uploadId") String uploadId,
//                                          @RequestParam(name ="partNumber")int partNumber) {
//        COSClient cosClient=getCOSClient();
//// 上传分块, 最多10000个分块, 分块大小支持为1M - 5G。
//// 分块大小设置为4M。如果总计 n 个分块, 则 1 ~ n-1 的分块大小一致，最后一块小于等于前面的分块大小。
//        List partETags = new ArrayList<PartETag>();
//        int partSize = 4 * 1024 * 1024;
//        byte data[] = new byte[partSize];
//        ByteArrayInputStream partStream = new ByteArrayInputStream(data);
//        // partStream 代表 part 数据的输入流, 流长度为 partSize
//        UploadPartRequest uploadRequest = new UploadPartRequest().withBucketName(tencentCloudConfig.Bucket).
//                withUploadId(uploadId).withKey(tencentCloudConfig.UPLOAD_SecretKey).withPartNumber(partNumber).
//                withInputStream(partStream).withPartSize(partSize);
//        UploadPartResult uploadPartResult = cosClient.uploadPart(uploadRequest);
//        // 获取分块的 Etag
////        String etag = uploadPartResult.getETag();
////        // 获取分块的 CRC64
////        String crc64Ecma = uploadPartResult.getCrc64Ecma();
////        partETags.add(new PartETag(partNumber, etag));  // partETags 记录所有已上传的 part 的 Etag 信息
//// ... 上传 partNumber 第2个到第 n 个分块
//        return new Result(200,"",uploadPartResult);
//    }



