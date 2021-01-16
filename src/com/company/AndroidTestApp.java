package com.company;

import com.company.pages.MainPageApp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class AndroidTestApp {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void testApp() {
        new MainPageApp(driver)
                .openApp()
                .skipInit()
                .choseRegion()
                .selectPet()
                .selectAccessories()
                .selectDoubleBowl()
                .addToShoppingBag()
                .addTwoMoreBowls()
                .findItemsCountShouldExist()
                .moveToShoppingBag()
                .findItemsCountReallyExist();
        MainPageApp items = new MainPageApp();
        Assert.assertEquals(items.getItemsCountReallyExist(), items.getItemsCountShouldExist());
    }
}