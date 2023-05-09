package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver pagedriver; // driver declaration

	// ======================================objects==========================================
	@FindBy(linkText = "Log in")
	WebElement loginlink;

	@FindBy(name = "user_login")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(className = "rememberMe")
	WebElement checkbox;

	@FindBy(name = "btn_login")
	WebElement loginbuttton;

	//========================================Methods=========================================
	//default action to be taken whenever creating new page
	// initailising pagedriver which was null and passing the value as chrome driver to in login page (testcase driver)
	public LoginPage(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(pagedriver, this);

	}

	public void Loginfunction(String usernameval, String pwdval) {

		loginlink.click();

		username.sendKeys(usernameval);

		password.sendKeys(pwdval);

		checkbox.click();

		loginbuttton.click();
	}
}
