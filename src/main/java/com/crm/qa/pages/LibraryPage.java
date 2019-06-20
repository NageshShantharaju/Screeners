package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LibraryPage extends TestBase{
	
	@FindBy(xpath="//*[@class='binHead']")
	WebElement Binicon;
	
	@FindBy(id="SearchController")
	WebElement Searchicon;
	
	@FindBy(id="txtCurrentSearchText")
	WebElement Serachtextbox;
	
	@FindBy(xpath="//*[@id='browseThumb_5051-246165']")
	WebElement VideoFile;
	
	@FindBy(xpath="//*[@id='browseThumb_5051-246083']")
	WebElement ImageFile;
	
//	@FindBy(xpath="//*[@id='browseThumb_9001-297236']")
//	WebElement VideoFile;
//	
//	@FindBy(xpath="//*[@id='browseThumb_9001-308308']")
//	WebElement ImageFile;
	
	@FindBy(xpath="//*[@class='Bin']")
	WebElement Binarea;
	
	@FindBy(xpath="(//*[@id='screenerPublish'])[2]")
	WebElement ScreenerIcon;
	
	@FindBy(xpath="//*[@id='navigiationOpenClosePanel']")
	WebElement NavigationPanel;
	
	@FindBy(id="tenantLogo")
	WebElement Tenantlogo;
	
	public LibraryPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void DragandDropVideoAsset(String File1) throws InterruptedException
	{
		Thread.sleep(5000);
		Binicon.click();
		Searchicon.click();
		Serachtextbox.click();
		Serachtextbox.sendKeys(File1 ,Keys.ENTER);
		Thread.sleep(4000);
		System.out.println("Reday to click");
        VideoFile.click();
        System.out.println("clicked");
		Actions a = new Actions(driver);
		a.dragAndDrop(VideoFile, Binarea).build().perform();
		
	}
	 public void DragandDropImageAsset(String File2)
	 {
		 Searchicon.click();
		 Serachtextbox.clear();
		 Serachtextbox.click();
		 Serachtextbox.sendKeys(File2 , Keys.ENTER);
		 ImageFile.click();
		 Actions b = new Actions(driver);
		 b.dragAndDrop(ImageFile, Binarea).build().perform();
		 
	 }
	 public void ClickonBin()
	 {
		 Binicon.click();
	 }
	 
	 public ScreenerPublisherPage ClickOnScreenericon()
	 {
		boolean CheckforScreenerIcon = ScreenerIcon.isDisplayed();
		 if(CheckforScreenerIcon == true)
		 {
			 ScreenerIcon.click();
		 }
		 else
		 {
			 System.out.println("Screener Icon is not Enabled!!!!!!");
		 }
	     return new ScreenerPublisherPage();
		 
	 }
	 public void OpenNavigation()
	 {
		boolean Logo = Tenantlogo.isDisplayed();
		System.out.println("Logo is presnt" + Logo);
		if(Logo==true)
		{
			System.out.println("Panel Is Open");
		}
		else
		{
			NavigationPanel.click();
		}
	 }
	 
	 
	 
	 
//	 public void OpenNavigation()
//	 {		 
//			 NavigationPanel.click();
//		 
//	 }
//	

}
