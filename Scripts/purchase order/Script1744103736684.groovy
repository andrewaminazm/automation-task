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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.callTestCase(findTestCase('add to cart'), [:], FailureHandling.STOP_ON_FAILURE)

def creds = new File('Data Files/user.txt').text.split(';')

GlobalVariable.email = (creds[0])

GlobalVariable.password = (creds[1])

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

WebUI.click(findTestObject('Object Repository/Page_Home Page/a_My Cart'))

WebUI.click(findTestObject('Object Repository/Page_Home Page/button_Proceed to Checkout'))

// Generate random data
String randomStreet = RandomStringUtils.randomAlphabetic(10) + ' Street'

String randomCity = RandomStringUtils.randomAlphabetic(8)

String randomZip = RandomStringUtils.randomNumeric(5)

String randomPhone = '01' + RandomStringUtils.randomNumeric(9 // e.g., 01xxxxxxxxx
    )

// Fill form with generated data
WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_Street Address Line 1_street0'), randomStreet)

WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_City_city'), randomCity)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Checkout/select_Please select a region, state or pro_d80c8a'), 
    '14', true)

WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_ZipPostal Code_postcode'), randomZip)

WebUI.setText(findTestObject('Object Repository/Page_Checkout/input_Phone Number_telephone'), randomPhone)

WebUI.click(findTestObject('Object Repository/Page_Checkout/input_Carrier Title_ko_unique_5'))

WebUI.click(findTestObject('Object Repository/Page_Checkout/button_Next'))



WebUI.click(findTestObject('Object Repository/Page_Checkout/place-order'))

