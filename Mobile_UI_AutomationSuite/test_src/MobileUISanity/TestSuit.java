package MobileUISanity;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by ideas on 12/14/16.
 */
public class TestSuit {

    AppiumDriver<MobileElement> driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    String appPath = "/Users/ideas/Documents/ipassss/IDeaSMobileRMS/IDeaSMobileRMS.ipa";
    String iPhone6sUUID = "e1ad9741b28e29df0cb9c92b5107cfd99d7148d0";
    String iPhone5cUUID = "47e7f41fa29cb3b6e215d1f3113d5f9da25746f4";
    String IPadUUID = "c88e048c01fb4d840a641e03d7062c2335de384e";
    WebDriverWait wait;

 /*   private void initializeAppiumServer() throws IOException, InterruptedException {



        String Appium_Node_Path=
                "/usr/local/bin/appium";
//                "/usr/local/Cellar/node/7.0.0/bin/node";
        String Appium_JS_Path="/usr/local/lib/node_modules/appium/build/lib/appium.js";
        AppiumDriverLocalService appiumService;

        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));
        appiumService.start();





//        String startAppiumServer = new String("/Users/ideas/IdeaProjects/MobileAndriodAppAppium/scripts/initializeAppiumServer.sh");
//        Runtime runtime = Runtime.getRuntime();
//        String command =  startAppiumServer;
//        Process process = runtime.exec("/usr/local/bin/appium");
////        process.waitFor();
//        StringBuffer output = new StringBuffer();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line = "";
//        while ((line = reader.readLine())!= null){
//            output.append(line + "\n");
//
//        }
        System.out.println("aa");






//        Runtime.getRuntime().exec("appium &");
//        ProcessBuilder pb = new ProcessBuilder();
//        pb.directory(new File("/Users/ideas/IdeaProjects/MobileAndriodAppAppium/scripts/initializeAppiumServer.sh"));
//        Process process = pb.start();
//        System.out.println(p.getInputStream());
//        BufferedReader reader =
//                new BufferedReader(new InputStreamReader(process.getInputStream()));
//        StringBuilder builder = new StringBuilder();
//        String line = null;
//        while ( (line = reader.readLine()) != null) {
//            builder.append(line);
//            builder.append(System.getProperty("line.separator"));
//        }
//        String result = builder.toString();
//        System.out.println(result);
    }
      */
    @BeforeClass
    public void Initialization() throws Exception {

       // initializeAppiumServer();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(MobileCapabilityType.HAS_NATIVE_EVENTS, "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID, iPhone6sUUID);

        this.driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), this.capabilities);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void configURLValidation() {

        ConfigURLValidator configURLValidator = new ConfigURLValidator();
        Assert.assertTrue(configURLValidator.configureURL(this.driver));


        String userName = "Mobile12", password = "Mobile@12";
        IOSLogin iosLogin = new IOSLogin();
        iosLogin.login(userName, password);
//        Operators operators = new Operators(this.driver);
//        operators.click("cc");


    }

    @AfterClass
    public void exit() {

        //   this.driver.removeApp("IDeaSMobileRMS");
        this.driver.quit();
    }


}
