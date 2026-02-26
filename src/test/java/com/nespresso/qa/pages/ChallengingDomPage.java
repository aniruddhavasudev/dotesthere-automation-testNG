package com.nespresso.qa.pages;

import com.microsoft.playwright.Page;
import com.nespresso.qa.base.BasePage;

public class ChallengingDomPage extends BasePage {

    public ChallengingDomPage(Page page) {
        super(page);
    }

    // Click top blue buttons
    public void clickTopButton(int index) {
        page.locator("a.button").nth(index).click();
    }

    // Click first delete in table
    public void clickFirstDelete() {
        page.locator("#challenging-tbody .btn-delete")
                .first()
                .click();
    }

    // Click delete by row index (0-based)
    public void clickDeleteByRow(int rowIndex) {
        page.locator("#challenging-tbody .btn-delete")
                .nth(rowIndex)
                .click();
    }

    // Count delete buttons
    public int getDeleteButtonCount() {
        return page.locator("#challenging-tbody .btn-delete")
                .count();
    }

    public void clickFirstDeleteAndAcceptAlert() {

        page.onceDialog(dialog -> {
            System.out.println("Dialog message: " + dialog.message());
            dialog.accept();   // Press OK
        });

        page.locator("#challenging-tbody .btn-delete")
                .first()
                .click();
    }

    public void clickFirstDeleteAndCancelAlert() {

        page.onceDialog(dialog -> {
            System.out.println("Dialog message: " + dialog.message());
            dialog.dismiss();   // Press OK
        });

        page.locator("#challenging-tbody .btn-delete")
                .first()
                .click();
    }
}