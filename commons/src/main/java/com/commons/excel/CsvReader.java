package com.commons.excel;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader extends AbstractExcelFileReader {//todo

    public List<String[]> readSpecificRow(final String filePath) {
        final List<String[]> rowData = new ArrayList<>();

        try {
            final File file = new File("");
            final FileReader fileReader = new FileReader(file);
            final CSVReader csvReader = new CSVReader(fileReader);

            return rowData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String readSpecificValue(final String filePath, final int rowNumber, final int columnNumber) {
        String value = null;
        try (final BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentRow = 1;
            while ((line = br.readLine()) != null) {
                if (currentRow == rowNumber) {
                    String[] values = line.split(",");
                    if (columnNumber <= values.length) {
                        value = values[columnNumber - 1].trim();
                        break;
                    }
                }
                currentRow++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public void read(final String path, final WorkSheet workSheet) {
        workSheet.setHeader(readHeadings(path));
        workSheet.setSpecificValue(readSpecificValue(path, 1, 2));
        workSheet.setTotalRecords(readSpecificRow(path, 2));
    }

    @Override
    public void writeToExistingFile(final String path, final WorkSheet workSheet) {

    }

    @Override
    public void writeToNewFile(final String path, final WorkSheet workSheet) {

    }
}

