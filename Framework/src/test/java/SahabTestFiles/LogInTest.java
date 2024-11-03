package SahabTestFiles;

import Base.baseTest;
import Pages.productPage;
import Pages.resulPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LogInTest extends baseTest {


    @Test
    public void NotabletoLogIn(){
        productPage pg=lg.logged("Email@mail.com","Test");
        Assert.assertEquals(lg.getErrorMsg(), "Incorrect email or password.");

    }
    @Test
    public void errCart(){

        String productName="ZARA COAT 3";
        productPage pp=lg.logged("dummy2@email.com","Test@123");

    }



}
