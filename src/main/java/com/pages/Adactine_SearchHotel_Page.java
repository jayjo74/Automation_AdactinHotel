package com.pages;

import com.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class Adactine_SearchHotel_Page extends BasePage{


    private final By btnSearch = By.id("Submit");
    private final By btnReset = By.id("Reset");
    private final By selLocation = By.id("location");
    private final By selHotels = By.id("hotels");
    private final By selRoomType = By.id("room_type");
    private final By selNumberOfRooms = By.id("room_nos");
    private final By txtCheckInDate = By.id("datepick_in");
    private final By txtCheckOutDate = By.id("datepick_out");
    private final By btnLogout = By.linkText("Logout");


    public Adactine_SearchHotel_Page selectLocation(String location) {
        selectByText(selLocation, location, WaitStrategy.PRESENCE, "Location");
        return this;
    }

    public Adactine_SearchHotel_Page selectHotels(String hotels) {
        selectByText(selHotels, hotels, WaitStrategy.PRESENCE, "Hotels");
        return this;
    }

    public Adactine_SearchHotel_Page selectNumberRooms(String numberRooms) {
        selectByText(selNumberOfRooms, numberRooms, WaitStrategy.PRESENCE, "Number of Rooms");
        return this;
    }

    public Adactine_SearchHotel_Page enterCheckInDate(String checkindate) {
        sendKeys(txtCheckInDate, checkindate, WaitStrategy.PRESENCE,"Check In Date");
        return this;
    }

    public Adactine_SearchHotel_Page enterCheckOutDate(String checkoutdate) {
        sendKeys(txtCheckOutDate, checkoutdate, WaitStrategy.PRESENCE,"Check Out Date");
        return this;
    }

    public Adactine_SearchHotel_Page clickReset() {
        click(btnReset, WaitStrategy.CLICKABLE, "Reset Button");
        return this;
    }

    public Adactine_LoginAgain_Page clickLogout() {
        click(btnLogout, WaitStrategy.CLICKABLE, "Logout Button");
        return new Adactine_LoginAgain_Page();
    }
}
