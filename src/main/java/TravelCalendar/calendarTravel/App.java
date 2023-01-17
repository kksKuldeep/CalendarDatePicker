/*package Travellingcalendar.Travellingcalendar;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calendartravel {
	
	WebDriver driver;
	
	@Test
	public void getdate() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\chromedriver.exe");
		
		
        driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/hotels/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
       // driver.findElement(By.xpath("//div[@class='sc-xayxd-0 kOmJSj']//li[2]//a[1]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@id='downshift-1-input']")).sendKeys("Delhi");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//li[@id='downshift-1-item-0']")).click();
        Thread.sleep(8000);
        
        
        driver.findElement(By.cssSelector("div[data-testid='openCheckinCalendar']")).click();
        
        Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String date = formatter.format(d);
		String splitter[] = date.split("-");-
		String month_year = splitter[1];
		String day = splitter[2]; 
		//System.out.println(date);
		//System.out.println(month_year);
		//System.out.println(day);
			
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, 15);
		Date resultDate = c1.getTime();
		String dateres=resultDate.toString();
		String datesplit[] = dateres.split(" ");
		String month= datesplit[1];
		String futuredate = datesplit[2];
		String time = datesplit[3];
		System.out.println(dateres);
		System.out.println("Month:"+month);
		System.out.println("Futuredate:"+futuredate);
		System.out.println("Time:"+time);
		
		//List<WebElement> datelistaug = driver.findElements(By.cssSelector("li[data-testid*='date_li']"));
		
		List<WebElement> auglist=driver.findElements(By.xpath("//div[@class='dcalendar-newstyles__DayAndDateLeftWrapper-sc-1i003by-14 flDYDD']//ul[@class='dcalendar-newstyles__DateWrapDiv-sc-1i003by-18 eFyCNL']"));
		
		
		List<WebElement> seplist=driver.findElements(By.xpath("//div[@class='dcalendar-newstyles__DayAndDateRightWrapper-sc-1i003by-15 eLOwsV']//ul[@class='dcalendar-newstyles__DateWrapDiv-sc-1i003by-18 eFyCNL']"));
		
		
		for(int i=0;i<auglist.size();i++) {
			
			String date1=auglist.get(i).getText();
			//System.out.println(date1);
			
			List<String> arrlist = Arrays.asList(date1);
			
			if(arrlist.contains(futuredate)) {
			
				//driver.findElements(By.cssSelector("li[data-testid*='date_li']")).get(i).click();
				
				String selecteddate=driver.findElements(By.cssSelector("li[data-testid*='date_li']")).get(i).getText();
				System.out.println(selecteddate);
			}
		}
		
	}
	

}*/
































		
        
	
