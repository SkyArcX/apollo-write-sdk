package com.bluesky.apollo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemResponse {
    private String key;
    private String value;
    private String comment;

    @JsonProperty("dataChangeCreatedBy")
    private String dataChangeCreatedBy;
}
