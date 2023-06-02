package com.saucedemo.runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
		
		features="src/test/resources/features"
		,glue="com/saucedemo/steps"
		,dryRun=false
        ,tags= {"@parallel1"} 
		,monochrome=true
		,plugin = {"pretty", "html:target/cucumber-default-reports1", "json:target/cucumber.json"}	
		
)	

public class TestRunner1 {			
	
}

