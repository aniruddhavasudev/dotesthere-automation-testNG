package com.nespresso.qa.tests.ui;

import com.nespresso.qa.base.BaseTest;
import com.nespresso.qa.pages.AddRemoveElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void testAddElement() {

        AddRemoveElementsPage addRemove = new AddRemoveElementsPage(page);
        addRemove.navigateToHome();

        Assert.assertEquals(addRemove.getDeleteButtonCount(), 0,
                "Initial delete buttons should be 0");

        addRemove.clickAddElement();

        Assert.assertEquals(addRemove.getDeleteButtonCount(), 1,
                "One delete button should appear");
    }

    @Test
    public void testRemoveElement() {

        AddRemoveElementsPage addRemove = new AddRemoveElementsPage(page);
        addRemove.navigateToHome();

        // Pre-condition: Add element first
        addRemove.clickAddElement();
        Assert.assertEquals(addRemove.getDeleteButtonCount(), 1,
                "Delete button should exist before removal");

        addRemove.clickFirstDeleteButton();

        Assert.assertEquals(addRemove.getDeleteButtonCount(), 0,
                "Delete button should be removed");
    }
}