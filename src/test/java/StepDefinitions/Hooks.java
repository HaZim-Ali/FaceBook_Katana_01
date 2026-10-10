package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class Hooks {
    public static AndroidDriver HZM;

    @Before
    public void setup() throws MalformedURLException {
        // Initialize driver first
        HZM = DriverFactory.getDriver();

        // Activate app by package name
        HZM.activateApp("com.facebook.katana");

        System.out.println("✅ App launched successfully on device. Session ID: " + HZM.getSessionId());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            // Wait a bit before closing —  5 seconds
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        if (scenario.isFailed()) {
            System.out.println("❌ Scenario failed. Keeping app open for inspection.");
        } else {
            DriverFactory.quitDriver();
            System.out.println("✅ Scenario passed. App closed after delay.");
        }
    }
}
