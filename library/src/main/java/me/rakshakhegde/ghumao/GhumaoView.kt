package me.rakshakhegde.ghumao

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.annotation.VisibleForTesting
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator

/**
 * Created by Rakshak.R.Hegde on 06-Oct-17.
 */
class GhumaoView @JvmOverloads constructor(
		context: Context,
		attrs: AttributeSet? = null,
		defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

	private val valueAnimator = ValueAnimator().apply {
		setFloatValues(0F, 1F)
		interpolator = DecelerateInterpolator()
	}

	val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)

	var text: String = if (isInEditMode) "1234" else ""
		set(value) {
			field = value
			invalidate()
		}

	var timeInterpolator: TimeInterpolator
		get() = valueAnimator.interpolator
		set(value) {
			valueAnimator.interpolator = timeInterpolator
		}

	private lateinit var charWidths: FloatArray

	override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
		setMeasuredDimension(suggestedMinimumWidth, suggestedMinimumHeight)
	}

	@VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
	public override fun getSuggestedMinimumWidth(): Int {
		// We'll use charWidths later on to calculate center position of each character
		charWidths = FloatArray(text.length)
		textPaint.getTextWidths(text, charWidths)
		return charWidths.sum().toInt() + paddingLeft + paddingRight
	}

	@VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
	public override fun getSuggestedMinimumHeight(): Int {
		val fontMetrics = textPaint.fontMetrics
		return (fontMetrics.descent - fontMetrics.ascent + paddingTop + paddingBottom).toInt()
	}

	override fun onDraw(canvas: Canvas) {
		// Let the view draw it's background if it has any
		super.onDraw(canvas)

		canvas.translate(paddingLeft.toFloat(), paddingTop.toFloat())

		val baseline = -textPaint.fontMetrics.ascent

		charWidths.foldIndexed(0F) { index, x, charWidth ->
			canvas.drawText(text[index].toString(), x, baseline, textPaint)
			x + charWidth
		}
	}
}