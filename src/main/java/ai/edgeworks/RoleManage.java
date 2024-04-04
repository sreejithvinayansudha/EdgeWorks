package ai.edgeworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class RoleManage extends BaseClass {

	public void ChangeUserRole() throws InterruptedException {

		WebElement OKButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));

		WebElement EdgeDropdown = driver
				.findElement(By.xpath("(//div[@class ='edge-dropdown--selected'])[2]/following-sibling::i"));

		EdgeDropdown.click();

		WebElement DropDownMenu = driver.findElement(By.xpath(
				"(//h4[contains(text(),'Switch to HM')]/following-sibling::div/div/ul[@class='list-group'])[1]"));

		List<WebElement> options = DropDownMenu.findElements(By.tagName("li"));
		for (WebElement option : options) {

			if (option.getText().equals("WFM")) {
				option.click(); // click the desired option
				break;
			}
		}

		OKButton.click();

	}
}
