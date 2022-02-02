package com.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import utils.SeleniumDriverObsolete;

public class ReportsUtils {
	
public static void AddToReport(String message ,String content){
	Allure.addAttachment(message, content);
}

public static void TakeScreenshot(Scenario scenario){
	  
		 System.out.println("After run");
			WebDriver driver = BaseVariables.getInstance().getWebdriver();
			//System.out.println(scenario.isFailed());
			/*
			 * if (scenario.isFailed()) {
			 */
				byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			 
				     String name = scenario.getName();
					scenario.attach(screenshotBytes,"image/png",scenario.getName());
			//}
	 		
		
		
		
	
}

@Attachment
public static void AttachFiletoReport(String fileName){
	try {
		
		String modifiledFilePath="";
		if (fileName.startsWith("0")) {
			modifiledFilePath= fileName;
		}
		else{
			modifiledFilePath="0"+fileName;
		}
		File fileObject = new File(PathConstants.getInstance().getDownloadFilePath(modifiledFilePath)); 
		
		Thread.sleep(4000);		
		  Allure.addAttachment("Barcode", FileUtils.openInputStream(fileObject));
		  Thread.sleep(4000);
	} catch (Exception e) {
		
	}
}
	 
}
