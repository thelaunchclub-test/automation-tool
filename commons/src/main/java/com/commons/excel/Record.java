package com.commons.excel;

public class Record {//todo

    private int recordNumber;
    private int columnIndex;
    private String value;

    public void setRecordNumber(final int recordNumber) {
        this.recordNumber = recordNumber;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setColumnIndex(final int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
