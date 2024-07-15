package com.twozo.commons.util;

import com.twozo.commons.json.Json;
import com.twozo.commons.json.JsonArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class JsonFileReader {
    static class TestCase {
        public String testCaseID;
        public Map<String, String> input;
        public Map<String, String> expectedOutput;
    }

    public Object[][] getTestCases(final String fileName) {
        final JsonArray array = Json.array(new File(EnvUtility.getConfDirectory(), fileName));
        final Object[][] data = new Object[array.size()][1];

        for (int i = 0; i < array.size(); i++) {
            data[i][0] = array.getJsonObject(i);
        }
        return data;
    }

    public Map<String, String> myFunction(final Map<String, String> inputData) {

        if ("value1".equals(inputData.get("field1"))) {
            return Map.of("result", "success");
        } else {
            return Map.of("result", "failure");
        }
    }
}
