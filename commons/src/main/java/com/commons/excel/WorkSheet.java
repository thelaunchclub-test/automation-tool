package com.commons.excel;

import java.util.List;

public class WorkSheet {//todo

    private List<String> header;
    private List<String> totalRecords;
    private String specificValue;

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setTotalRecords(List<String> totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<String> getTotalRecords() {
        return totalRecords;
    }

    public void setSpecificValue(String value) {
        this.specificValue = value;
    }

    public String getSpecificValue() {
        return specificValue;
    }
}
