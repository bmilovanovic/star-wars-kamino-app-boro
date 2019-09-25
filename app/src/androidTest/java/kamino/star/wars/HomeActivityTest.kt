package kamino.star.wars

import android.app.Activity
import android.app.Instrumentation
import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import kamino.star.wars.residents.ResidentListActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    private val likeCount = "10"
    private val planetName = "Planet: KAMINO"
    private val networkRequestWait = 2000L

    @Rule
    @JvmField
    val rule = IntentsTestRule<HomeActivity>(HomeActivity::class.java, false, true)

    @Test
    fun shouldDisplayBasicInfo() {
        // If these were real functional tests, we wouldn't wait for the server response
        // but rather mock it. This way it serves as an integration test also.
        SystemClock.sleep(networkRequestWait)

        onView(withId(R.id.planetImageView)).check(matches(isCompletelyDisplayed()))
        onView(withText(planetName)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.likeIcon)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.likeCountTextView)).check(matches(withText(likeCount)))
        onView(withId(R.id.imageSlider)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.residentsButton)).check(matches(withText(R.string.residents_list)))
    }

    @Test
    fun shouldShowResidentList() {
        SystemClock.sleep(networkRequestWait)

        intending(hasComponent(ResidentListActivity::class.java.name)).respondWith(
            Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        )

        onView(withId(R.id.residentsButton)).perform(click())

        // Check if residents button was clicked
        intended(
            allOf(
                hasComponent(ResidentListActivity::class.java.name),
                hasExtraWithKey(ResidentListActivity.residentUrlsExtraKey)
            )
        )
    }
}
