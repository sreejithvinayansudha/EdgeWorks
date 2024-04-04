package ai.edgeworks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass {

	WebElement UserName;
	WebElement PassWord;
	WebElement SubmitButton;

	public ApprovedRRS UserLogin() throws IOException {
		UtilsClass util = new UtilsClass();
		UserName = driver.findElement(By.xpath("//input[@id ='userNameInput']"));

		PassWord = driver.findElement(By.xpath("//input[@id ='passwordInput']"));

		SubmitButton = driver.findElement(By.xpath("//span[@id ='submitButton']"));

		UserName.sendKeys(util.getUsername());
		PassWord.sendKeys(util.getPassword());

		SubmitButton.click();

		return new ApprovedRRS();

	}

}
