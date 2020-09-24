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

public class GoogleTask {
	AppiumDriver<MobileElement> driver = null;
	
 
  @BeforeClass
  public void beforeClass() throws InterruptedException, IOException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "626740f");
      caps.setCapability("deviceName", "AC2001");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
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
	  
	  
	  driver.findElementById("com.google.android.apps.tasks:id/welcome_get_started").click();
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
	  driver.findElementById("add_task_title").click();
	  driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
	  driver.findElementById("add_task_done").click();
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
	  driver.findElementById("add_task_title").click();
	  driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
	  driver.findElementById("add_task_done").click();
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
	  driver.findElementById("add_task_title").click();
	  driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
	  driver.findElementById("add_task_done").click();

	  String t1=driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.widget.LinearLayout/android.widget.TextView")).getText();
	  System.out.println("title is"+t1);
	  Assert.assertTrue(t1.equals("Complete Activity with Google Tasks"), "Title doesn't matches");
//	  String t2=driver.findElementByAccessibilityId("Complete Activity with Google Keep").getText();
	  String t2=driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.widget.LinearLayout/android.widget.TextView")).getText();
	  System.out.println(t2);
	  Assert.assertTrue(t2.equals("Complete Activity with Google Keep"), "Title doesn't matches");
//	  String t3=driver.findElementByAccessibilityId("Complete the second Activity Google Keep").getText();
	  String t3=driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.widget.LinearLayout/android.widget.TextView")).getText();
	  System.out.println(t3);
	  Assert.assertTrue(t3.equals("Complete the second Activity Google Keep"), "Title doesn't matches");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
