package com.commons.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class XLSXReader extends AbstractExcelFileReader {//todo

    public Sheet getSheet(final String filePath) {
        Sheet sheet = null;

        try (final FileInputStream fileInputStream = new FileInputStream(filePath);
             final Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            sheet = workbook.getSheetAt(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sheet;
    }

    public String[] readHeadings(final String filePath) {

        final Sheet sheet = getSheet(filePath);
        final int colCount = sheet.getRow(0).getLastCellNum();
        final String[] heading = new String[colCount];

        for (int columnNumber = 0; columnNumber < colCount; columnNumber++) {
            final Cell cell = sheet.getRow(0).getCell(columnNumber);
            heading[columnNumber] = cell.getStringCellValue();
        }

        return heading;
    }

    public String[] readSpecificRow(final String filePath, final int rowNumber) {
        final Sheet sheet = getSheet(filePath);
        final int colCount = sheet.getRow(0).getLastCellNum();
        final String[] heading = new String[colCount];

        for (int columnNumber = 0; columnNumber < colCount; columnNumber++) {
            final Cell cell = sheet.getRow(rowNumber).getCell(columnNumber);
            heading[columnNumber] = cell.getStringCellValue();
        }

        return heading;
    }

    public void readAll(final String path, final WorkSheet workSheet) {
        final Sheet sheet = getSheet(path);
        final int rowNumber = sheet.getPhysicalNumberOfRows();
        final int columnNumber = sheet.getRow(0).getLastCellNum();

        for (int i = 1; i < rowNumber; i++) {
            final Row row = sheet.getRow(i);

            for (int j = 0; j < columnNumber; j++) {
                final Cell cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
        }
    }

    @Override
    public void read(String path, WorkSheet workSheet) {

    }

    @Override
    public void writeToExistingFile(final String path, final WorkSheet workSheet) {

    }

    @Override
    public void writeToNewFile(final String path, final WorkSheet workSheet) {

    }
}




