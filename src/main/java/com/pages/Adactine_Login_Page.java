package com.pages;

import com.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class Adactine_Login_Page extends BasePage {

    /**
     *     Assertions should not be called in page layers
     *     All your page methods needs to have some return type
     */


    private final By txtboxUsername = By.id("username");
    private final By txtboxPassword = By.id("password");
    private final By btnLogin = By.id("login");


    public Adactine_Login_Page enterUsername(String userName) {
        sendKeys(txtboxUsername, userName, WaitStrategy.PRESENCE,"UserName");
        return this;
    }

    public Adactine_Login_Page enterPassword(String password) {
        sendKeys(txtboxPassword, password, WaitStrategy.PRESENCE, "Password");
        return this;
    }

    public Adactine_SearchHotel_Page clickLogin() {
        click(btnLogin, WaitStrategy.CLICKABLE, "Login button");
        return new Adactine_SearchHotel_Page();
    }
}
