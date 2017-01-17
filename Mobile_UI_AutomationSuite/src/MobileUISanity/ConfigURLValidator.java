package MobileUISanity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by ideas on 12/19/16.
 */
public class ConfigURLValidator {

    public  IOSLogin ConfigURLValidator(){

        return null;
    }

    public boolean configureURL(AppiumDriver<MobileElement> driver) {

//2) Click on Keyboards 'Done' button.

        Operators operators =  new Operators(driver);
        if (operators.sendKeys_text("Enter URL","perffair1649-09/connecttostage", "value")) {
            String sou = driver.getPageSource();
            operators.click("Done");
            return true;
        }
        else
            return false;


    }
}
