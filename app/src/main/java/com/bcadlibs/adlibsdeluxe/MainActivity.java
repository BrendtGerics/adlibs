package com.bcadlibs.adlibsdeluxe;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private void displayToastAboveButton(View v, int messageId, String message)
    {
        int xOffset = 0;
        int yOffset = 0;
        Rect gvr = new Rect();

        View parent = (View) v.getParent();
        int parentHeight = parent.getHeight();

        if (v.getGlobalVisibleRect(gvr))
        {
            View root = v.getRootView();

            int halfWidth = root.getRight() / 2;
            int halfHeight = root.getBottom() / 2;

            int parentCenterX = ((gvr.right - gvr.left) / 2) + gvr.left;

            int parentCenterY = ((gvr.bottom - gvr.top) / 2) + gvr.top;

            if (parentCenterY <= halfHeight)
            {
                yOffset = -(halfHeight - parentCenterY) - parentHeight;
            }
            else
            {
                yOffset = (parentCenterY - halfHeight) - parentHeight;
            }

            if (parentCenterX < halfWidth)
            {
                xOffset = -(halfWidth - parentCenterX);
            }

            if (parentCenterX >= halfWidth)
            {
                xOffset = parentCenterX - halfWidth;
            }
        }

        Toast toast = Toast.makeText(getBaseContext(), messageId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, xOffset, yOffset);
        toast.show();
    }
    RadioGroup rg;
    RadioButton rb;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.choice);
    }
    public void choice(View v) {
    /*
        int choiceid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(choiceid);
        String numberAsString = Integer.toString(choiceid);
        Toast.makeText(getBaseContext(),numberAsString,Toast.LENGTH_LONG).show();
    */
        int xOffset = 0;
        int yOffset = 0;
        Rect gvr = new Rect();

        View parent = (View) v.getParent();
        int parentHeight = parent.getHeight();

        if (v.getGlobalVisibleRect(gvr))
        {
            View root = v.getRootView();

            int halfWidth = root.getRight() / 2;
            int halfHeight = root.getBottom() / 2;

            int parentCenterX = ((gvr.right - gvr.left) / 2) + gvr.left;

            int parentCenterY = ((gvr.bottom - gvr.top) / 2) + gvr.top;

            if (parentCenterY <= halfHeight)
            {
                yOffset = -(halfHeight - parentCenterY) + parentHeight;
            }
            else
            {
                yOffset = (parentCenterY - halfHeight) + parentHeight;
            }

            if (parentCenterX < halfWidth)
            {
                xOffset = -(halfWidth - parentCenterX);
            }

            if (parentCenterX >= halfWidth)
            {
                xOffset = parentCenterX - halfWidth;
            }
        }




// Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();
        Toast mToast = Toast.makeText( this  , "" , Toast.LENGTH_LONG );
        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.group:
                if (checked)
                    mToast.setGravity(Gravity.CENTER, xOffset, yOffset);
                //mToast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
                mToast.setText(R.string.group_descript);

                break;
            case R.id.single:
                if (checked)
                    mToast.setGravity(Gravity.CENTER, xOffset, yOffset);
                //mToast.setGravity(Gravity.TOP|Gravity.LEFT,100,100);
                mToast.setText(R.string.single_descript);
                break;
        }
        mToast.show();

    }








}
