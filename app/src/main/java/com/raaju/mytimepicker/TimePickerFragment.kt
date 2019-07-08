package com.raaju.mytimepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.raaju.mytimepicker.time.RadialPickerLayout

class TimePickerFragment : DialogFragment() {
 companion object {

   fun newInstance(num: Int): TimePickerFragment {
     val f = TimePickerFragment()

     // Supply num input as an argument.
     val args = Bundle()
     args.putInt("num", num)
     f.setArguments(args)

     return f
   }
 }


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return super.onCreateView(inflater, container, savedInstanceState)

    var v: View = inflater.inflate(R.layout.range_time_picker_dialog, container, false)

    val timePicker = v.findViewById(R.id.time_picker) as RadialPickerLayout

    timePicker.setOnValueSelectedListener { pickerIndex, newValue, autoAdvance ->

    }

    return v

  }

  /*public override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    var c: Calendar = Calendar.getInstance()
    var hour: Int = c.get(Calendar.HOUR_OF_DAY)
    var minute: Int = c.get(Calendar.MINUTE)

    return TimePickerDialog(
        activity, activity as TimePickerDialog.OnTimeSetListener?, hour, minute,
        DateFormat.is24HourFormat(
            activity
        )
    )
  }*/
}

