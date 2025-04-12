import helpers.ElementAssertions as ElementAssert
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR
CustomKeywords.'helpers.BrowserKeywords.openMagento'()
ElementAssert.verifyElementVisible('Object Repository/Page_Home Page/a_Sign In')
ElementAssert.verifyElementVisible('Object Repository/Page_Home Page/a_Create an Account')
CustomKeywords.'helpers.NavigationKeywords.goToRegisterPage'()
ElementAssert.verifyElementVisible('Object Repository/Page_Create New Customer Account/input_Email_email')
ElementAssert.verifyElementVisible('Object Repository/Page_Create New Customer Account/input_First Name_firstname')
ElementAssert.verifyElementVisible('Object Repository/Page_Create New Customer Account/input_Last Name_lastname')
ElementAssert.verifyElementVisible('Object Repository/Page_Create New Customer Account/input_Password_password')
ElementAssert.verifyElementVisible('Object Repository/Page_Create New Customer Account/span_Create an Account')
ElementAssert.verifyElementVisible('Object Repository/Page_Home Page/a_Create an Account')




def userInfo = CustomKeywords.'helpers.AuthKeywords.generateAndSaveUser'()
CustomKeywords.'helpers.AuthKeywords.registerUser'(userInfo[0], userInfo[1], userInfo[2], userInfo[3])

ElementAssert.verifyElementVisible('Object Repository/Page_Home Page/div_ThankYouMessage')

String firstName = userInfo[0]
String lastName  = userInfo[1]
String email     = userInfo[2]  // ✅ This is your generated email
String password  = userInfo[3]
TestObject userInfoBox = OR.findTestObject('Object Repository/Page_Home Page/div_UserInfoBox')
String displayedInfo = WebUI.getText(userInfoBox)


WebUI.verifyMatch(displayedInfo, ".*${email}.*", true)

CustomKeywords.'helpers.BrowserKeywords.closeBrowser'()
