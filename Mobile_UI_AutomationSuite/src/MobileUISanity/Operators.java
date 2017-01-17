package MobileUISanity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by ideas on 12/19/16.
 */
public class Operators {
    /**
     * Invocation of local Driver element.
     */
    AppiumDriver<MobileElement> driver;

    /**
     * This identifier can be used to enter cell data only.
     */
    private final String XCUITypeElementType_Cell = "XCUIElementTypeCell";

    /**
     * This identifier can be used to send/fetch text field type data.
     */
    private final String XCUIElementType_TextField = "XCUIElementTypeTextField";//userName // label or value

    /**
     * This identifier can be used to send/fetch secure text field type data.
     */
    private final String XCUIElementType_SecureTextField = "XCUIElementTypeSecureTextField";// only for pwds

    /**
     * This identifier can be used to validate other type field.
     */
    private final String XCUIElementType_Other = "XCUIElementTypeOther";// application name or IDeaS

    /**
     * This identifier can be used to validate Static text field data.
     */
    private final String XCUIElementType_StaticText = "XCUIElementTypeStaticText";// name="Set as default"

    /**
     * This identifier can be used to send/fetch link type data.
     * e.g.  = Save
     */
    private final String XCUIElementType_Link = "XCUIElementTypeLink";

    /**
     * This identifier can be used to validate Button elements.
     * e.g. = Previous or Next
     */
    private final String XCUIElementType_Button = "XCUIElementTypeButton";


    /**
     * This identifier can be used to validate/fetch elements of type label.
     */
    private final String XCUIElementType_Label = "";

    public Operators(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


//    //1) Enter configure chain value.
//    MobileElement configURL = this.driver.findElement(By.xpath("//*[@value='Enter URL']"));
//        configURL.sendKeys("perffair1649-09/connecttostage");
//
//    //2) Click on Keyboards 'Done' button.
//    WebElement doneButton = this.driver.findElement(By.xpath("//*[@name='Done']"));
//        wait.until(ExpectedConditions.elementToBeClickable(doneButton));
//        doneButton.click();
//
//    //3) Click on 'Save' button.
//    WebElement saveButton = this.driver.findElement(By.xpath("//*[@name='Save']"));
//        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
//        saveButton.click();
//
//    //4) Validate 'Config URL' pop-up validation.
//    WebElement configLBL = this.driver.findElement(By.xpath("//*[@name='The entered URL is correct and working.']"));
//        wait.until(ExpectedConditions.elementToBeClickable(configLBL));
//        Assert.assertTrue(configLBL.isEnabled(), "Configuration is not valid");
//
//    //5) Click on 'OK' button.
//    WebElement okButton = this.driver.findElement(By.xpath("//*[@name='OK']"));
//        okButton.click();


//    MobileElement configURL = this.driver.findElement(By.xpath("//*[@value='Enter URL']"));
//        configURL.sendKeys("perffair1649-09/connecttostage");

    public boolean sendKeys_text(String elementID, String elementValue, String... labelType) {

        MobileElement element = this.driver.findElement(By.xpath(
                generateXCUITPathUsingName(XCUIElementType_TextField, elementID, labelType[0] == null ? "name" : labelType[0]
                )
        ));
        element.sendKeys(elementValue);
        return true;

    }

    public boolean click(String value, String... elementType) {

        MobileElement element = this.driver.findElement(By.xpath(generateXCUITPathUsingName(XCUIElementType_Button, value)));
        element.click();
        return true;

    }


    private String generateXCUITPathUsingName(String XpathType, String XpathValue, String... variableType) {

        //"[@name='" :
        return "//" + XpathType + (variableType.length != 0 ?  "[@" + variableType[0] + "='"  : "[@name='" ) + XpathValue + "']";

    }


}
