
package com.odg.bounce;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.osterhoutgroup.api.ext.OdgHardwareExt;

import android.app.Activity;

public class Main extends Activity {

    AnimatedView mAnimatedView;
    private OdgHardwareExt mOdgHardwareExt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mAnimatedView = (AnimatedView) this.findViewById(R.id.anim_view);
        
        mOdgHardwareExt = new OdgHardwareExt(this);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        float z = mOdgHardwareExt.getMotionEventZAxis(event);
        Log.i("TAG", " ============== onTrackballEvent  " + event.getX() + "     " + event.getY() + "    " + z);
        mAnimatedView.setNewPosition(event.getX(), event.getY(), z);
        return super.onTrackballEvent(event);
    }
}
