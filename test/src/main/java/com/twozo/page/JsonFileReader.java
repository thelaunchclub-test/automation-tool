package com.twozo.page;

import com.twozo.commons.json.Json;
import com.twozo.commons.json.JsonArray;
import com.twozo.commons.json.JsonObject;
import com.twozo.commons.util.EnvUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class JsonFileReader {
    static class TestCase {
        public String testCaseID;
        public Map<String, String> input;
        public Map<String, String> expectedOutput;
    }

//    public Collection<TestCase> getTestCases(final String fileName) {
//        final JsonArray array = Json.array(new File(EnvUtility.getConfDirectory(), fileName));
//        final Collection<TestCase> testCases = new ArrayList<>();
//
//        for (int i = 0; i < array.size(); i++) {
//            JsonObject jsonObject = array.getJsonObject(i);
//            TestCase testCase = new TestCase();
//
//            testCase.setId(jsonObject.getString("testCaseID"));
//            testCase.setInput(jsonObject.getJsonObject("input").toMap());
//
//            testCases.add(testCase);
//        }
//
//        return testCases;
//    }
}
