package com.itpm_gk.e07_jyanken_app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.itpm_gk.e07_jyanken_app.R;

public class MainActivity extends AppCompatActivity
    implements StartFragment.StartFragmentActionCallback
{
    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment startFragment = StartFragment.newInstance(this);
        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_container, startFragment, "StartFragment")
            .commit();
    }

    @Override
    public void onStartGame() {
        Fragment jyankenFragment = JyankenFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, jyankenFragment, "JyankenFragment")
                .commit();
    }

    @Override
    public void onBackPressed() {
        // TODO: 終了確認処理
        super.onBackPressed();
    }
}
