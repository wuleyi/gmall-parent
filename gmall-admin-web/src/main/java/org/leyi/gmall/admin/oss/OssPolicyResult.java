package org.leyi.gmall.admin.oss;

import lombok.Data;

/**
 * 获取OSS上传授权返回结果
 */
@Data
public class OssPolicyResult {

    private String accessKeyId;
    private String policy;
    private String signature;
    private String dir;
    private String host;

}
