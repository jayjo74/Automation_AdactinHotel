package com.pages;

import org.openqa.selenium.By;

public final class Adactine_LoginAgain_Page extends BasePage {

    private final By linkLoginAgain = By.linkText("Click here to login again");

    public String getTitle(){
       return getPageTitle();
    }

}
