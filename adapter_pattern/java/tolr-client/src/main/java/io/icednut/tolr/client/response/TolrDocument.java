package io.icednut.tolr.client.response;

public class TolrDocument {

    private Long id;
    private String content;

    public TolrDocument(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
