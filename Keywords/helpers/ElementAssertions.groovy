package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable

public class ElementAssertions {

	// This method verifies the visibility of an element and allows for failure handling
	@Keyword
	def static verifyElementVisible(String testObjectPath, FailureHandling failureHandling = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject testObject = findTestObject(testObjectPath)
		WebUI.verifyElementVisible(testObject, failureHandling)
	}

	@Keyword
	def verifyElementText(String testObjectPath, String expectedText, int timeout = 10) {
		// Verifies if the element's text matches the expected text
		WebUI.verifyElementText(ObjectRepository.findTestObject(testObjectPath), expectedText, timeout)
	}

	@Keyword
	def verifyElementAttribute(String testObjectPath, String attributeName, String expectedValue, int timeout = 10) {
		// Verifies if the element's attribute matches the expected value
		WebUI.verifyElementAttributeValue(ObjectRepository.findTestObject(testObjectPath), attributeName, expectedValue, timeout)
	}
}
