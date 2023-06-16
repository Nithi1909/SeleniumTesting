import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamSorting 
{
 @Test
 public void streamSort()
 {
	 System.setProperty("webdriver.chrome.driver", "/home/trisys/Downloads/chromedriver_linux64/chromedriver");
		WebDriver d1 = new ChromeDriver();
		d1.manage().window().maximize();
		d1.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		d1.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = d1.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(originalList);
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		do
		{
			List<WebElement> elementsList1 = d1.findElements(By.xpath("//tr/td[1]"));
		price = elementsList1.stream().filter(s->s.getText().contains("Cheese")).map(s->getPrice(s)).collect(Collectors.toList());
		price.stream().forEach(a->System.out.println(a));
		if(price.size()<1)
	   {
		   d1.findElement(By.xpath("//a[@aria-label='Next']")).click();
	   }
		}while(price.size()<1);
}

private String getPrice(WebElement s) 
{
 String priceValue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
	return priceValue;
}
}
