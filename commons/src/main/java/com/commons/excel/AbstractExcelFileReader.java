package com.commons.excel;

public abstract class AbstractExcelFileReader implements ExcelFileReader {//todo

    public WorkSheet read(final String path) {
        final WorkSheet workSheet = new WorkSheet();

        read(path, workSheet);

        return workSheet;
    }

    public abstract void read(final String path, final WorkSheet workSheet);

    public abstract void writeToExistingFile(final String path, final WorkSheet workSheet);

    public abstract void writeToNewFile(final String path, final WorkSheet workSheet);

}
