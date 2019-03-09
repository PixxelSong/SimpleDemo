package com.example.simpledemo;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseLineareLayout extends LinearLayout {

    static List<BaseLineareLayout> list = new ArrayList<>();

    public BaseLineareLayout(Context context) {
        super(context);
        list.add(this);

    }
    public abstract void refresh();
}
