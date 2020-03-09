/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyba.metrocuadrado.utils.report.listener;

import com.tyba.metrocuadrado.test.MetroCuadrado;
import com.relevantcodes.extentreports.LogStatus;
import com.tyba.metrocuadrado.utils.report.ReportTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 *
 * @author Jhoan Lopez
 */
public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 0; //Run the failed test 2 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                extendReportsFailOperations(iTestResult);
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    public void extendReportsFailOperations(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((MetroCuadrado) testClass).driver;
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        ReportTestManager.getTest().log(LogStatus.FAIL, "Test Failed", ReportTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
}
