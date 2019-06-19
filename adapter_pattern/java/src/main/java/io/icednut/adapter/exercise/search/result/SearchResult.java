package io.icednut.adapter.exercise.search.result;

import java.util.List;

public class SearchResult {
    private List<SearchDocument> results;

    public SearchResult(List<SearchDocument> results) {
        this.results = results;
    }
}
