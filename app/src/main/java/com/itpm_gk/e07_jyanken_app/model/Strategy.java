package com.itpm_gk.e07_jyanken_app.model;

public interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
