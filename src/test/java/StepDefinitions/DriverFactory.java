package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setDeviceName("RMX2020");
            options.setUdid("PZJFIZLNWKMVJRRO");
            options.setAppPackage("com.facebook.katana");
            //com.android.chrome
            options.setAppActivity(".LoginActivity");
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            options.setCapability("appium:ignoreHiddenApiPolicyError", true);
            options.setNoReset(true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        try {
            if (driver != null) {
                String appPackage = "com.facebook.katana"; // your app package name

                System.out.println("🔹 Trying to terminate the app: " + appPackage);
                driver.terminateApp(appPackage);

                // Wait briefly before quitting
                Thread.sleep(5000);

                System.out.println("🔹 Quitting Appium driver session...");
                driver.quit();

                System.out.println("✅ App terminated and session closed successfully.");
            }
        } catch (Exception e) {
            System.err.println("❌ Error while terminating app: " + e.getMessage());
        } finally {
            driver = null;
        }
    }
}
