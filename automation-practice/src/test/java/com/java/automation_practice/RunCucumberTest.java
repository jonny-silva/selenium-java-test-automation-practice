package com.java.automation_practice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
					features = "src/test/resources/feature/Carrinho.feature",
					glue = {"com.java.automation_practice"},
					monochrome = true)
public class RunCucumberTest {

}
