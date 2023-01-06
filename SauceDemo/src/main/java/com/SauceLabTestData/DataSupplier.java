package com.SauceLabTestData;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.SauceLabUtility.Utility_Excel;

public class DataSupplier {
	Utility_Excel excel = new Utility_Excel();

	@DataProvider(name = "info")
	public Object[][] getData() throws InvalidFormatException {
		Object data[][] = excel.getTestData("Sheet2");
		return data;

	}
}
