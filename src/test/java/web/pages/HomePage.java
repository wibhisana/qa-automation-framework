package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;

    private By inventoryContainer = By.id("inventory_container");
    private By inventoryImages = By.cssSelector(".inventory_item_img img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    // Untuk problem_user
    public boolean hasBrokenImages() {
        List<WebElement> images = driver.findElements(inventoryImages);

        return images.stream()
                .anyMatch(img ->
                        img.getAttribute("src").contains("sl-404"));
    }
}
