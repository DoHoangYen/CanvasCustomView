package com.example.admin.canvascustomview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;


/**
 * This class is used to
 *
 * @author Yen Do
 * @owner Moca.vn
 * @since 6/1/2016
 */
public class EnterTextView extends EditText {
    public static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private Paint mPaint;
    private int mMaxLength = 4;
    private int mHeight;
    private int mWidth;
    private Rect mRect;

    public EnterTextView(Context context) {
        super(context);
        init();
    }

    public EnterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        modifyAttributeSet(attrs);
    }

    public EnterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        modifyAttributeSet(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EnterTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        modifyAttributeSet(attrs);
    }

    private void init() {
        mPaint = new Paint();
        mRect = new Rect();
        setBackgroundColor(getResources().getColor(android.R.color.transparent));
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    private void modifyAttributeSet(AttributeSet attrs) {
        mMaxLength = attrs.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = getText().toString();
        mPaint.setTextSize(getTextSize());

        int widthPart = mWidth / mMaxLength;
        int widthLine = widthPart * 3 / 5;
        int widthLineText = widthPart * 3 / 5;

        int pointDraw = widthPart * 1 / 5;
        int pointDrawFirst = pointDraw;
        int startText = widthPart / 2;
        mPaint.getTextBounds("9", 0, 1, mRect);

        mPaint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.stroke_width));
//        mPaint.setStrokeCap(Paint.Cap.ROUND);

        float baseLineY = mHeight - mPaint.getStrokeWidth();
        float baseLineYText = mHeight - (getResources().getDimensionPixelSize(R.dimen.space_dline_text));

        for (int j = 0; j < mMaxLength; j++) {
            if (j == 0) {
                mPaint.setColor(getResources().getColor(R.color.colorAccent));
            } else {
                mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            canvas.drawLine(pointDrawFirst, baseLineY, pointDrawFirst + widthLine, baseLineY, mPaint);
            pointDrawFirst = pointDrawFirst + widthPart;
        }
        for (int i = 0; i < mMaxLength; i++) {
            if (text.length() > i) {
//                CalligraphyUtils.applyFontToTextView(getContext(), this, getResources()
//                        .getString(R.string.SF_UI_TEXT_SEMIBOLD));

                mPaint.setColor(getResources().getColor(R.color.colorPrimary));
                int characterLeftPosition = startText - mRect.width() / 2;
                canvas.drawText(String.valueOf(text.charAt(i)), characterLeftPosition,
                        baseLineYText, mPaint);

                mPaint.setColor(getResources().getColor(R.color.colorPrimary));
                canvas.drawLine(pointDraw, baseLineY, pointDraw + widthLineText, baseLineY, mPaint);
                pointDraw = pointDraw + widthPart;

                mPaint.setColor(getResources().getColor(R.color.colorAccent));
                canvas.drawLine(pointDraw, baseLineY, pointDraw + widthLineText, baseLineY, mPaint);
            }
            startText = startText + widthPart;
        }
    }
}