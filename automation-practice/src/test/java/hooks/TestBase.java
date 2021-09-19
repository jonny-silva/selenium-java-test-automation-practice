package hooks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public static WebDriver driver;

	public static Actions action;
	static final String APP_URL = "http://automationpractice.com/index.php";
	static final String HOST_URL = "http://localhost:4444";

	public static void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);

		driver = new RemoteWebDriver(new URL(HOST_URL), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(APP_URL);
		driver.manage().window().maximize();

		action = new Actions(driver);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();

		}
	}
}
