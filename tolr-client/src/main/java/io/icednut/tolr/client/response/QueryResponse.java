package io.icednut.tolr.client.response;

import java.util.List;

public class QueryResponse {

    private List<TolrDocument> documentList;

    public QueryResponse(List<TolrDocument> documentList) {
        this.documentList = documentList;
    }

    public List<TolrDocument> getDocumentList() {
        return documentList;
    }
}
