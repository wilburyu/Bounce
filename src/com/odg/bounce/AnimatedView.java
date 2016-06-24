
package com.odg.bounce;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AnimatedView extends ImageView {

    private Context mContext;
    float mX = -1;
    float mY = -1;
    private int xVelocity = 10;
    private int yVelocity = 10;
    private int zVelocity = 10;
    private Handler h;
    private final int FRAME_RATE = 100;
    BitmapDrawable mBall;
    Bitmap mBallBitmap;
    
    int mHeight;
    int mWidth;

    public AnimatedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        h = new Handler();
        mBall = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ball);
        mBallBitmap = mBall.getBitmap();
        mHeight = mBallBitmap.getHeight();
        mWidth = mBallBitmap.getWidth();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    protected void onDraw(Canvas c) {
        if (mX < 0 && mY < 0) {
            mX = this.getWidth() / 2;
            mY = this.getHeight() / 2;
        }
        c.drawBitmap(mBallBitmap, mX, mY, null);
    }

    public void setNewPosition(float x, float y, float z) {
        x = x * xVelocity;
        y = y * yVelocity;
        mY+=y;
        mX+=x;
        z = z * zVelocity;
        if (Math.abs(z) > 10 && (mHeight + z > 5 && mHeight + z < 500) &&
                (mWidth + z > 5 && mWidth + z < 500)) {
            mHeight+=z;
            mWidth+=z;

            mBallBitmap = Bitmap.createScaledBitmap(
                    mBall.getBitmap(), mWidth, mHeight, true);
        }
        h.postDelayed(r, FRAME_RATE);
    }
}
