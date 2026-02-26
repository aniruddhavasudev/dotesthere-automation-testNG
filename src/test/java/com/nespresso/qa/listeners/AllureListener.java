package com.nespresso.qa.listeners;

import com.microsoft.playwright.Page;
import com.nespresso.qa.base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Page page = BaseTest.getCurrentPage();
        if (page != null) {
            byte[] screenshot = page.screenshot();
            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }
    }
}