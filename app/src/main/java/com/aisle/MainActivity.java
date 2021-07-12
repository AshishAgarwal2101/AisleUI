package com.aisle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView otpScreenButton = findViewById(R.id.main_screen_otp_button);
        TextView phoneNumberScreenButton = findViewById(R.id.main_screen_phone_number_button);
        TextView homeScreenButton = findViewById(R.id.main_screen_home_button);

        otpScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),OtpScreen.class);
                startActivity(i);
            }
        });
        phoneNumberScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PhoneNumberScreen.class);
                startActivity(i);
            }
        });
        homeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });
    }
}