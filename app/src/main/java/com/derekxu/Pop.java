package com.derekxu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.derekxu.pianochordpads.R;

/**
 * Created by Derek on 2016-06-11.
 */
public class Pop extends Activity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    TextView note;
    String chordType = "maj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.popup);
        Button confirmbut = (Button) findViewById(R.id.confirmbutton);

        super.onCreate(savedInstanceState);
        spinner =(Spinner) findViewById(R.id.spinnote);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Root, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.75), (int)(height * 0.75));

        confirmbut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("getnote", note.getText());
                intent.putExtra("gettype", chordType);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        note = (TextView) view;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radMajor:
                if (checked)
                    chordType = "maj";
                    break;
            case R.id.radMinor:
                if (checked)
                    chordType = "min";
                    break;
            case R.id.radV7:
                if(checked)
                    chordType = "V7";
                    break;
        }
    }
}
