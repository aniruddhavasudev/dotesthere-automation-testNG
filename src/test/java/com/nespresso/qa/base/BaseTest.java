package com.nespresso.qa.base;

import com.microsoft.playwright.*;
import lombok.Getter;
import org.testng.annotations.*;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @Getter
    private static Page currentPage;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(true));

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080)
        );

        page = context.newPage();
        currentPage = page;
    }

    @AfterClass
    public void teardown() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        currentPage = null;
    }
}