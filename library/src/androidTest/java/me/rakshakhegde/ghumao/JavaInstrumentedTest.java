package me.rakshakhegde.ghumao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.animation.AccelerateDecelerateInterpolator;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JavaInstrumentedTest {

	// Context of the app under test.
	private Context appContext = InstrumentationRegistry.getTargetContext();

	@Test
	public void assertPackageName() throws Exception {
		assertEquals("me.rakshakhegde.ghumao.test", appContext.getPackageName());
	}

	@Test
	public void instantiateOverloadedGhumaoViewFromPlainJava() throws Exception {
		new GhumaoView(appContext);
		new GhumaoView(appContext, null);
		new GhumaoView(appContext, null, 0);
		new GhumaoView(appContext, null, 0, new AccelerateDecelerateInterpolator());
	}
}
