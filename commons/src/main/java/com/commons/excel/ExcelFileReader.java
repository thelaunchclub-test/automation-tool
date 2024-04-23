package com.commons.excel;


public interface ExcelFileReader {//todo

    static ExcelFileReader getInstance(final Extension extension) {
        return switch (extension) {
            case CSV -> new CsvReader();
            case XLSX -> new XLSXReader();
        };
    }

    WorkSheet read(final String path);

    void writeToExistingFile(final String path, final WorkSheet workSheet);

    void writeToNewFile(final String path, final WorkSheet workSheet);

}

