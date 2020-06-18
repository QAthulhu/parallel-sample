package com.test;

import java.util.Map;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class BrowserStackTestNGTest {
    public AndroidDriver<MobileElement> driver;
    protected DesiredCapabilities capabilities;

    @BeforeMethod(alwaysRun=true)
    @org.testng.annotations.Parameters(value={"config"})
    public void setUp(String config_file) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        capabilities = new DesiredCapabilities();

        Log.info("Setting caps");
        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        Iterator it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }
        String app = new File(ClassLoader.getSystemClassLoader().getResource("login.apk").getFile()).getAbsolutePath();
        capabilities.setCapability(MobileCapabilityType.APP, app);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
    	Log.info("Ending session");
        driver.quit();
    }
}
