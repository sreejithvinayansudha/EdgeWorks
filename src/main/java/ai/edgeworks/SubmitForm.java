package ai.edgeworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class SubmitForm extends BaseClass {

	WebElement RadioButton;
	WebElement SelectRadioButton;
	WebElement ModelBody;
	WebElement SubmitButton;
	WebElement CancelButton;

	public void SelectProperReason() {

		SubmitButton = driver.findElement(By.xpath("//button[@class ='btn btn-primary']/span"));

		CancelButton = driver
				.findElement(By.xpath("(//div[@class='pull-right']/button[contains(text(),'Cancel')])[2]"));

		ModelBody = driver.findElement(By.xpath("(//div[@class ='modal-body'])[6]"));

		SelectRadioButton = driver.findElement(By.xpath("//label[contains(@for,'Suitable_skill_match')]"));

		ModelBody.click();

		SelectRadioButton.click();

		SubmitButton.click();

//		List<WebElement> RadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
//		
//		
//		for(WebElement RadioButton : RadioButtons)
//			
//			
//			RadioButton.click();
//		

	}

}
