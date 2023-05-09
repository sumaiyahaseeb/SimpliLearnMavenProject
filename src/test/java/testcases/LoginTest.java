package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void test1() {
		LoginPage login = new LoginPage(driver);
		login.Loginfunction("abc@xyz.com", "Abc@12345");

		WebElement error = driver.findElement(By.id("msg_box"));

		String Actualerror = error.getText();
		String Expectederror = "The email or password you have entered is invalid.";

		Assert.assertEquals(Actualerror, Expectederror);

	}

	@Test
	public void test2() {
		LoginPage login = new LoginPage(driver);
		login.Loginfunction("pqr@xyz.com", "Pqr@12345");
	}

	// calling data from the external file
	@Test
	public void test4(Method method) throws FilloException {
		LoginPage login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("select * from data where TestName= '"+method.getName()+"'");
		recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");

		login.Loginfunction(username, password);

	}

}
