package org.example;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    PageClass pageClass;
    @Test
    public void testLaunchTrueCaller() throws InterruptedException {
        pageClass.clickOnAllowNotification();
        pageClass.clickGetStarted();
        pageClass.allowAllThePermissions();
        pageClass.login();
        pageClass.completeProfile();
    }
}
