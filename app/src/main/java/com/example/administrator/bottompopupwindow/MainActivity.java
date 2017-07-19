package com.example.administrator.bottompopupwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener, AnimatorListener {
    /*生命控件*/
    private BottomPopupWindowView bottomPopupWindowView;
    private LinearLayout mainView;
    /*声明布局*/
    private View contentView;
    private View bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        bottomPopupWindowView = findViewById(R.id.bottom_popupWindow);
        mainView = findViewById(R.id.main_view);
        // 获得布局
        bottomView = LayoutInflater.from(this).inflate(R.layout.layout_bottom_view, null);
        contentView = LayoutInflater.from(this).inflate(R.layout.layout_content_view, null);
        // 给控件添加点击监听事件
        (findViewById(R.id.choose)).setOnClickListener(this);
        (bottomView.findViewById(R.id.promptly_buy)).setOnClickListener(this);
        (contentView.findViewById(R.id.ic_cancel)).setOnClickListener(this);
        // 给弹出框添加底部和内容布局
        bottomPopupWindowView.setBaseView(bottomView);
        bottomPopupWindowView.setContextView(contentView);
        // 给弹出框添加点击监听事件
        bottomPopupWindowView.setOnClickListener(this);
        // 给弹框添加接口监听事件
        bottomPopupWindowView.setAnimatorListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.promptly_buy:
            case R.id.ic_cancel:
                bottomPopupWindowView.disMissPopupView();
                break;
            case R.id.choose:
                bottomPopupWindowView.showPopupView();
                break;
        }
    }

    @Override
    public void startValue(int value) {
        setMargins(mainView, value - 10, value, value - 10, value);
    }

    @Override
    public void endValue(int value) {
        setMargins(mainView, value, value, value, value);
    }

    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
