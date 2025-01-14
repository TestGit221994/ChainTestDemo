package com.demo.api.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/featureFiles/"}, glue = {
        "com/demo/api/stepDefinition"}, monochrome = true,tags = "@Demo",dryRun = false, plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReports.json", "rerun:target/cucumber-reports/rerun.txt","com.aventstack.chaintest.plugins.ChainTestCucumberListener:", "summary"
})

public class CommonRunner extends AbstractTestNGCucumberTests {

}
