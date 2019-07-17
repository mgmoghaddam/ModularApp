package ir.pishrosoft.modularapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.pishrosoft.modularapp.models.Button;


public class MainActivity extends AppCompatActivity {

    Button buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            this.finish();
        }
    }
}
