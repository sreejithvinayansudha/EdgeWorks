package ai.edgeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class FrontPage extends BaseClass {

	WebElement SignInButton;

	public LoginPage UstEmployeeSignIn() {

		SignInButton = driver.findElement(By.xpath("//span[contains(text(),'UST Employees Sign in')]"));
		SignInButton.click();

		return new LoginPage();

	}

}
