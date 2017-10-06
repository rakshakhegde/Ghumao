package me.rakshakhegde.ghumao

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator

/**
 * Created by Rakshak.R.Hegde on 06-Oct-17.
 */
class GhumaoView @JvmOverloads constructor(
		context: Context,
		attrs: AttributeSet? = null,
		defStyleAttr: Int = 0,
		timeInterpolator: TimeInterpolator = DecelerateInterpolator()
) : View(context, attrs, defStyleAttr) {

	val valueAnimator = ValueAnimator().apply {
		setFloatValues(0F, 1F)
	}

	var text: String = ""
		set(value) {
			invalidate()
			field = value
		}

	init {
		setTimeInterpolator(timeInterpolator)
	}

	fun setTimeInterpolator(timeInterpolator: TimeInterpolator) {
		valueAnimator.interpolator = timeInterpolator
	}
}