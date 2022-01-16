package com.itpm_gk.e07_jyanken_app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.itpm_gk.e07_jyanken_app.R;

public class MainActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = StartFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_container, fragment, "StartFragment")
            .commit();
    }
}
