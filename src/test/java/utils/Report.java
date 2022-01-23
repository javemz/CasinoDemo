package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void createReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("src/main/resources/reports/ExtentReportResults"+ System.currentTimeMillis() +".html");
        extent.attachReporter(spark);
    }

    public static void createTest(String nameTest){
        test = extent.createTest(nameTest);
    }

    public static void closeReport(){
        extent.flush();
    }

}
