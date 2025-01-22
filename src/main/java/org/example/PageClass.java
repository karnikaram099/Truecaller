package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.Duration;

public class PageClass {

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    WebElement btn_Notifications;

    @FindBy(id = "com.truecaller:id/nextButton")
    WebElement btn_setStarted;

    @FindBy(id = "android:id/button1")
    WebElement btn_setDefault;

    @FindBy(id = "com.truecaller:id/countrySpinner")
    WebElement sp_country;

    @FindBy(id = "com.truecaller:id/searchEditText")
    WebElement txt_country;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    WebElement option_india;

    @FindBy(id = "com.truecaller:id/numberField")
    WebElement txt_number;

    @FindBy(id = "com.truecaller:id/nextButton")
    WebElement btn_confirm;

    //  Complete Profile
    @FindBy(id = "com.truecaller:id/manualInputButton")
    WebElement btn_profile;

    @FindBy(id = "com.truecaller:id/firstName")
    WebElement txt_fName;

    @FindBy(id = "com.truecaller:id/lastName")
    WebElement txt_lName;

    @FindBy(id = "com.truecaller:id/email")
    WebElement txt_email;

    private AppiumDriver driver;

    public PageClass(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void allowNotification() {
        btn_Notifications.click();
    }

    public void allowAllPermissions() {
        allowNotification();
        clickOnAllowAccessForContacts();
        clickOnAllowManagePhoneCalls();
        clickOnAllowSmsMessages();
    }

    public void clickOnAllowPhoneLogs() {
        allowNotification();
    }

    public void clickOnAllowAccessForContacts() {
        btn_Notifications.click();
    }

    public void clickOnAllowManagePhoneCalls() {
        btn_Notifications.click();
    }

    public void getStarted() {
        btn_setStarted.click();
    }

    public void clickOnAllowSmsMessages() {
        btn_setStarted.click();
    }

    public void login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        sp_country.click();
        txt_country.sendKeys("india");
        option_india.click();
        txt_number.sendKeys("6281308839");
        btn_confirm.click();
        // Confirm entered number in pop-up
        btn_setDefault.click();

        // Confirmation from Privacy pop-up
        btn_confirm.click();
    }

    public void completeProfile() throws InterruptedException {
        Thread.sleep(3000);
        btn_profile.click();
        // Fill profile form
        txt_fName.sendKeys("ram");
        txt_lName.sendKeys("karnika");
        txt_email.sendKeys("ramKarnika123@gmail.com");
        btn_confirm.click();
    }
}
