package io.icednut.tolr.client;

import io.icednut.tolr.client.query.TolrQuery;
import io.icednut.tolr.client.response.QueryResponse;
import io.icednut.tolr.client.response.TolrDocument;

import java.util.ArrayList;
import java.util.List;

public class TolrClient {

    public QueryResponse query(TolrQuery query) {
        System.out.println("query 객체를 바탕으로 tolr 서버와 통신 진행!");
        List<TolrDocument> results = new ArrayList<>();
        return new QueryResponse(results);
    }
}
