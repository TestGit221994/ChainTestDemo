package com.demo.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/featureFiles/"}, glue = {
        "com/demo/api/stepDefinition"}, monochrome = true,tags = "@Demo",dryRun = false, plugin = {"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", "summary"
})


public class CommonRunner {

}
