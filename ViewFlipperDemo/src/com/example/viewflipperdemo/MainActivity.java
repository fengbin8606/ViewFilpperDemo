
package com.example.viewflipperdemo;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.viewflipperdemo.MenuImageView.MenuImageViewActionUpListener;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private MenuImageView led, printer, msr, ic, rf, pinpad, hsm, emv;

    ViewFlipper viewFlipper = null;
    float startX;

    ImageView current_page, other_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        current_page = (ImageView) findViewById(R.id.current_page);
        other_page = (ImageView) findViewById(R.id.other_page);

        led = (MenuImageView) findViewById(R.id.led);
        led.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {

            }
        });

        printer = (MenuImageView) findViewById(R.id.printer);
        printer.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {
            }
        });

        msr = (MenuImageView) findViewById(R.id.msr);
        msr.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {

            }
        });

        ic = (MenuImageView) findViewById(R.id.ic);
        ic.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {
            }
        });

        rf = (MenuImageView) findViewById(R.id.rf);
        rf.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {
            }
        });

        pinpad = (MenuImageView) findViewById(R.id.pinpad);
        pinpad.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {
            }
        });

        hsm = (MenuImageView) findViewById(R.id.hsm);
        hsm.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {
            }
        });

        emv = (MenuImageView) findViewById(R.id.emv);
        emv.setListener(new MenuImageViewActionUpListener() {

            @Override
            public void onActionUp(View v) {
            }
        });

    }

    public boolean onTouchEvent(MotionEvent event) {
        int displayedChild = viewFlipper.getDisplayedChild();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:

                if (event.getX() > startX) { // 向右滑动
                    viewFlipper.setInAnimation(this, R.anim.in_leftright);
                    viewFlipper.setOutAnimation(this, R.anim.out_leftright);

                    if (displayedChild == 1) {
                        viewFlipper.showNext();
                        current_page
                                .setBackgroundResource(R.drawable.show_current_page);
                        other_page
                                .setBackgroundResource(R.drawable.show_other_page);
                    }

                } else if (event.getX() < startX) { // 向左滑动
                    viewFlipper.setInAnimation(this, R.anim.in_rightleft);
                    viewFlipper.setOutAnimation(this, R.anim.out_rightleft);
                    if (displayedChild == 0) {
                        viewFlipper.showPrevious();
                        current_page.setBackgroundResource(R.drawable.show_other_page);
                        other_page.setBackgroundResource(R.drawable.show_current_page);
                    }
                }
                break;
        }

        // return super.onTouchEvent(event);
        return true;
    }

}
