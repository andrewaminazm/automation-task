import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.callTestCase(findTestCase('r, I want to register new account to app, so that I can login to the'), [:], FailureHandling.STOP_ON_FAILURE)

def creds = new File('Data Files/user.txt').text.split(';')

GlobalVariable.email = (creds[0])

GlobalVariable.password = (creds[1])

// Open browser and go to login page
if (!(GlobalVariable.email)) {
    GlobalVariable.email = 'user73566@example.com'
}

if (!(GlobalVariable.password)) {
    GlobalVariable.password = 'emYjF7uy@1Aa'
}

WebUI.openBrowser('')

WebUI.navigateToUrl('https://magento.softwaretestingboard.com/')

WebUI.click(findTestObject('Object Repository/Page_Home Page/a_Sign In'))

// Use stored credentials from registration test case
WebUI.setText(findTestObject('Object Repository/Page_Customer Login/input_Email_loginusername'), GlobalVariable.email)

WebUI.setText(findTestObject('Object Repository/Page_Customer Login/input_Password_loginpassword'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Page_Customer Login/button_Sign In'))

// Log result
println(" Logged in with email: $GlobalVariable.email")

println(" Logged in with email: $GlobalVariable.password")

