# FaceBook_Katana_01

Mobile UI automation project for the FaceBook_Katana_01 application. The project uses **Appium**, **Cucumber**, and **TestNG** to organize and run login and registration scenarios written in Gherkin. **Allure** is used to collect test results and create reports.

> Update the device, application, and tool version details below to match your local setup. They are not visible in the project screenshot.

## Technology

- Java
- Maven
- Appium
- Cucumber
- TestNG
- Allure Report
- Android SDK and ADB for Android execution

## Project structure

```text
FaceBook_Katana_01/
├── .allure/                         # Allure configuration or local data
├── .idea/                           # IntelliJ IDEA project settings
├── allure-report/                   # Generated Allure HTML report
├── src/
│   ├── main/
│   │   ├── java/                    # Application/support code, if used
│   │   └── resources/
│   │       └── Features/
│   │           ├── Login.feature
│   │           └── Registration.feature
│   └── test/
│       ├── java/
│       │   ├── Locators/
│       │   │   ├── Login_Locator.java
│       │   │   └── Registration_Locator.java
│       │   ├── StepDefinitions/
│       │   │   ├── DriverFactory.java
│       │   │   ├── Hooks.java
│       │   │   ├── Login_Steps.java
│       │   │   └── Registration_Steps.java
│       │   └── TestRunners/
│       │       └── runners.java
│       └── resources/
│           └── allure.properties
├── target/                           # Maven build output; generated
├── .gitignore
├── pom.xml
└── README.md
```

## Test organization

- **Feature files** describe user flows in Gherkin.
- **Step definitions** connect Gherkin steps to Java automation code.
- **Locators** hold the selectors used to find app elements.
- **DriverFactory** creates and configures the Appium driver.
- **Hooks** handle setup and cleanup around scenarios.
- **TestNG runner** runs the Cucumber features and integrates them with TestNG.
- **Allure** collects results for reporting.

## Prerequisites

Install and configure:

- A JDK compatible with the Java version in `pom.xml`
- Maven
- Node.js and npm
- Appium Server
- The Appium driver required by your target platform
- Android SDK and platform tools when running on Android
- An Android emulator or a USB-connected device with USB debugging enabled
- The application under test, if your capabilities use an installed app

Confirm Java, Maven, Node.js, and ADB are available:

```bash
java -version
mvn -version
node --version
npm --version
adb devices -l
```

For Android with UiAutomator2, check Appium's driver prerequisites:

```bash
appium driver doctor uiautomator2
```

## Configure the test device and application

Set the Appium capabilities in `DriverFactory.java` to match your environment. Common Android capabilities include:

- `platformName`: `Android`
- `appium:automationName`: `UiAutomator2`
- `appium:deviceName`: your emulator or device name
- `appium:udid`: device serial from `adb devices -l`
- `appium:app`: path to the APK, or use the installed app's package and launch activity
- `appium:appPackage` and `appium:appActivity`: needed when launching an already-installed app

Use the Appium server URL configured in your project. Do not commit passwords, private tokens, or other credentials to source control.

## Run the tests

Start the Appium server in a terminal:

```bash
appium
```

Confirm the emulator is running or the device is connected, then run the Maven test suite:

```bash
mvn clean test
```

You can also run the TestNG runner from IntelliJ IDEA if the project is configured to launch tests that way.

To run only selected Cucumber scenarios, use tags in the feature file (for example, `@smoke`) and configure the runner or Cucumber tag filter accordingly. The exact command depends on the runner and Maven Surefire configuration in `pom.xml`.

## Allure results and report

The Allure TestNG adapter writes test results to the configured results directory. The project includes `src/test/resources/allure.properties`; a common setting is:

```properties
allure.results.directory=target/allure-results
```

If the Allure Maven plugin is configured in `pom.xml`, generate a report with:

```bash
mvn allure:report
```

Serve the report locally with:

```bash
mvn allure:serve
```

The generated report is usually placed in `allure-report/`. Treat generated reports as build output and do not edit them manually.

## Troubleshooting

### Appium cannot find the device

Check that the emulator is running or the phone is connected and authorized:

```bash
adb devices -l
```

If the device appears as `unauthorized`, accept the USB debugging prompt on the phone. If it appears as `offline`, restart the emulator or reconnect the device.

### Session creation fails

1. Confirm Appium Server is running at the URL configured in `DriverFactory.java`.
2. Confirm the required Appium driver is installed:
   ```bash
   appium driver list --installed
   ```
3. Verify the capabilities and app package/activity against the target device.
4. Inspect the Appium server log and Android logcat for the first underlying error.

### Allure report is empty or missing results

1. Run the tests before generating the report.
2. Confirm at least one scenario executed successfully or failed.
3. Check that `allure-testng` is present in the Maven dependencies.
4. Confirm `allure.properties` is under `src/test/resources`.
5. Verify the configured Allure results directory contains result files.

## Notes

- The screenshot shows the source layout but not the Maven dependency versions, Android capabilities, Appium URL, or Allure plugin configuration. Keep this README aligned with the actual values in `pom.xml`, `DriverFactory.java`, and `allure.properties`.
- Do not commit generated files from `target/` or sensitive device/app credentials.
