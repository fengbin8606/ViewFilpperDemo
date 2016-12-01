
package com.example.viewflipperdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends Activity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        context = this;

        // setStatusBarAndNavigationBarTransparent();

    }

    private void setStatusBarAndNavigationBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);

            // ״̬������Ϊ͸��ɫ
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(Color.TRANSPARENT);

            // ����������Ϊ͸��ɫ
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setNavigationBarTintResource(Color.TRANSPARENT);
        }
    }

    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits =
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;// ״̬��
        final int bits1 = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;// ������
        if (on) {
            winParams.flags |= bits1;
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits1;
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    // ����״̬����ɫ
    public void setStatusBarColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup contentView = (ViewGroup) this.findViewById(android.R.id.content);
        View statusBarView = new View(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(this));
        // R.color.status_bar_colorΪ�Լ��������ɫ
        statusBarView.setBackgroundColor(getResources().getColor(R.color.status_bar_color));
        contentView.addView(statusBarView, lp);
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
