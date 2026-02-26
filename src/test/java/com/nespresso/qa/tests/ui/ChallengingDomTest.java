package com.nespresso.qa.tests.ui;

import com.nespresso.qa.base.BaseTest;
import com.nespresso.qa.pages.ChallengingDomPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengingDomTest extends BaseTest {

    @Test
    public void testDeleteWithConfirmation() {

        ChallengingDomPage pageObj = new ChallengingDomPage(page);
        pageObj.navigateToHome();

        int initialCount = pageObj.getDeleteButtonCount();

        pageObj.clickFirstDeleteAndCancelAlert();

        Assert.assertEquals(
                pageObj.getDeleteButtonCount(),
                2
        );
    }

    @Test
    public void testDeleteFirstRow() {
        ChallengingDomPage pageObj = new ChallengingDomPage(page);
        pageObj.navigateToHome();

        int initialCount = pageObj.getDeleteButtonCount();

        pageObj.clickFirstDelete();
        pageObj.clickFirstDeleteAndAcceptAlert();

        Assert.assertEquals(
                pageObj.getDeleteButtonCount(),
                initialCount - 1
        );
    }
}