package io.icednut.adapter.exercise.search.service;

import io.icednut.adapter.exercise.search.result.SearchDocument;
import io.icednut.adapter.exercise.search.result.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class DBSearchService implements SearchService {

    @Override
    public SearchResult search(String keyword) {
        List<SearchDocument> results = findByKeyword(keyword);

        return new SearchResult(results);
    }

    private List<SearchDocument> findByKeyword(String keyword) {
        List<SearchDocument> result = new ArrayList<>();

        // TODO: DB에서 result 조회 로직 구현
        return result;
    }
}
