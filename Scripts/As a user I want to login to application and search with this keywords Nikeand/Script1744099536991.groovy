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
ElementAssert.verifyElementVisible('Object Repository/Page_Customer Login/button_Sign In')
ElementAssert.verifyElementVisible('Object Repository/Page_Home Page/input_Search_q')

CustomKeywords.'helpers.SearchKeywords.searchFor'('Nike')
CustomKeywords.'helpers.SearchKeywords.verifySearchResults'([
	'Nike air max',
	'Nike air max 2',
	'nike pants',
	'nike shirt',
	'Nike Air Max 270'
])

CustomKeywords.'helpers.BrowserKeywords.closeBrowser'()
