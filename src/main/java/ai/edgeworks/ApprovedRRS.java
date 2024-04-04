package ai.edgeworks;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;

public class ApprovedRRS extends BaseClass {

	public String winHandleBefore;

	WebElement DropDown = driver.findElement(By.xpath("//li[@class ='dropdown']"));
	WebElement DropDownUser = driver.findElement(By.xpath("//a[@id ='down-user-button']"));

	WebElement CurrentRole = driver.findElement(By.xpath("//li/a[contains(text(),'Current Role -')]"));

	WebElement ModelDialog = driver.findElement(By.xpath("//div[@class ='modal-dialog modal-md']"));

	public RoleManage UserRoleChangePage() throws InterruptedException {

		if (!CurrentRole.getText().equals("Current Role - WFM"))

		{

			System.out.println(CurrentRole.getText());

			waitForElement(DropDownUser);
			DropDownUser.click();

			WebElement DropDownOpen = driver.findElement(By.xpath("//li[@class ='dropdown open']"));
			waitForElement(DropDownOpen);

			WebElement DropDownMenu = driver
					.findElement(By.xpath("//li[@class ='dropdown open']/ul[@class ='dropdown-menu']"));
			waitForElement(DropDownMenu);
			List<WebElement> options = DropDownMenu.findElements(By.tagName("li"));
			for (WebElement option : options)

			{
				if (option.getText().equals("Current Role - WFM"))

				{
					option.click(); // click the desired option
					break;
				}

				else if (option.getText().equals("Role Management"))

				{
					option.click();

					swichToRoleManagement();

					RoleManage RM = new RoleManage();
					RM.ChangeUserRole();

					break;

				}

			}

		}

		return new RoleManage();
	}

	public void enterSearchText(String searchvalue) throws InterruptedException

	{
		WebElement SearchText = driver
				.findElement(By.xpath("//input[@class = 'form-control p-0 no-borders' and @type ='text']"));

		Thread.sleep(2000);

		try {

			SearchText.click();
			SearchText.sendKeys(searchvalue);
		} catch (StaleElementReferenceException e) {
			// retrieving the name input field again

			SearchText = driver
					.findElement(By.xpath("//input[@class = 'form-control p-0 no-borders' and @type ='text']"));
			SearchText.click();
			SearchText.sendKeys(searchvalue);
		}

	}

	public void clearSearchText()

	{

		WebElement SearchText = driver
				.findElement(By.xpath("//input[@class = 'form-control p-0 no-borders' and @type ='text']"));

		SearchText.click();
		SearchText.clear();

	}

	public void clickSearchButton()

	{
		WebElement SearchButton = driver.findElement(By.xpath("//i[@class = 'bi_interface-search']"));

		try {

			SearchButton.click();

		} catch (StaleElementReferenceException e) {
			// retrieving the name input field again
			SearchButton = driver.findElement(By.xpath("//i[@class = 'bi_interface-search']"));

			SearchButton.click();

		}

	}

	public void clickOnRRId(String cellValue)

	{
		WebElement RRId = driver.findElement(By.partialLinkText(cellValue));
		waitForElement(RRId);
		RRId.click();

	}

	public void swichToRRMatchingSupplies() throws InterruptedException

	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		System.out.println(driver.getTitle());
		Iterator<String> I1 = windows.iterator();

		winHandleBefore = driver.getWindowHandle();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.getTitle());
				RRMatchingSupplies RRMatch = new RRMatchingSupplies();
				RRMatch.AdjustSlideBar();
				RRMatch.clickSupplySourceButton();
				driver.switchTo().window(winHandleBefore);

			}
		}

	}

	public void swichToRoleManagement()

	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		System.out.println(driver.getTitle());
		Iterator<String> I1 = windows.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.getTitle());

			}

		}

	}
}
