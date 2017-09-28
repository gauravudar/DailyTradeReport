# DailyTradeReport
This will generate and print daily trade reports for given input data

The Data Input

The data input is a instruction which describes an instruction to buy or sell given from various clients to the bank. 

It includes information such as:

Entity: A financial entity whose shares are to be bought or sold

Trade Action: Buy (Outgoing) or Sell (Incoming)

Agreed FX: The foreign exchange rate with respect to USD that was agreed

Currency: The currency in which instruction is traded

Instruction Date: Date on which the instruction was sent to JP Morgan by various clients

Settlement Date: The date on which the client wished for the instruction to be settled with respect to Instruction Date

USD Amount: Price per unit * Units * Agreed Fx (It is calculated during the object construction)

The working days

Depending on the currency of each instruction the settlement date may be change. 

More specifically, Middle East has different working days than the rest of the world. Therefore, a work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday. No other holidays to be taken into account.

Service

The Main Service which generates and print the report named "EntityReportService".
It uses BusinessDateProvider to check if the settlement date falls on weekend and sets the proper date accordingly.

To run the program and print the report

prerequisite :  "joda-time-2.9.9.jar" and "junit-4.12.jar"

Run Junit test with class named "EntityReportServiceTest.Java".

It has a method named "testGenerateAndPrintTradeReport()" which will generate and print the report as per requirement on the console.
It also has other test with method named "testGenerateAndPrintTradeReportWithWrongData" in case the input data is wrong.

To test Business date provider in case the settlement date falls on Weekend run the Junit test with class BusinessDateProviderTest.java.

The test data is created in TestData.java class.
