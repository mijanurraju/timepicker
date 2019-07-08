package com.raaju.mytimepicker

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raaju.mytimepicker.time.RadialPickerLayout
import com.raaju.mytimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.activity_main.button
import java.util.Calendar

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {

  private var mStackLevel = 0
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener {
      /*val timePicker = TimePickerFragment()
      timePicker.show(supportFragmentManager, "time picker")*/
      //this.showDialogFragment()
      showDialog()
    }

  }

  /*@SuppressLint("SetTextI18n")
  override fun onTimeSet(
    view: TimePicker?,
    hourOfDay: Int,
    minute: Int
  ) {
    textView.text = "$hourOfDay $minute"
  }*/

  fun showDialogFragment() {

    mStackLevel++

    // DialogFragment.show() will take care of adding the fragment
    // in a transaction.  We also want to remove any currently showing
    // dialog, so make our own transaction and take care of that here.
    val ft = supportFragmentManager.beginTransaction()
    val prev = supportFragmentManager.findFragmentByTag("dialog")
    if (prev != null) {
      ft.remove(prev)
    }
    ft.addToBackStack(null)

    // Create and show the dialog.
    val newFragment = TimePickerFragment.newInstance(mStackLevel)
    newFragment.show(ft, "dialog")
    // Create the fragment and show it as a dialog.
  }

  private fun showDialog() {
    val now = Calendar.getInstance()
    val tpd = TimePickerDialog.newInstance(
        this@MainActivity,
        now.get(Calendar.HOUR_OF_DAY),
        now.get(Calendar.MINUTE),
        false
    )
    tpd.setOnCancelListener(
        DialogInterface.OnCancelListener { Log.d("TimePicker", "Dialog was cancelled") })
    tpd.show(fragmentManager, "Timepickerdialog")
  }

  override fun onTimeSet(
    view: RadialPickerLayout?,
    hourOfDay: Int,
    minute: Int,
    hourOfDayEnd: Int,
    minuteEnd: Int
  ) {
    var hourString = if (hourOfDay < 10) "0$hourOfDay" else "" + hourOfDay
    var minuteString = if (minute < 10) "0$minute" else "" + minute

    var hourStringEnd = if (hourOfDayEnd < 10) "0$hourOfDayEnd" else "" + hourOfDayEnd
    var minutehourStringEnd = if (hourOfDayEnd < 10) "0$hourOfDayEnd" else "" + hourOfDayEnd
    var minuteStringEnd = if (minuteEnd < 10) "0$minuteEnd" else "" + minuteEnd
    var time = " $hourString:$minuteString To $hourStringEnd:$minuteStringEnd"

    // var timeTextView.setText(time)
  }

}
