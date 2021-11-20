package com.pages;

import com.driver.DriverManager;
import com.enums.WaitStrategy;
import com.factories.ExplicitWaitFactory;
import com.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected void click(By by, WaitStrategy waitstrategy, String elementname){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        try {
            ExtentLogger.pass(elementname + " is clicked.", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.clear();
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value + " is entered successfully in " + elementname, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void selectByIndex(By by, int indexNum, WaitStrategy waitstrategy, String elementname){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        Select select = new Select(element);
        select.selectByIndex(indexNum);
        try {
            ExtentLogger.pass("Index #" + indexNum+" is selected successfully in " + elementname, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void selectByText(By by, String value, WaitStrategy waitstrategy, String elementname){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
        try {
            ExtentLogger.pass(value + " is selected successfully in " + elementname, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
