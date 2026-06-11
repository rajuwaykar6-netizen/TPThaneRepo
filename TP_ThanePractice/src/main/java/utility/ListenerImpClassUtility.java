package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClassUtility implements ITestListener, ISuiteListener
{
	ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/LeadGainReport.html");
		spark.config().setDocumentTitle("LeadGainReport");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("LeadGain");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system: ", "windows 10");
	}

	@Override
	public void onTestStart(ITestResult result) {
		report.setSystemInfo("browser", ThreadSafeUtility.getBrowser());
		ThreadSafeUtility.setTest(report.createTest(result.getName()));
		ThreadSafeUtility.getTest().log(Status.INFO, result.getName()+" execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ThreadSafeUtility.getTest().log(Status.PASS, result.getName()+" execution successfull");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getInstance() instanceof MasterBaseClass) {
		ThreadSafeUtility.getTest().log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot)ThreadSafeUtility.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		ThreadSafeUtility.getTest().addScreenCaptureFromBase64String(filepath, result.getName());
		ThreadSafeUtility.getTest().log(Status.FAIL, "UI failed");
		}else {
			ThreadSafeUtility.getTest().log(Status.FAIL, result.getThrowable());
			ThreadSafeUtility.getTest().log(Status.FAIL, "Api failed");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ThreadSafeUtility.getTest().log(Status.SKIP, result.getName()+" got skipped"+ result.getThrowable());
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
}
