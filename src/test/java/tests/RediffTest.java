package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageextension.RediffLogin_PF;
import pageextension.RediffReg_PF;

public class RediffTest {
	
	WebDriver driver;
	RediffLogin_PF login;
	RediffReg_PF reg;
	
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe"); 
	driver = new ChromeDriver();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	driver.manage().window().maximize();
	login = new RediffLogin_PF(driver);
	reg = new RediffReg_PF(driver);
	
	  
  }
  @Test(groups= {"login","pri1"})
  public void tc01validlogin() {
	  login.login("admin", "admin");
	  login.clearData();
  }
  @Test(groups= {"login","pri2"})
  public void tc02invalidlogin() {
	  login.login("guest", "guest");
	  login.validateError();
	  login.clearData();
  }
  @Test(groups= {"registration","pri3"})
  public void tc03registartion() {
	  login.gotoRegistartion();
	  reg.register("sgdg", "ksgfks", "gsegfds","f");
  }
  @Test(groups= {"registration","pri3"})
  public void tc04newtest() {
	 System.out.println("new test added");
  }
  
  

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  driver.close();
  }

}



