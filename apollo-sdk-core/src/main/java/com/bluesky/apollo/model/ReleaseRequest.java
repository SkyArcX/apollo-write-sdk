package com.bluesky.apollo.model;

import lombok.Data;

@Data
public class ReleaseRequest {
    private String releaseTitle;
    private String releasedBy;
    private String releaseComment;
}
