package com.nespresso.qa.pages;
import com.microsoft.playwright.Page;
import com.nespresso.qa.base.BasePage;

public class AddRemoveElementsPage extends BasePage {

    public AddRemoveElementsPage(Page page) {
        super(page);
    }

    // Click Add button (top button)
    public void clickAddElement() {
        page.locator("button:has-text('Add')").click();
    }

    // Count delete buttons inside container
    public int getDeleteButtonCount() {
        return page.locator("#elements-container > button").count();
    }

    // Click first delete button
    public void clickFirstDeleteButton() {
        page.locator("#elements-container > button").first().click();

        // Wait until no buttons exist
        page.waitForCondition(() ->
                page.locator("#elements-container > button").count() == 0
        );
    }
}