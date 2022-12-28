package pack1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public  class A {

	public static void main(String[] args) throws InterruptedException, IOException 
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
	     
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("http://omayo.blogspot.com/");
//       WebElement element = driver.findElement(By.id("textbox1"));
//       Thread.sleep(2000);
//       element.clear();
//       WebElement element1 = driver.findElement(By.id("ta1"));
//       element1.sendKeys("hello hi how at the");
//       Thread.sleep(2000);
//       element1.clear();
//       driver.findElement(By.className("classone")).sendKeys("dinesh");
//          driver.findElement(By.linkText("compendiumdev")).click();
//          Thread.sleep(3000);
     //     driver.navigate().to("http://omayo.blogspot.com/");
//          driver.navigate().back();
//          Thread.sleep(500);
//          driver.navigate().forward();
//          Thread.sleep(500);
//          driver.navigate().back();
//          Thread.sleep(500);
//          driver.navigate().refresh();
//
 //      System.out.println(driver.getCurrentUrl());
//       driver.close();
    //   driver.findElement(By.cssSelector("#confirm")).click();
    //   driver.findElement(By.xpath("//input[@id='confirm']")).click();
//         String text = driver.findElement(By.id("pah")).getText();
//         System.out.println(text);
//         System.out.println(driver.getTitle());
       
//       driver.findElement(By.linkText("Open a popup window")).click();
//       Thread.sleep(3000);
//       driver.findElement(By.linkText("Blogger")).click();
//       Thread.sleep(3000);
//         driver.close();
//         Thread.sleep(3000);
//       
//       String attribute = driver.findElement(By.id("textbox1")).getAttribute("id");
//       System.out.println("attribue is:  "+attribute);     
//       Boolean boolean1 = driver.findElement(By.id("hbutton")).isDisplayed();
//       System.out.println(boolean1);
//       Boolean boolean2 = driver.findElement(By.id("but1")).isEnabled();
//       System.out.println("button is enabled: "+ boolean2);
//       Boolean boolean3 = driver.findElement(By.id("checkbox2")).isSelected();
//       System.out.println("is selected: "+boolean3);
//       String source = driver.getPageSource();
//       System.out.println(source);
//       driver.navigate().to("https://dribbble.com/signup/new");
//       Thread.sleep(3000);
//       driver.findElement(By.id("user_name")).sendKeys("dobey");
//       Thread.sleep(1000);
//       driver.findElement(By.id("user_login")).sendKeys("dobey");
//       Thread.sleep(1000);
//       driver.findElement(By.id("user_email")).sendKeys("dobey@gmail.com");
//       Thread.sleep(1000);
//       driver.findElement(By.id("user_password")).sendKeys("dobey@123");
//       Thread.sleep(1000);
//       driver.findElement(By.id("user_agree_to_terms")).click();
//       Thread.sleep(1000);
 //      driver.findElement(By.name("commit")).submit();
//       Thread.sleep(3000);
//       String tagName = driver.findElement(By.id("user_password")).getTagName();
//       System.out.println(tagName);
//       String cssValue = driver.findElement(By.id("user_password")).getCssValue("width");
//       System.out.println(cssValue);
//       Dimension size = driver.findElement(By.id("user_password")).getSize();
//       System.out.println(size);
//       Point location = driver.findElement(By.id("user_password")).getLocation();
//       System.out.println(location);
//       driver.manage().window().fullscreen();
//       Thread.sleep(3000);
//       
//       List<WebElement> list = driver.findElements(By.tagName("a"));
//       Iterator<WebElement> itr = list.iterator();
//       while(itr.hasNext())
//       {
//    	   if(!itr.next().getText().isEmpty() && itr.next().getText().length()>2)
//    	   {
//    	   System.out.println(itr.next().getText());
//    	   }else {
//			continue;
//		}
//       }
//       System.out.println(list.size());
//         driver.quit();
		
//		driver.findElement(By.linkText("Open a popup window")).click();
//		driver.findElement(By.linkText("Blogger")).click();
//		Set<String> ids = driver.getWindowHandles();
//		Iterator<String> itr = ids.iterator();
//        String mainWindowId = null;
//        String popupwindow = null;
//        String blogwindow = null;
//		while (itr.hasNext()) {
//		  String id =	itr.next();
//		  driver.switchTo().window(id);
//		  if(driver.getTitle().equals("omayo (QAFox.com)"))
//		  {
//			  mainWindowId = id;
//		  }else if (driver.getTitle().equals("Basic Web Page Title")) {
//			popupwindow = id;
//		  }
//			else {
//				blogwindow = id;
//			}
//			
//		}
//		driver.switchTo().window(popupwindow);
//		String text = driver.findElement(By.id("para2")).getText();
//		System.out.println(text);
//		driver.switchTo().window(mainWindowId);
//		String text1 = driver.findElement(By.id("pah")).getText();
//		System.out.println(text1);
//		driver.switchTo().window(blogwindow);
//		driver.findElement(By.linkText("Blogger Buzz")).click();	
//		driver.switchTo().window(mainWindowId);
//		driver.findElement(By.className("dropbtn")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook")));
//		element.click();
//		driver.findElement(By.linkText("Facebook")).click();
//		
//
//		   Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
//		       .withTimeout(Duration.ofSeconds(3))
//		       .pollingEvery(Duration.ofSeconds(1))
//		       .ignoring(NoSuchElementException.class);
//
//		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//		     public WebElement apply(WebDriver driver) {
//		       return driver.findElement(By.linkText("Facebook"));
//		     }
//		   });
//		 element.click();
		 
//	    driver.navigate().back();
		
//		  driver.findElement(By.id("alert1")).click();
//		 Alert alert =  driver.switchTo().alert();
//		 System.out.println(alert.getText());
//		 alert.accept();
//		 
//		 driver.findElement(By.id("drop1")).sendKeys("doc 2");//this is not a good way to select option from drop down feild
		
//		WebElement element = driver.findElement(By.id("drop1"));
//		Select select = new Select(element);
////		select.selectByVisibleText("doc 3");
//		select.selectByIndex(2);
//		
//		WebElement element = driver.findElement(By.id("multiselect1"));
//		Select select = new Select(element);
//		select.selectByVisibleText("Volvo");
//		select.selectByVisibleText("Audi");
//		Thread.sleep(2000);
//		select.deselectByVisibleText("Audi");
//      
   //     driver.quit();
//         
//         driver.findElement(By.xpath("//p"));
//         driver.findElement(By.cssSelector("")).click();


//	  WebElement element =driver.findElement(By.id("iframe2"));
//		driver.switchTo().frame(element);
	//	driver.findElement(By.id("q")).sendKeys("hello");
//		driver.switchTo().defaultContent();
//		driver.findElement(By.name("userid")).sendKeys("hi");
		
//		System.out.println(driver.findElement(By.tagName("iframe")).getSize());
		
		
	//	driver.findElement(By.id("lightbox1")).click();
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//*[@class='close cursor']")).click();
	//	driver.findElement(By.cssSelector(".close.cursor")).click();
		
//		Actions actions = new Actions(driver);
//		WebElement element = driver.findElement(By.id("blogsmenu"));
//		actions.moveToElement(element).perform();
//		WebElement element1 = driver.findElement(By.xpath("//a/span[text()='SeleniumByArun']"));
//		actions.moveToElement(element1).click().build().perform();
//        WebElement element = driver.findElement(By.xpath("//a[@aria-labelledby=\"price-min-label\"]"));
//        Thread.sleep(2000);
//		actions.dragAndDropBy(element, 200, 0).perform();
//		Thread.sleep(2000);
//		WebElement element1 = driver.findElement(By.xpath("//a[@aria-labelledby=\"price-max-label\"]"));
//		actions.dragAndDropBy(element1, -200, 0).perform();
		
//		WebElement element2 = driver.findElement(By.name("q"));
//		actions.contextClick(element2).perform();
//		element2.sendKeys("hello");
//		actions.doubleClick(element2).perform();
		
//	    WebElement element = driver.findElement(By.linkText("compendiumdev"));
//		actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
		
//		driver.findElement(By.name("userid")).sendKeys("dinesh");
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.TAB).perform();
//		driver.findElement(By.name("pswrd")).sendKeys("12345");
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.TAB).perform();
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.ENTER).perform();
		
//		driver.findElement(By.id("ta1")).sendKeys(Keys.chord(Keys.CONTROL,"z"));
		
		
		
//	    File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	    Thread.sleep(3000);
//		FileUtils.copyFile(screenShotFile, new File("screenshots\\screenShotFile.png"));
//		driver.findElement(By.linkText("compendiumdev")).click();
//		Thread.sleep(2000);
//		File screenShotFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenShotFile1, new File("screenshots\\screenShotFile1.png"));
//		driver.quit();
		
//		Thread.sleep(3000);	
//		driver.findElement(By.xpath("//source[@type='image/webp']")).click();
//		Thread.sleep(5000);	
//		WebElement element = driver.findElement(By.id("fromCity"));
//		Actions actions = new Actions(driver);
//		actions.doubleClick(element).perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Del");
//		Thread.sleep(2000);   
//		actions.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.ENTER).perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		
		
//		Thread.sleep(3000);
//		 driver.findElement(By.id("form-field-travel_comp_date"));
//		Thread.sleep(2000);
//        Actions actions = new Actions(driver);
//        actions.doubleClick(element);
		
		
		List<WebElement> elements =  driver.findElements(By.xpath("//td[1]"));
		int i = 0;
		int j = 0;
		for(WebElement e:elements)
		{
			i++;
			String name = "Dheepthi";
			if(e.getText().equalsIgnoreCase(name))
			{
				System.out.println(i);
				j=i;
			}
		}
		
		String path = "//tr["+j+"]//td[1]";
		
		WebElement element = driver.findElement(By.xpath(path));
		
		System.out.println(element.getText());
		
		System.out.println(driver.findElement(By.xpath("//tbody/tr")).getSize());
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

