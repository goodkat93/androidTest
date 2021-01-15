package com.company;

import java.util.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MyPhone");
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\Appium automation\\APK\\betxoven.apk");
        capabilities.setCapability("chromedriverExecutable", "C:\\node_modules\\appium-with-crosswalk-fix\\chromedriver\\2.28\\chromedriver.exe");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        driver.findElementById("com.mobium8918.app:id/decline_button").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.mobium8918.app:id/decline_button").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        MobileElement el1 = (MobileElement) driver.findElementById("com.mobium8918.app:id/regionTextView");
//        el1.click();
//        el1.sendKeys("Россия");
//        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView");
//        el2.click();

        driver.findElementByXPath
                ("//android.widget.TextView[@text='Россия']").click();
        driver.findElementByXPath
                ("//android.widget.TextView[@text='Для собак']").click();

        driver.findElementByXPath
                ("//android.widget.TextView[@text='Миски']").click();

        driver.findElementByXPath
                ("//android.widget.TextView[@text='Двойные']").click();

        driver.findElementByXPath
                ("//android.widget.TextView[@bounds='[694,1630][1035,1756]']").click();
        MobileElement plusButton = driver.findElementById("com.mobium8918.app:id/stepper_plus_button");
        plusButton.click();
        plusButton.click();
        String itemsCountShouldExist = driver.findElementById
                ("com.mobium8918.app:id/stepper_number_button").getText();
        Integer.parseInt(itemsCountShouldExist);
        System.out.println(itemsCountShouldExist);

        driver.findElementById
                ("com.mobium8918.app:id/action_cart").click();

        String itemsCountReallyExist = driver.findElementById
                ("com.mobium8918.app:id/stepper_number_button").getText();
        Integer.parseInt(itemsCountReallyExist);
        System.out.println(itemsCountReallyExist);

        Assert.assertEquals(itemsCountReallyExist, itemsCountShouldExist);


//        MobileElement el3 = driver.findElementByXPath
//                ("//android.widget.TextView[@text='Для собак']");
//        el3.click();
//
//
//
//        driver.context((String) contextNames.toArray()[contextNames.toArray().length - 1]);
//
//        Thread.sleep(8000);
//        driver.findElementByCssSelector(".search-input").sendKeys("Кино");
//        driver.findElementByCssSelector(".search-button").click();
    }
}