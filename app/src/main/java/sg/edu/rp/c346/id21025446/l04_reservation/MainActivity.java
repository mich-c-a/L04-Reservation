package sg.edu.rp.c346.id21025446.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mn;
    EditText size;
    DatePicker dp;
    TimePicker tp;
    CheckBox smoking;
    CheckBox nonsmoking;
    Button cfm;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        mn = findViewById(R.id.etMN);
        size = findViewById(R.id.etSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        smoking = findViewById(R.id.cbSmoking);
        nonsmoking = findViewById(R.id.cbNonSmoking);
        cfm = findViewById(R.id.btnConfirm);
        reset = findViewById(R.id.btnReset);

        cfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int day = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                String dispmsg = "Name: " + name.getText().toString() + "\nMobile number: " + mn.getText().toString() + "\nGroup size " + size.getText().toString() + "\nDate: " +
                        day + "/" + month + "/" + year + "\nTime: " + hour + ":" + min;

                if(smoking.isChecked()){
                    dispmsg += "\nSmoking area chosen";
                }else{
                    dispmsg += "\nNon-smoking area chosen";
                }

                Toast.makeText(MainActivity.this, dispmsg, Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                name.setText("");
                mn.setText("");
                size.setText("");
                dp.updateDate(2020,6,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });
    }
}