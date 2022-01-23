package com.itpm_gk.e07_jyanken_app.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.itpm_gk.e07_jyanken_app.R;

public class StartFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = StartFragment.class.getSimpleName();

    public static Fragment newInstance(StartFragmentActionCallback callback) {
        StartFragment startFragment = new StartFragment();
        startFragment.setActionCallback(callback);
        return startFragment;
    }

    public interface StartFragmentActionCallback {
        void onStartGame();
    }

    private StartFragmentActionCallback actionCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.start_btn).setOnClickListener(this);
    }

    public void setActionCallback(StartFragmentActionCallback callback) {
        actionCallback = callback;
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();
        if (resId == R.id.start_btn) {
            if (actionCallback != null) {
                Log.d(TAG, "action onStart!");
                actionCallback.onStartGame();
            }
        } else {
            Log.d(TAG, "Unknown View.");
        }
    }
}
