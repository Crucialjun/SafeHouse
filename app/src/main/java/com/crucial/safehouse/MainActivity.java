package com.crucial.safehouse;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
                
        );
        
        showSignInOptions();
    }

    private void showSignInOptions() {
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),MY_REQUEST_CODE
        );
    }
}
