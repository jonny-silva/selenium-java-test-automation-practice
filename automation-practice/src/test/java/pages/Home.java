package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.TestBase;

public class Home extends TestBase {

	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img")
	WebElement firstProduct;

	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]")
	WebElement buttonMore;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/text()")
	WebElement labelAddedToCart;

	public Home() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getProductName() {
		return firstProduct.getAttribute("title");
	}

	public void addRandomProductToCart() {
		mouseHover(firstProduct);
		buttonMore.click();
	}

	public String getTextAddedToCart() {
		return labelAddedToCart.getText();
	}

	public void mouseHover(WebElement element) {
		action.moveToElement(firstProduct).build().perform();
		;
	}
}
