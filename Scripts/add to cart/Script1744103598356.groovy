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

def creds = new File('Data Files/user.txt').text.split(';')

GlobalVariable.email = (creds[0])

GlobalVariable.password = (creds[1])


if (!GlobalVariable.email) {
	GlobalVariable.email = 'user73566@example.com'
}
if (!GlobalVariable.password) {
	GlobalVariable.password = 'emYjF7uy@1Aa'
}

WebUI.openBrowser('')

WebUI.navigateToUrl('https://magento.softwaretestingboard.com/')

WebUI.click(findTestObject('Object Repository/Page_Home Page/a_Sign In'))

// Use stored credentials from registration test case
WebUI.setText(findTestObject('Object Repository/Page_Customer Login/input_Email_loginusername'), GlobalVariable.email)

WebUI.setText(findTestObject('Object Repository/Page_Customer Login/input_Password_loginpassword'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Page_Customer Login/button_Sign In'))





WebUI.click(findTestObject('Object Repository/Page_Home Page/span_Men'))

WebUI.click(findTestObject('Object Repository/Page_Men/a_Jackets'))

WebUI.click(findTestObject('Object Repository/Page_Jackets - Tops - Men/img_Add to Compare_product-image-photo'))

WebUI.click(findTestObject('Object Repository/Page_Montana Wind Jacket/button_Add to Cart'))

WebUI.click(findTestObject('Object Repository/Page_Montana Wind Jacket/div_Color_option-label-color-93-item-53'))

WebUI.click(findTestObject('Object Repository/Page_Montana Wind Jacket/button_Add to Cart'))

WebUI.click(findTestObject('Object Repository/Page_Montana Wind Jacket/div_M'))

WebUI.click(findTestObject('Object Repository/Page_Montana Wind Jacket/button_Add to Cart'))
WebUI.closeBrowser()
