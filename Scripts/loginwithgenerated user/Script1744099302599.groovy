import helpers.ElementAssertions as ElementAssert
import com.kms.katalon.core.model.FailureHandling as FailureHandling
CustomKeywords.'helpers.BrowserKeywords.openMagento'()
ElementAssert.verifyElementVisible('Object Repository/Page_Home Page/a_Sign In')
CustomKeywords.'helpers.NavigationKeywords.goToLoginPage'()
ElementAssert.verifyElementVisible('Object Repository/Page_Customer Login/input_Email_loginusername')
ElementAssert.verifyElementVisible('Object Repository/Page_Customer Login/input_Password_loginpassword')
ElementAssert.verifyElementVisible('Object Repository/Page_Customer Login/button_Sign In')
CustomKeywords.'helpers.AuthKeywords.loadUserFromFile'()
CustomKeywords.'helpers.AuthKeywords.loginUser'()

