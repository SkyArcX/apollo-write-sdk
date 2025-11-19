package com.bluesky.apollo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 发布配置项请求，对应Apollo OpenAPI的 item 请求
 *
 * @author lantian
 * @date 2025/11/17
 */
public class PulishItemRequest {

    private String key;
    private String valute;
    private String comment;

    @JsonProperty("dataChangeCreatedBy")
    private String dataChangeCreatedBy;

    public PulishItemRequest(String key, String valute, String comment, String dataChangeCreatedBy) {
        this.key = key;
        this.valute = valute;
        this.comment = comment;
        this.dataChangeCreatedBy = dataChangeCreatedBy;
    }
}
