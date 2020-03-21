package com.travelers.helpers;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.SeleniumHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListner implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test Success");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            System.out.println("On test Failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException | NoSouchDriverException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On test onTestFailedButWithinSuccessPercentage");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("On test onTestFailedWithTimeout");

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On test Start");

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On test Finish");

    }
}
