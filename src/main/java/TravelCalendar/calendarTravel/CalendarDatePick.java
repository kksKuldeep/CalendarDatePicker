package TravelCalendar.calendarTravel;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class CalendarDatePick {
	WebDriver driver;
	
	@Test
	public void getDate() throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "//usr//local//bin//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/hotels/");
		Thread.sleep(2000);
		
		//Click on Calendar 
		driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
		
		//select checkin date from Date Picker as After Some days 
		SimpleDateFormat dateF=new SimpleDateFormat("DD/MM/YYYY");
		Date d=new Date();
		String checkInDate=dateF.format(d);
		
		//for Check in date
		
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, 25);
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
		
		//For Check Out date
		c1.add(Calendar.DATE, 1);
		Date checkoutDate = c1.getTime();
		String dateOut=checkoutDate.toString();
		String outDatesplit[] = dateOut.split(" ");
		String outMonth= outDatesplit[1];
		String dateOut1 = outDatesplit[2];
		String outTime = outDatesplit[3];
		//System.out.println(dateresOut);
		//System.out.println("Month:"+outMonth);
		System.out.println("Futuredate checkout date:"+dateOut1);
		//System.out.println("Time:"+outTime);
		
		boolean stateElement=true;
		
		// Use Of try catch format
		
		try {
			List<WebElement> datelist = driver.findElements(By.cssSelector("li[class='date_is_selectable_true']"));
				
				stateElement=false;
				
				for(int i=0;i<datelist.size();i++) 
				{
					
					String date1=datelist.get(i).getText();
					//System.out.println(date1);
					
					List<String> arrlist = Arrays.asList(date1);
					
					if(arrlist.contains(futuredate)) 
					{
					driver.findElements(By.xpath("//li[@class='date_is_selectable_true']")).get(i).click();
						//System.out.println(Dates);
						
						System.out.println("Selected date is" +checkInDate);
					}
				
					else if	(arrlist.contains(dateOut1))
					{
						Thread.sleep(2000);
						driver.findElements(By.xpath("//li[@class='date_is_selectable_true']")).get(i).click();
						System.out.println(dateOut1);
					}
				}
		}catch(StaleElementReferenceException e) 
		{
			stateElement=true;	
		}

	}
}
		
	




