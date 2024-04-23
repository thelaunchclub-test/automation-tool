package com.commons.excel;

import com.commons.util.DirectoryInfo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class ExcelFileReaderImpl {//todo

    public static Object[][] read(final String fileName, final String sheetName) {
        Object[][] testData = null;
        final String filePath = DirectoryInfo.getFileDirectory() + File.separator + fileName;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             final Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            final Sheet sheet = workbook.getSheet(sheetName);
            final int rowCount = sheet.getPhysicalNumberOfRows();
            final int columnCount = sheet.getRow(0).getLastCellNum();
            testData = new Object[rowCount][columnCount];

            for (int rowNumber = 0; rowNumber < rowCount; rowNumber++) {
                final Row row = sheet.getRow(rowNumber);

                for (int columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                    Cell cell = row.getCell(columnNumber);
                    testData[rowNumber][columnNumber] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }

        return testData;
    }

    public static void write(final String fileName, final String sheetName, final Object[][] data) {
        try (Workbook workbook = new XSSFWorkbook()) {
            final Sheet sheet = workbook.createSheet(sheetName);

            for (int rowNumber = 0; rowNumber < data.length; rowNumber++) {
                final Row row = sheet.createRow(rowNumber);

                for (int columnNumber = 0; columnNumber < data[rowNumber].length; columnNumber++) {
                    final Cell cell = row.createCell(columnNumber);

                    cell.setCellValue(String.valueOf(data[rowNumber][columnNumber]));
                }
            }

            final String filePath = DirectoryInfo.getFileDirectory() + File.separator + fileName;
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }

        } catch (IOException e) {
            System.err.println("Error writing to Excel file: " + e.getMessage());
        }
    }
}