package project_Activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class GoogleKeepReminder {
	AppiumDriver<MobileElement> driver = null;
	
 
  @BeforeClass
  public void beforeClass() throws InterruptedException, IOException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "626740f");
      caps.setCapability("deviceName", "AC2001");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noreset", true);
      
      try {
          // Initialize driver
          driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      } catch (MalformedURLException e) {
          System.out.println(e.getMessage());
      }
  }

  @Test
  public void googleTasks() {
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")).click();
//	  driver.findElementsByAccessibilityId("New text note");
	  driver.findElementById("com.google.android.keep:id/editable_title").click();
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Adding task");
	  driver.findElementById("com.google.android.keep:id/edit_note_text").click();
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Adding description");
	  driver.findElementById("com.google.android.keep:id/menu_reminder").click();
	  driver.findElementById("com.google.android.keep:id/time_spinner").click();
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView[1]").click();
	  driver.findElementById("com.google.android.keep:id/save").click();
	  
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
	  Boolean num=driver.findElementById("com.google.android.keep:id/reminder_chip_text").isDisplayed();
	  System.out.println("value is"+num);
	  Assert.assertTrue(num,"true");
	  
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
