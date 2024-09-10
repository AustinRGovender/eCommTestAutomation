//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class ExtentReportManager {
//
//    private static ExtentReports extent;
//
//    public static ExtentReports getReporter() {
//        if (extent == null) {
//            extent = new ExtentReports();
//            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent-report.html");
//
//            // Set the custom CSS file
//            htmlReporter.config().setCSS("src/test/resources/extent-config.css");
//
//            extent.attachReporter(htmlReporter);
//        }
//        return extent;
//    }
//}
