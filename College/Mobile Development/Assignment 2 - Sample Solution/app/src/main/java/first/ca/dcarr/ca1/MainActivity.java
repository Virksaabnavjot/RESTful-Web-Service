package first.ca.dcarr.ca1;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText duration;
    EditText interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText principle = (EditText) findViewById(R.id.principle);
        interest = (EditText) findViewById(R.id.interest);
        duration = (EditText) findViewById(R.id.duration);
        final Spinner spinner = (Spinner)  findViewById(R.id.type);

        Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int principleInt = Integer.valueOf(principle.getText().toString());
                Double interestDouble = Double.parseDouble(interest.getText().toString());
                int durationInt = Integer.valueOf(duration.getText().toString());

                String[] array = getResources().getStringArray(R.array.options);

                if (spinner.getSelectedItem().toString().equals(array[0])){
                    Double result = calculateMonthlyPayment(principleInt, durationInt, interestDouble);

                    TextView view = (TextView) findViewById(R.id.display);
                    // formatting the result to four decimal places
                    String displayText = String.format( "%.2f", result);
                    view.setText(displayText);
                } else {
                    Toast.makeText(getApplicationContext(), "Not Supported yet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // set up the seekbar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
               interest.setText(String.valueOf(progresValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public static double calculateMonthlyPayment(int loanAmount, int termInYears, double interestRate) {

        interestRate /= 100.0;

        double monthlyRate = interestRate / 12.0;

        int termInMonths = termInYears * 12;

        double monthlyPayment =
                (loanAmount*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));

        return monthlyPayment;
    }
}
