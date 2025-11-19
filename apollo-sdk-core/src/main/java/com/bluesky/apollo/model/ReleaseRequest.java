package com.bluesky.apollo.model;

import lombok.Data;

/**
 * Apollo 发布请求模型
 *
 * <p>该类用于封装向 Apollo Portal API 发送的命名空间发布请求，
 * 对应 Apollo Portal OpenAPI 的 release 接口请求格式。</p>
 *
 * <p>发布操作会创建一个新的 release，使命名空间中的所有配置变更生效，
 * 客户端将能够获取到最新的配置信息。</p>
 *
 * @author lantian
 * @date 2025/11/17
 * @version 1.0
 */
@Data
public class ReleaseRequest {

    /**
     * 发布标题
     *
     * <p>用于标识本次发布的简短描述，便于在发布历史中识别</p>
     */
    private String releaseTitle;

    /**
     * 发布人员标识
     *
     * <p>记录是谁执行了本次发布操作</p>
     */
    private String releasedBy;

    /**
     * 发布说明
     *
     * <p>详细描述本次发布的内容和原因</p>
     */
    private String releaseComment;

    /**
     * 构造函数，创建发布请求
     *
     * @param releaseTitle 发布标题，不能为空
     * @param releasedBy 发布人员标识，不能为空
     * @param releaseComment 发布说明
     */
    public ReleaseRequest(String releaseTitle, String releasedBy, String releaseComment) {
        this.releaseTitle = releaseTitle;
        this.releasedBy = releasedBy;
        this.releaseComment = releaseComment;
    }

    /**
     * 无参构造函数，用于 JSON 反序列化
     */
    public ReleaseRequest() {
    }
}