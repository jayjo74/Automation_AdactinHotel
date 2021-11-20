package com.tests;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.pages.Adactine_Login_Page;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class Adactin_Test01 extends BaseTest{

    private Adactin_Test01(){}

    @FrameworkAnnotation(author = {"Jay", "ILJE"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void Adactin_Login(Map<String, String> data){

        Adactine_Login_Page al = new Adactine_Login_Page();
        String title = al.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .clickLogout()
                .getTitle();

        //TestNG assertion
        Assert.assertEquals("Adactin.com - Logout", title);

        //AssertionJ style
        Assertions.assertThat(title)
                .isEqualTo("Adactin.com - Logout");
    }

    @FrameworkAnnotation(author = {"Jay", "ILJE"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void Adactin_SearchHotel(Map<String, String> data){
        Adactine_Login_Page al = new Adactine_Login_Page();
        al.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .selectLocation(data.get("location"))
                .selectHotels(data.get("hotel"))
                .selectNumberRooms(data.get("numberrooms"))
                .enterCheckInDate(data.get("checkindate"))
                .enterCheckOutDate(data.get("checkoutdate"))
                .clickReset()
                .clickLogout();
    }

    /*
    * Provide test data directly
    * */
//    @DataProvider(name="LoginTestDataProvider", parallel = true)
//    public Object[][] getData(){
//
//        return new Object[][]{
//                {"seattletester", "43XK1V"},
////                {"seattletester1", "43XK1V"}
//        };
//    }


}
