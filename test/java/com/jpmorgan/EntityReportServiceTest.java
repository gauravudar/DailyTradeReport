package test.java.com.jpmorgan;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import main.java.com.jpmorgan.BusinessDateProvider;
import main.java.com.jpmorgan.EntityReportService;
import junit.framework.TestCase;

import static test.java.com.jpmorgan.TestData.getTestEntityDataObjects;
import static test.java.com.jpmorgan.TestData.getTestEntityDataObjectsWithWrongData;

public class EntityReportServiceTest extends TestCase {
	private EntityReportService entityReportService;
	private BusinessDateProvider businessDateProvider;
	
	
	public void setUp() throws Exception {
		super.setUp();
		entityReportService = new EntityReportService();
		businessDateProvider = new BusinessDateProvider();
		entityReportService.setBusinessDateProvider(businessDateProvider);		
	}
	
	public void testGenerateAndPrintTradeReport() throws Exception {
		entityReportService.generateAndPrintTradeReport(getTestEntityDataObjects());
	}
	
	public void testGenerateAndPrintTradeReportWithWrongData() throws Exception {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		entityReportService.generateAndPrintTradeReport(getTestEntityDataObjectsWithWrongData());
		assertTrue(out.toString().contains("Error in generating trade report"));
	}
	
	
	
}
