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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
def creds = new File('Data Files/user.txt').text.split(';')
GlobalVariable.email = creds[0]
GlobalVariable.password = creds[1]
// Open browser and go to login page
WebUI.openBrowser('')
WebUI.navigateToUrl('https://magento.softwaretestingboard.com/')
WebUI.click(findTestObject('Object Repository/Page_Home Page/a_Sign In'))

// Use stored credentials from registration test case
WebUI.setText(findTestObject('Object Repository/Page_Customer Login/input_Email_loginusername'), GlobalVariable.email)
WebUI.setText(findTestObject('Object Repository/Page_Customer Login/input_Password_loginpassword'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Page_Customer Login/button_Sign In'))




WebUI.setText(findTestObject('Object Repository/Page_Home Page/input_Search_q'), 'Nike')

WebUI.sendKeys(findTestObject('Object Repository/Page_Home Page/input_Search_q'), Keys.chord(Keys.ENTER))


WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Search results for Nike/a_Nike air max'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Search results for Nike/a_Nike air max 2'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Search results for Nike/a_nike pants'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Search results for Nike/a_nike shirt'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Search results for Nike/a_Nike Air Max 270'))

