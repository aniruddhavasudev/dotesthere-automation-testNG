package com.nespresso.qa.utils;

import com.microsoft.playwright.Page;
import com.nespresso.qa.base.BaseTest;
import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    public static String captureScreenshot(String testName) {
        Page currentPage = BaseTest.getCurrentPage();
        if (currentPage == null) {
            return "";
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String dir = "test-output/screenshots";
        new File(dir).mkdirs();
        String path = dir + "/" + testName + "_" + timestamp + ".png";
        try {
            currentPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
            return path;
        } catch (Exception e) {
            return "";
        }
    }
}