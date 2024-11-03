package Pages;

import AbstractComponents.abstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



import java.util.List;

public class resulPage extends abstractClass {
    WebDriver driver;

    public resulPage(WebDriver driver){
        super(driver);

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".cartSection h3")
    List<WebElement> header;
    @FindBy(css=".totalRow button")
    WebElement totalRow;
    By item=By.cssSelector(".ta-item ");
    @FindBy(xpath = "(//button[contains(@class, 'ta-item')]) [2]")
    WebElement button;
    @FindBy(css = ".action__submit")
    WebElement SubmitButton;
    @FindBy(css = ".hero-primary")
    WebElement gettitle;
    public Boolean getHeaders(String productName){
        List<WebElement> hdr= header;
        return hdr.stream().anyMatch(header->header.getText().equals(productName));

    }
       public String finalresult() {
        totalRow.click();
        Actions a=new Actions(driver);

        a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
        waitVisibility(item);
        button.click();
        SubmitButton.click();
        return gettitle.getText().toUpperCase();
            }
}
