package com.binish.guitartransposer

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_main_page_v2.*
import kotlinx.android.synthetic.main.layout_chord_picker.view.*
import kotlinx.android.synthetic.main.layout_chord_result.*
import org.mab.wheelpicker.CircularWheelView
import org.mab.wheelpicker.MainActivity

class MainPageV2 : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var animationDrawable: AnimationDrawable
    private lateinit var selectedItem: View
    private var isSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page_v2)
        selectedItem = layoutChord1
        setWheelPicker()
        pickerWork()
        pickerWorkResult()
        selectedChordLayout(layoutChord1)
        switchWork()
        clickListeners()
    }

    private fun clickListeners() {
        layoutChord1.setOnClickListener {
            selectedChordLayout(it)
        }
        layoutChord2.setOnClickListener {
            selectedChordLayout(it)
        }
        layoutChord3.setOnClickListener {
            selectedChordLayout(it)
        }
        layoutChord4.setOnClickListener {
            selectedChordLayout(it)
        }
    }

    private fun setWheelPicker() {
        val list = ArrayList<String>()
        val chords = resources.getStringArray(R.array.chords)
        for (chord in chords) {
            list.add(chord)
        }
        circularWheelPicker_one.setDataSet(list)
        circularWheelPicker_one.setWheelItemSelectionListener(object : CircularWheelView.WheelItemSelectionListener {
            override fun onItemSelected(index: Int) {
                if (!isSelected)
                    selectedItem.pickerChord1
                            .smoothScroll(selectedItem.pickerChord1.value <= index,
                                    if (selectedItem.pickerChord1.value > index) selectedItem.pickerChord1.value - index
                                    else index - selectedItem.pickerChord1.value)
                isSelected = false
            }
        })
        toggleVariation.setOnCheckedChangeListener { buttonView, isChecked ->
            switchTextVisibility(isChecked)
            animationDrawable.start()
            checkIfAnimationDone()
        }

    }

    private fun pickerWork() {
        val chords = resources.getStringArray(R.array.chords)
        layoutChord1.textViewChord1.text = getString(R.string.chord, "1")
        layoutChord1.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChord1.pickerChord1.minValue = 0
        layoutChord1.pickerChord1.maxValue = chords.size - 1
        layoutChord1.pickerChord1.dividerPadding = 0

        layoutChord1.pickerChord1.setOnValueChangedListener { picker, oldVal, newVal ->
            changeCurrentPositionOfWheel(layoutChord1, newVal)
        }


        layoutChord2.textViewChord1.text = getString(R.string.chord, "2")
        layoutChord2.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChord2.pickerChord1.minValue = 0
        layoutChord2.pickerChord1.maxValue = chords.size - 1
        layoutChord2.pickerChord1.dividerPadding = 0

        layoutChord2.pickerChord1.setOnValueChangedListener { picker, oldVal, newVal ->
            changeCurrentPositionOfWheel(layoutChord2, newVal)
        }

        layoutChord3.textViewChord1.text = getString(R.string.chord, "3")
        layoutChord3.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChord3.pickerChord1.minValue = 0
        layoutChord3.pickerChord1.maxValue = chords.size - 1
        layoutChord3.pickerChord1.dividerPadding = 0

        layoutChord3.pickerChord1.setOnValueChangedListener { picker, oldVal, newVal ->
            changeCurrentPositionOfWheel(layoutChord3, newVal)
        }

        layoutChord4.textViewChord1.text = getString(R.string.chord, "4")
        layoutChord4.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChord4.pickerChord1.minValue = 0
        layoutChord4.pickerChord1.maxValue = chords.size - 1
        layoutChord4.pickerChord1.dividerPadding = 0

        layoutChord4.pickerChord1.setOnValueChangedListener { picker, oldVal, newVal ->
            changeCurrentPositionOfWheel(layoutChord4, newVal)
        }

    }

    private fun pickerWorkResult() {
        val chords = resources.getStringArray(R.array.chords)
        layoutChordResult1.textViewChord1.text = getString(R.string.chord, "1")
        layoutChordResult1.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChordResult1.pickerChord1.minValue = 0
        layoutChordResult1.pickerChord1.maxValue = chords.size - 1
        layoutChordResult1.pickerChord1.dividerPadding = 0


        layoutChordResult2.textViewChord1.text = getString(R.string.chord, "2")
        layoutChordResult2.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChordResult2.pickerChord1.minValue = 0
        layoutChordResult2.pickerChord1.maxValue = chords.size - 1
        layoutChordResult2.pickerChord1.dividerPadding = 0


        layoutChordResult3.textViewChord1.text = getString(R.string.chord, "3")
        layoutChordResult3.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChordResult3.pickerChord1.minValue = 0
        layoutChordResult3.pickerChord1.maxValue = chords.size - 1
        layoutChordResult3.pickerChord1.dividerPadding = 0


        layoutChordResult4.textViewChord1.text = getString(R.string.chord, "4")
        layoutChordResult4.pickerChord1.displayedValues = resources.getStringArray(R.array.chords)
        layoutChordResult4.pickerChord1.minValue = 0
        layoutChordResult4.pickerChord1.maxValue = chords.size - 1
        layoutChordResult4.pickerChord1.dividerPadding = 0

    }

    private fun switchWork() {
        switchTextVisibility(false)
        toggleVariation.apply {
            setBackgroundResource(if (isChecked) R.drawable.toggleanimation_on else R.drawable.toggleanimation_off)
            animationDrawable = background as AnimationDrawable
        }
    }

    private fun switchTextVisibility(isChecked: Boolean) {
        (if (isChecked) textViewCapo else textViewTranspose).visibility = View.GONE
        (if (!isChecked) textViewCapo else textViewTranspose).visibility = View.VISIBLE
    }

    private fun checkIfAnimationDone() {
        val a = animationDrawable
        val timeBetweenChecks = 500
        val h = Handler()
        h.postDelayed(Runnable {
            run {
                if (a.current != a.getFrame(a.numberOfFrames - 1)) {
                    checkIfAnimationDone()
                } else {
                    toggleVariation.apply {
                        setBackgroundResource(if (isChecked) R.drawable.toggleanimation_on else R.drawable.toggleanimation_off)
                        animationDrawable = background as AnimationDrawable
                    }
                }
            }
        }, timeBetweenChecks.toLong())
    }

    private fun selectedChordLayout(chordView: View) {
        val prevSelected = selectedItem
        prevSelected.overlayLayout.visibility = View.VISIBLE
        selectedItem = chordView
        selectedItem.overlayLayout.visibility = View.GONE
        try {
            circularWheelPicker_one.setCurrentPosition(selectedItem.pickerChord1.value)
            isSelected = true
        } catch (exception: ArrayIndexOutOfBoundsException) {
            exception.stackTrace
        }
        val animator = ValueAnimator.ofFloat(0f, 0.2f)
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 300
        animator.addUpdateListener {
            prevSelected.scaleX = 1.2f - it.animatedValue as Float
            prevSelected.scaleY = 1.2f - it.animatedValue as Float
            selectedItem.scaleX = 1f + it.animatedValue as Float
            selectedItem.scaleY = 1f + it.animatedValue as Float
        }
        animator.start()
    }

    private fun changeCurrentPositionOfWheel(layout: View, newVal: Int) {
        if (selectedItem == layout)
            circularWheelPicker_one.setCurrentPosition(newVal)
    }
}
