package pageextension;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLogin_PF {
	
	@FindBy(id="login1")
	private WebElement txtusername;
	@FindBy(id="password")
	private WebElement txtpassword;
	@FindBy(name="proceed")
	private WebElement btnsignin;
	@FindBy(linkText="Create a new account")
	private WebElement lnkcreateacc;
	@FindBy(css="div#div_login_error")
	WebElement lblerror;
	List<WebElement> rbgender;
	
	// constructor
	public RediffLogin_PF(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password)
	{
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
		btnsignin.click();
	}
	public void gotoRegistartion()
	{
		lnkcreateacc.click();
	}
	public void clearData()
	{
		txtusername.clear();
		txtpassword.clear();
	}
	public void validateError()
	{
		WebElement lblerror = null;
		String acterror = lblerror.getText();
		assertEquals(acterror, "Wrong username and password combination");
	}

	
		

	

}



