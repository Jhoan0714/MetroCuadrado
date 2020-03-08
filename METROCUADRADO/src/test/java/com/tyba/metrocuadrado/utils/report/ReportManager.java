/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyba.metrocuadrado.utils.report;

import com.relevantcodes.extentreports.ExtentReports;


/**
 *
 * @author Jhoan Lopez
 */
public class ReportManager {

    private static ExtentReports extent;
    public static String name;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "/Reports/"+name, true);
            
        }
        return extent;
    }
}
