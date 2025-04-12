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
import org.apache.commons.lang3.RandomStringUtils
import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable

public class AuthKeywords {
	@Keyword
	def generateAndSaveUser() {
		String firstName = 'user' + RandomStringUtils.randomNumeric(5)
		String lastName = 'test' + RandomStringUtils.randomNumeric(3)
		String email = firstName + '@example.com'
		String password = RandomStringUtils.randomAlphanumeric(8) + '@1Aa'

		GlobalVariable.email = email
		GlobalVariable.password = password

		new File('Data Files/user.txt').text = "${email};${password}"

		return [
			firstName,
			lastName,
			email,
			password
		]
	}

	@Keyword
	def registerUser(String firstName, String lastName, String email, String password) {
		WebUI.setText(findTestObject('Page_Create New Customer Account/input_First Name_firstname'), firstName)
		WebUI.setText(findTestObject('Page_Create New Customer Account/input_Last Name_lastname'), lastName)
		WebUI.setText(findTestObject('Page_Create New Customer Account/input_Email_email'), email)
		WebUI.setText(findTestObject('Page_Create New Customer Account/input_Password_password'), password)
		WebUI.setText(findTestObject('Page_Create New Customer Account/input_Confirm Password_password_confirmation'), password)

		WebUI.click(findTestObject('Page_Create New Customer Account/span_Create an Account'))
	}

	@Keyword
	def loadUserFromFile() {
		def creds = new File('Data Files/user.txt').text.split(';')
		GlobalVariable.email = creds[0]
		GlobalVariable.password = creds[1]
	}

	@Keyword
	def loginUser() {
		WebUI.setText(findTestObject('Page_Customer Login/input_Email_loginusername'), GlobalVariable.email)
		WebUI.setText(findTestObject('Page_Customer Login/input_Password_loginpassword'), GlobalVariable.password)
		WebUI.click(findTestObject('Page_Customer Login/button_Sign In'))
	}
}
