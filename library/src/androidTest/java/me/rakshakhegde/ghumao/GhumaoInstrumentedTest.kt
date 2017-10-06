package me.rakshakhegde.ghumao

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.kotlintest.matchers.shouldBe
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Rakshak.R.Hegde on 06-Oct-17.
 */
@RunWith(AndroidJUnit4::class)
class GhumaoInstrumentedTest {
	// Context of the app under test.
	private val appContext = InstrumentationRegistry.getTargetContext()

	private val ghumaoView = GhumaoView(appContext)

	@Test
	fun changesWidthOnSettingText() {
		ghumaoView.width shouldBe 0
		ghumaoView.text = "1234"
		assert(ghumaoView.width > 0)
	}
}