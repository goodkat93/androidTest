package com.company.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainPageApp {
    AndroidDriver<AndroidElement> driver;

    By declineButton = By.id("com.mobium8918.app:id/decline_button");
    By russiaRegion = By.xpath("//android.widget.TextView[@text='Россия']");
    By dogsButton = By.xpath("//android.widget.TextView[@text='Для собак']");
    By bowlsButton = By.xpath("//android.widget.TextView[@text='Миски']");
    By doubleBowl = By.xpath("//android.widget.TextView[@text='Двойные']");
    By inShoppingBag = By.xpath("//android.widget.TextView[@bounds='[694,1630][1035,1756]']");
    By addOneMore = By.id("com.mobium8918.app:id/stepper_plus_button");
    By shouldPurchases = By.id("com.mobium8918.app:id/stepper_number_button");
    By shoppingBag = By.id("com.mobium8918.app:id/action_cart");
    By reallyPurchases = By.id("com.mobium8918.app:id/stepper_number_button");


    int itemsCountShouldExist;
    int itemsCountReallyExist;

    public MainPageApp() {
    }

    public int getItemsCountShouldExist() {
        return itemsCountShouldExist;
    }

    public int getItemsCountReallyExist() {
        return itemsCountReallyExist;
    }

    public MainPageApp(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public MainPageApp openApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MyPhone");
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\Appium automation\\APK\\betxoven.apk");
        capabilities.setCapability("chromedriverExecutable", "C:\\node_modules\\appium-with-crosswalk-fix\\chromedriver\\2.28\\chromedriver.exe");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (
                MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        return new MainPageApp(driver);
    }

    public MainPageApp skipInit() {
        driver.findElement(declineButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(declineButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementById("com.mobium8918.app:id/decline_button").click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementById("com.mobium8918.app:id/decline_button").click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new MainPageApp(driver);
    }

    public MainPageApp choseRegion() {
        driver.findElement(russiaRegion).click();
//        driver.findElementByXPath
//                ("//android.widget.TextView[@text='Россия']").click();
        return new MainPageApp(driver);
    }

    public MainPageApp selectPet() {
        driver.findElement(dogsButton).click();
        return new MainPageApp(driver);
    }

    public MainPageApp selectAccessories() {
        driver.findElement(bowlsButton).click();
        return new MainPageApp(driver);
    }

    public MainPageApp selectDoubleBowl() {
        driver.findElement(doubleBowl).click();
        return new MainPageApp(driver);
    }

    public MainPageApp addToShoppingBag() {
        driver.findElement(inShoppingBag).click();
        return new MainPageApp(driver);
    }

    public MainPageApp addTwoMoreBowls() {
        MobileElement plusButton = driver.findElement(addOneMore);
        plusButton.click();
        plusButton.click();
        return new MainPageApp(driver);
    }

    public MainPageApp findItemsCountShouldExist() {
        int itemsCountShouldExist = Integer.parseInt
                (driver.findElement(shouldPurchases).getText());
        System.out.println("amount purchases which we added " + itemsCountShouldExist); // can be removed
        return this;
    }

    public MainPageApp moveToShoppingBag() {
        driver.findElement(shoppingBag).click();
        return this;
    }

    public MainPageApp findItemsCountReallyExist() {
        int itemsCountReallyExist = Integer.parseInt
                (driver.findElement(reallyPurchases).getText());
        System.out.println("amount purchases in shopping bag: " + itemsCountReallyExist); // can be removed
        return this;
    }

}
