import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable
import org.apache.commons.lang.RandomStringUtils
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import org.apache.commons.lang.RandomStringUtils

// === Generate Random Credentials ===
String randomFirstName = 'user' + RandomStringUtils.randomNumeric(5)
String randomLastName = 'test' + RandomStringUtils.randomNumeric(3)
String email = randomFirstName + '@example.com'
String password = RandomStringUtils.randomAlphanumeric(8) + '@1Aa' // strong password

// === Store values in Global Variables ===
GlobalVariable.email = email
GlobalVariable.password = password
// Save to file
new File('Data Files/user.txt').text = "${email};${password}"
// === Start registration ===
WebUI.openBrowser('')
WebUI.navigateToUrl('https://magento.softwaretestingboard.com/')
WebUI.click(findTestObject('Object Repository/Page_Home Page/a_Create an Account'))

WebUI.setText(findTestObject('Object Repository/Page_Create New Customer Account/input_First Name_firstname'), randomFirstName)
WebUI.setText(findTestObject('Object Repository/Page_Create New Customer Account/input_Last Name_lastname'), randomLastName)
WebUI.setText(findTestObject('Object Repository/Page_Create New Customer Account/input_Email_email'), email)
WebUI.setText(findTestObject('Object Repository/Page_Create New Customer Account/input_Password_password'), password)
WebUI.setText(findTestObject('Object Repository/Page_Create New Customer Account/input_Confirm Password_password_confirmation'), password)

WebUI.click(findTestObject('Object Repository/Page_Create New Customer Account/span_Create an Account'))

// === Print output (for debug) ===
println " Registered new user: ${email}"
println " Password: ${password}"
WebUI.closeBrowser()