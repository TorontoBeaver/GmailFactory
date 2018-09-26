package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.pages.Utils.PropertyLoader;

import java.util.Properties;

public class AbstractPage {


	public Properties prop;
	protected TestBase testBase;

	public AbstractPage() {
		prop = PropertyLoader.loadProps("src/main/java/com/qa/config/config.properties");
		this.testBase = TestBase.getInstance();
	}

}
