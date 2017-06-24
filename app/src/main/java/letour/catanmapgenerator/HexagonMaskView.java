package letour.catanmapgenerator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.ImageView;

public class HexagonMaskView extends ImageView {
    private Path hexagonPath;
    private Path hexagonBorderPath;
    private Paint mBorderPaint;
    public int l;
    public int w;

    public HexagonMaskView(Context context) {
        super(context);
        init();
    }

    public HexagonMaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HexagonMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.hexagonPath = new Path();
        this.hexagonBorderPath = new Path();

        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(Color.WHITE);
        this.mBorderPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mBorderPaint.setStrokeWidth(10f);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    public void setRadius(float radius) {
        calculatePath(radius);
    }

    public void setBorderColor(int color) {
        this.mBorderPaint.setColor(color);
        invalidate();
    }

    private void calculatePath(float radius) {
        //radius = radius / 5;

        float halfRadius = radius / 2f;
        float triangleHeight = (float) (Math.sqrt(3.0) * halfRadius);
        float centerX = getMeasuredWidth() / 2f;
        float centerY = getMeasuredHeight() / 2f;

        this.hexagonPath.reset();
        this.hexagonPath.moveTo(centerX, centerY + radius);
        this.hexagonPath.lineTo(centerX - triangleHeight, centerY + halfRadius);
        this.hexagonPath.lineTo(centerX - triangleHeight, centerY - halfRadius);
        this.hexagonPath.lineTo(centerX, centerY - radius);
        this.hexagonPath.lineTo(centerX + triangleHeight, centerY - halfRadius);
        this.hexagonPath.lineTo(centerX + triangleHeight, centerY + halfRadius);
        this.hexagonPath.close();

        float radiusBorder = radius - 5f;
        float halfRadiusBorder = radiusBorder / 2f;
        float triangleBorderHeight = (float) (Math.sqrt(3.0) * halfRadiusBorder);

        this.hexagonBorderPath.reset();
        this.hexagonBorderPath.moveTo(centerX, centerY + radiusBorder);
        this.hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY + halfRadiusBorder);
        this.hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY - halfRadiusBorder);
        this.hexagonBorderPath.lineTo(centerX, centerY - radiusBorder);
        this.hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY - halfRadiusBorder);
        this.hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY + halfRadiusBorder);
        this.hexagonBorderPath.close();
        invalidate();
    }

    public void setWid(int width)
    {
        w = width;
    }

    public void setLen(int length){
        l = length;
    }

    public int getWid(){
        return w;}

    public int getLen(){
        return l;}

    @Override
    public void onDraw(Canvas c) {
        c.drawPath(hexagonBorderPath, mBorderPaint);
        c.clipPath(hexagonPath, Region.Op.INTERSECT);
        c.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        super.onDraw(c);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //int width = MeasureSpec.getSize(widthMeasureSpec);
        //DisplayMetrics displaymetrics = new DisplayMetrics();
        //this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //int height = displaymetrics.heightPixels;
        //int width = displaymetrics.widthPixels;
        int width = getWid();
        //int height = MeasureSpec.getSize(heightMeasureSpec);
        int height = getWid();
        setMeasuredDimension(width, height);
        calculatePath(Math.min(width / 2f, height / 2f) - 10f);
        //calculatePath(Math.min(width / 2f, height / 2f));
    }
}

