package com.itpm_gk.e07_jyanken_app.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.itpm_gk.e07_jyanken_app.R;
import com.itpm_gk.e07_jyanken_app.model.Hand;
import com.itpm_gk.e07_jyanken_app.model.Player;
import com.itpm_gk.e07_jyanken_app.model.ProbStrategy;

public class JyankenFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = JyankenFragment.class.getSimpleName();
    public static final int RESULT_STATUS_WIN = 0;
    public static final int RESULT_STATUS_LOSE = 1;
    public static final int RESULT_STATUS_EVEN = 2;

    private String currentMsg = "";
    private AppCompatTextView msgTextView;

    public static Fragment newInstance() {
        return new JyankenFragment();
    }

    public interface JyankenActionCallback {
        void result(int resultStatus);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jyanken, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        msgTextView = view.findViewById(R.id.msg_text_view);
        view.findViewById(R.id.left_btn_layout).setOnClickListener(this);
        view.findViewById(R.id.center_btn_layout).setOnClickListener(this);
        view.findViewById(R.id.right_btn_layout).setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        currentMsg = getString(R.string.the_game);
        msgTextView.setText(currentMsg);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentMsg = getString(R.string.jan);
                msgTextView.setText(currentMsg);
            }
        }, 1000);
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();
        if (resId == R.id.left_btn_layout) {
            judgement(Hand.getHand(Hand.HAND_VALUE_GUU));
        } else if (resId == R.id.center_btn_layout) {
            judgement(Hand.getHand(Hand.HAND_VALUE_CHOKI));
        } else if (resId == R.id.right_btn_layout) {
            judgement(Hand.getHand(Hand.HAND_VALUE_PAA));
        }
    }

    private void judgement(Hand playerHand) {
        Player cpu = new Player("CPU", new ProbStrategy(1));
        Hand cpuHand = cpu.nextHand();
        // TODO: 相手の手の表示
        if (playerHand.isStrongerThan(cpuHand)) {
            Log.d(TAG, "Winner: Player");
            cpu.lose();
        } else if (cpuHand.isStrongerThan(playerHand)) {
            Log.d(TAG, "Winner: CPU");
            cpu.win();
        } else {
            Log.d(TAG, "Even...");
            cpu.even();
        }
    }
}
