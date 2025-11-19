package com.bluesky.apollo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Apollo 配置项响应模型
 *
 * <p>该类用于封装从 Apollo Portal API 获取的配置项信息，
 * 包含配置项的键值对、注释以及创建者等元数据。</p>
 *
 * <p>对应 Apollo Portal OpenAPI 的 item 响应格式。</p>
 *
 * @author lantian
 * @date 2025/11/17
 * @version 1.0
 */
@Data
public class ItemResponse {

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
     * 配置项的创建者
     *
     * <p>对应 Apollo API 中的 dataChangeCreatedBy 字段</p>
     */
    @JsonProperty("dataChangeCreatedBy")
    private String dataChangeCreatedBy;
}