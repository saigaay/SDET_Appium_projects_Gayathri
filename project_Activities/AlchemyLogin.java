package project_Activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AlchemyLogin {
	AppiumDriver<MobileElement> driver = null;
  @Test
  public void f() {	  
	  
//	  driver.findElementById("com.android.chrome:id/send_report_checkbox").click(); // accepting terms
	  driver.findElementById("com.android.chrome:id/terms_accept").click();// accepting terms
	  driver.findElementById("com.android.chrome:id/next_button").click();// accepting terms
	  driver.findElementById("com.android.chrome:id/negative_button").click();// accepting terms	  
//      driver.get(" https://www.training-support.net/selenium");
//	  driver.findElementById("com.android.chrome:id/search_box_text").click();
	  driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("https://www.training-support.net/selenium");
	  Actions action = new Actions(driver); action.sendKeys(Keys.ENTER).build().perform();
	  

	  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Please sign in.\").instance(0))"));
	  driver.findElement(MobileBy.xpath("//android.view.View[@content-desc=\"Login Form Please sign in.\"]")).click();

	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  String validmsg=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
	  Assert.assertEquals(validmsg,"Welcome Back, admin");
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).clear();
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin1");
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).clear();
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password1");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  String validmsg1=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
	  Assert.assertEquals(validmsg1,"Invalid Credentials");
	  

      
	  
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException, IOException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "626740f");
      caps.setCapability("deviceName", "AC2001");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noreset", true);
      
      try {
          // Initialize driver
          driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

      } catch (MalformedURLException e) {
          System.out.println(e.getMessage());
      }
  }

  @AfterClass
  public void afterClass() {
//	  driver.quit();
  }

}
