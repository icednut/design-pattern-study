package io.icednut.adapter.exercise.search.service;

import io.icednut.adapter.exercise.search.result.SearchResult;

public interface SearchService {

    SearchResult search(String keyword);
}
