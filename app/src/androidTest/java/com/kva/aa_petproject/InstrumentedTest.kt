package com.kva.aa_petproject

import com.kaspersky.kaspresso.testcases.api.testcase.TestCase


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class InstrumentedTest : TestCase() {
    /*private val secretPassword = "1234"
    private val wrongPassword = "9999"
    private val expectedUserName = "Иван Иванов"
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)


    @Test
    fun shouldLoginWithSecretPassword() {

        run {
            step("Open Main activity with valid name&password") {
                activityTestRule.launchActivity(null)
                MainScreen {
                    loginET {
                        replaceText(expectedUserName)
                    }
                    passwordET {
                        typeText(secretPassword)
                    }
                    loginBtn {
                        isVisible()
                        click()
                    }
                }
            }
            step("Verify user name on Name activity") {
                NameScreen {
                    nameTV {
                        hasText(String.format(getResourceString(R.string.hello), expectedUserName))
                    }
                }
            }
        }
    }

    @Test
    fun shouldNotLoginWithWrongPassword() {
        run {
            step("Open Main activity with wrong password input") {
                activityTestRule.launchActivity(null)
                MainScreen {
                    loginET {
                        replaceText(expectedUserName)
                    }
                    passwordET {
                        typeText(wrongPassword)
                    }
                    loginBtn {
                        isVisible()
                        click()
                    }
                }
            }
            step("Verify wrong password toast") {
                onView(withText(R.string.wrong_password_error)).inRoot(withDecorView(not(activityTestRule.activity.window.decorView))).check(matches(isDisplayed()));
            }
        }
    }


    @Test
    fun shouldNotLoginWithEmptyLogin() {
        run {
            step("Open Main activity with empty login input") {
                activityTestRule.launchActivity(null)
                MainScreen {
                    loginET {
                        typeText("")
                    }
                    passwordET {
                        typeText(wrongPassword)
                    }
                    loginBtn {
                        isVisible()
                        click()
                    }
                }
            }
            step("Verify empty login error toast") {
                onView(withText(R.string.login_empty_error)).inRoot(withDecorView(not(activityTestRule.activity.window.decorView))).check(matches(isDisplayed()));
            }
        }
    }
*/
}