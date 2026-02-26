package com.nespresso.qa.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.nespresso.qa.config.Config;

public abstract class BasePage {
    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    public void navigateToHome() {
        page.navigate(Config.BASE_UI_URL);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
}