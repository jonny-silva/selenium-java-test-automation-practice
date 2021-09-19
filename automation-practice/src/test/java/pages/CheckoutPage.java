package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.TestBase;

public class CheckoutPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"product_1_1_0_0\"]/td[2]/p/a")
	WebElement productName;
	
	@FindBy(xpath = "//*[@id=\"product_price_1_1_0\"]/span")
	WebElement unitPrice;
	
	@FindBy(xpath = "//*[@id=\"product_1_1_0_0\"]/td[5]/input[2]")
	WebElement quantity;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productName.getText();
	}
	
	public String getUnitPrice() {
		return unitPrice.getText();
	}
	
	public String getQuantity() {
		return quantity.getAttribute("value");
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
}
