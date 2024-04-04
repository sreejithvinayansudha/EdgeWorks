package ai.edgeworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import BaseClass.BaseClass;

public class RRMatchingSupplies extends BaseClass {

	public List<WebElement> SupplySourceButtons;

	public WebElement ProposeButton;

	public void clickSupplySourceButton() throws InterruptedException

	{

		Thread.sleep(3000);

		SupplySourceButtons = driver.findElements(By.xpath(
				"//button[@class ='btn btn-detail dropdown-toggle btn-white-space' and contains(text(),'Supply Source')]"));

		if (!(SupplySourceButtons == null)) {

			for (WebElement SupplySourceButton : SupplySourceButtons) {

				SupplySourceButton.click();
				System.out.println(SupplySourceButton.getText());

				ProposeButton = driver.findElement(By.xpath(
						"//button[@class ='btn btn-detail dropdown-toggle btn-white-space' and contains(text(),'Supply Source')]/following-sibling::ul[@class='dropdown-menu']/li/button[contains(text(),'Propose')]"));

				ProposeButton.click();

				SubmitForm submitF = new SubmitForm();

				submitF.SelectProperReason();

				AdjustSlideBar();

			}

			driver.close();

		}

		else

		{
			driver.close();

		}

	}

	public void AdjustSlideBar() throws InterruptedException {

		Thread.sleep(8000);

		WebElement SliderButton = driver.findElement(By.xpath("//div[@class='vue-slider-hover vue-slider-dot']"));

		try {

			SliderButton.click();
			Actions act = new Actions(driver);

			act.dragAndDropBy(SliderButton, -55, 0).build().perform();
		} catch (Exception e) {
			// retrieving the name input field again

			SliderButton = driver.findElement(By.xpath("//div[@class='vue-slider-hover vue-slider-dot']"));
			SliderButton.click();
			Actions act = new Actions(driver);

			act.dragAndDropBy(SliderButton, -55, 0).build().perform();
		}

	}

}
