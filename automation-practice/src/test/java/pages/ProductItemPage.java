package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.TestBase;

public class ProductItemPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
	WebElement productName;

	@FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
	WebElement quantity;

	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
	WebElement addToCart;

	@FindBy(css = "div#layer_cart a > span")
	WebElement proceedToCheckout;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement textAddedToCart;

	public ProductItemPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productName.getText();
	}

	public void clickProceedToCheckout() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", proceedToCheckout);

	}

	public void setQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}

	public void addToCart() {

		addToCart.click();

	}
		
	public boolean isModalReady(int waitInterval) {
		return (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.textToBePresentInElement(textAddedToCart, "Product successfully added to your shopping cart"));
		
	}


}
