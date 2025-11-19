package com.bluesky.apollo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Apollo 发布配置项请求模型
 *
 * <p>该类用于封装向 Apollo Portal API 发送的配置项创建/更新请求，
 * 对应 Apollo Portal OpenAPI 的 item 接口请求格式。</p>
 *
 * <p>Apollo 的 item 接口具有幂等性：</p>
 * <ul>
 *   <li>如果配置项不存在，则创建新的配置项</li>
 *   <li>如果配置项已存在，则更新现有配置项</li>
 * </ul>
 *
 * @author lantian
 * @date 2025/11/17
 * @version 1.0
 */
@Data
public class PublishItemRequest {

    /**
     * 配置项的键
     */
    private String key;

    /**
     * 配置项的值
     */
    private String value;

    /**
     * 配置项的注释说明
     */
    private String comment;

    /**
     * 操作人员标识
     *
     * <p>对应 Apollo API 中的 dataChangeCreatedBy 字段，
     * 用于记录是谁创建或修改了这个配置项</p>
     */
    @JsonProperty("dataChangeCreatedBy")
    private String dataChangeCreatedBy;

    /**
     * 构造函数，创建发布配置项请求
     *
     * @param key 配置项的键，不能为空
     * @param value 配置项的值
     * @param comment 配置项的注释说明
     * @param dataChangeCreatedBy 操作人员标识，不能为空
     */
    public PublishItemRequest(String key, String value, String comment, String dataChangeCreatedBy) {
        this.key = key;
        this.value = value;
        this.comment = comment;
        this.dataChangeCreatedBy = dataChangeCreatedBy;
    }

    /**
     * 无参构造函数，用于 JSON 反序列化
     */
    public PublishItemRequest() {
    }
}