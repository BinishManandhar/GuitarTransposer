package com.binish.guitartransposer.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.binish.guitartransposer.R

class Toolbar: ConstraintLayout {
    var xInitial: Float = 0.0f
    var yInitial: Float = 0.0f
    var x1: Float = 0.0f
    var x2: Float = 0.0f
    var y1: Float = 0.0f
    var y2: Float = 0.0f
    var y3: Float = 0.0f

    var paint: Paint? = null
    var paint2: Paint? = null
    var path: Path? = null
    var mContext: Context

    constructor(context: Context) : super(context) {
        this.mContext = context
        init()
        initialValues()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.mContext = context
        init()
        initialValues()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.mContext = context
        init()
        initialValues()
    }

    private fun init() {
        setWillNotDraw(false)
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint!!.style = Paint.Style.FILL
        paint!!.color = resources.getColor(R.color.DarkKhaki)
        //        paint.setStrokeWidth(4);

        path = Path()

        paint2 = Paint()
        paint2!!.style = Paint.Style.FILL
        paint2!!.color = Color.TRANSPARENT
    }

    private fun initialValues(){
        xInitial = 0f
        yInitial = dp2px(69.6f)
        x1 = dp2px(82.6f)
        y1 = dp2px(107.8f)
        x2 = dp2px(247.5f)
        y2 = dp2px(93.47f)
        y3 = dp2px(69.6f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val height = height
        val width = width

        val delta = width / 10f

//        Log.i("Curve w", width.toString())

        path!!.moveTo(0f, yInitial)
        //path.cubicTo(2.52f*delta,1.66f*delta,5.97f*delta,1.75f*delta, width,dp2px(112));
        //path.cubicTo(2.4f*delta,4.41f*delta,7.02f*delta,4.15f*delta, width,dp2px(90));
//        x1 = 4.2,y1 = 4.2
//        path!!.cubicTo(2.8f * delta, 3.6f * delta, 6.88f * delta, 3.4f * delta, width.toFloat(), dp2px(112f).toFloat())
        path!!.cubicTo(x1, y1, x2, y2, width.toFloat(),y3)
        path!!.lineTo(width.toFloat(), 0f)
        path!!.lineTo(0f, 0f)

        canvas?.drawPath(path!!, paint!!)
    }

    private fun dp2px(dp: Float): Float {
        return (mContext.resources.displayMetrics.density * dp + 0.5f)
    }
}