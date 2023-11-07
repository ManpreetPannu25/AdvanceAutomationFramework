package com.naveenAutomation_Utils;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = Utils.getCurrentDateTimeStamp();
		String reportName = " My Account Portal " + "...." + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\16476\\eclipse-workspace\\AutomationLearning\\Extent Reports\\" + reportName);
		htmlReporter.loadXMLConfig("C:\\Users\\16476\\eclipse-workspace\\AutomationLearning\\extent-config.xml");
		// either configure here or in the xml file
		// configuration here will override the behavior of xml file
		htmlReporter.config().setReportName("My Account Portal Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		extent = new ExtentReports();
		// passing the configuration to object-extent
		extent.attachReporter(htmlReporter);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// .flush method generates the report,without this no report will be generated
		extent.flush();
	}

}
