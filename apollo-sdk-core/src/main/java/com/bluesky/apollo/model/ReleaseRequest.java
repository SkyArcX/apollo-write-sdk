package com.bluesky.apollo.model;

/**
 * 发布请求
 * @author lantian
 */
public class ReleaseRequest {
    private String releaseTitle;
    private String releasedBy;
    private String releaseComment;

    public ReleaseRequest(String releaseTitle, String releasedBy, String releaseComment) {
        this.releaseTitle = releaseTitle;
        this.releasedBy = releasedBy;
        this.releaseComment = releaseComment;
    }
}
