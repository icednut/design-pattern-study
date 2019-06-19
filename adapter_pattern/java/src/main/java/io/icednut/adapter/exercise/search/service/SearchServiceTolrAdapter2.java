package io.icednut.adapter.exercise.search.service;

import io.icednut.adapter.exercise.search.result.SearchDocument;
import io.icednut.adapter.exercise.search.result.SearchResult;
import io.icednut.tolr.client.TolrClient;
import io.icednut.tolr.client.query.TolrQuery;
import io.icednut.tolr.client.response.QueryResponse;
import io.icednut.tolr.client.response.TolrDocument;

import java.util.List;
import java.util.stream.Collectors;

public class SearchServiceTolrAdapter2 extends TolrClient implements SearchService {

    @Override
    public SearchResult search(String keyword) {
        TolrQuery tolrQuery = new TolrQuery("QUERY " + keyword);
        QueryResponse response = super.query(tolrQuery);

        return convertToResult(response);
    }

    private SearchResult convertToResult(QueryResponse response) {
        List<TolrDocument> documentList = response.getDocumentList();
        List<SearchDocument> results = documentList.stream()
                .map(tolrDocument -> new SearchDocument(tolrDocument.getId(), tolrDocument.getContent()))
                .collect(Collectors.toList());

        return new SearchResult(results);
    }
}
