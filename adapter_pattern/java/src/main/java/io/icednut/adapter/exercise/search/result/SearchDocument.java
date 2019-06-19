package io.icednut.adapter.exercise.search.result;

public class SearchDocument {
    private final Long id;
    private final String content;

    public SearchDocument(Long id, String content) {
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
