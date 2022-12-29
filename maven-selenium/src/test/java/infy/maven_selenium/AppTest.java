package infy.maven_selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AppTest 
{
   public static void main(String[] args) throws InterruptedException
   {
	   String drivers = "chrome";
	   WebDriver driver = null;
	     switch (drivers) {
			
	     case "chrome": { 
	               driver = new ChromeDriver();
                 driver.manage().window().maximize();
                 break;
                }
		
	     case "edge": {
		          driver = new EdgeDriver();
		          driver.manage().window().maximize();
		          break;
              } 
	     case "firefox": {
	            	driver = new FirefoxDriver();
		            driver.manage().window().maximize();
		            break;
                }
	     case "IE": {
		        driver = new InternetExplorerDriver();
		        driver.manage().window().maximize();
		        break;
            }
        default: {
		          	 driver = new EdgeDriver();
			         driver.manage().window().maximize();
	               }
	     }

	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	   driver.get("http://tutorialsninja.com/demo/");
	   driver.findElement(By.xpath("//a[@title='My Account']")).click();
	   driver.findElement(By.linkText("Login")).click();
	   driver.findElement(By.id("input-email")).sendKeys("amithab@gmail.com");
	   driver.findElement(By.id("input-password")).sendKeys("12345");
	   driver.findElement(By.xpath("//input[@value='Login']")).submit();
       Boolean boolean1 = driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed();
	   if(boolean1)
	   {
		   System.out.println("successfully logged in");
		   driver.findElement(By.name("search")).sendKeys("MacBook");
		   Actions actions = new Actions(driver);
		   actions.sendKeys(Keys.ENTER).perform();
		   Boolean boolean2 = driver.findElement(By.linkText("MacBook")).isDisplayed();
		   if(boolean2)
		   {
			   System.out.println("product displayed");
			   driver.findElement(By.linkText("MacBook")).click();
			   Boolean boolean3 = driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='MacBook']")).isDisplayed();
			   if(boolean3)
			   {
				   System.out.println("Product is loaded");
				   driver.findElement(By.id("input-quantity")).clear();
				   driver.findElement(By.id("input-quantity")).sendKeys("1");
				   driver.findElement(By.id("button-cart")).click();
				   Thread.sleep(2000);
				   String s = driver.findElement(By.cssSelector("div[class*=\"alert-success\"]")).getText();
				   if(s.contains("Success"))
				   {
					   System.out.println("Poduct  is addes to cart");
					   driver.findElement(By.id("cart-total")).click();
					   driver.findElement(By.xpath("//strong[text()=\" View Cart\"]")).click();
					   Boolean boolean4 = driver.findElement(By.linkText("Shopping Cart")).isDisplayed();
					   if(boolean4)
					   {
						   System.out.println("Cart page is opened successfully");
					       driver.findElement(By.linkText("Checkout")).click();
					       Boolean boolean5 = driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Checkout']")).isDisplayed();
					       if(boolean5)
					       {
					    	   System.out.println("Checkout Page Opened successfully");
					    	   driver.findElement(By.id("input-payment-firstname")).sendKeys("sharuk");
					    	   driver.findElement(By.id("input-payment-lastname")).sendKeys("khan");
					    	   driver.findElement(By.id("input-payment-company")).sendKeys("bollywood industries");
					    	   driver.findElement(By.id("input-payment-address-1")).sendKeys("1-2-5");
					    	   driver.findElement(By.id("input-payment-address-2")).sendKeys("punjab");
					    	   driver.findElement(By.id("input-payment-city")).sendKeys("mumbai");
					    	   driver.findElement(By.id("input-payment-postcode")).sendKeys("12658");
					    	   WebElement element = driver.findElement(By.id("input-payment-country"));
					    	   Select select = new Select(element);
					    	   select.selectByVisibleText("India");
  					    	   WebElement element2 = driver.findElement(By.id("input-payment-zone"));
  					    	   Select select2 = new Select(element2);
  					    	   select2.selectByVisibleText("Delhi");
					    	   driver.findElement(By.id("button-payment-address")).click();
					    	   driver.findElement(By.name("comment")).sendKeys("Booking Mackbook Laptop ");
					    	   driver.findElement(By.name("agree")).click();
					    	   driver.findElement(By.id("button-payment-method")).click();
					    	   
					       }else {
							System.out.println("error in opening Checkout page");
						}   
					   }else {
						System.out.println("Error in showing cart page");
					}   
				   }else {
					System.out.println("Product is failed while adding to cart");
				}		     
			   }else {
				System.out.println("Product is not loading");
			}   
		   }else {
			System.out.println("product is not displayed");
		   }	   
	   }else {
		System.out.println("Automation test failed while login");
	}
	// driver.quit();     
   }
}
