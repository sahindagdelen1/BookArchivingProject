package com.saho.model;

/**
 * Created by sahin.dagdelen on 2/25/2016.
 */
public class BookSearchForm {

    private String searchType;
    private String searchText;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }




    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }


    @Override
    public String toString() {
        return "text "+searchText+" searchType "+searchType ;
    }
}
