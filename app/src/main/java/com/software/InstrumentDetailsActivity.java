package com.software;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.widget.TextView;

import com.software.R;

//Greated By gtj
public class InstrumentDetailsActivity extends AppCompatActivity {
    private TextView yueQiDetail;
    String yueQi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_details);

        findView();
        initYueQiData();
        //调整图片大小
        Bitmap bitmap = setImage(R.drawable.yinyue_bianzhong, 400,400);
        //实现图文混合展示
        SpannableStringToShow(bitmap);

    }

    private Bitmap setImage(int resId, int width, int height) {
        Resources res = this.getResources();
        Bitmap oldSize = BitmapFactory.decodeResource(res,resId);
        Bitmap newSize = Bitmap.createScaledBitmap(oldSize,width,height,true);
//        Drawable drawable = new BitmapDrawable(res,newSize);
        return newSize;

    }

    private void SpannableStringToShow(Bitmap bitmap) {
        SpannableString string = new SpannableString(yueQi);
        ImageSpan imageSpan = new ImageSpan(this,bitmap);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(1.5f);
        string.setSpan(imageSpan,0,2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        string.setSpan(superscriptSpan,3,11,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        string.setSpan(relativeSizeSpan,3,5,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        yueQiDetail.setText(string);

    }

    private void initYueQiData() {
        // TODO 通过Intend传入的乐器名从数据库中读取数据
        yueQi = "图片 阮咸(民族乐器)          阮[ruǎn]是一种中国传统乐器，阮咸的简称。" +
                "     相传西晋阮咸善弹此乐器，因而得名。四弦有柱，形似月琴。" +
                "始于唐代，元代时在民间广泛流传，成为人们喜爱的弹拨乐器，有了广阔的音域和丰富的表现力.";
    }

    private void findView() {
        yueQiDetail = findViewById(R.id.yueQi_detail);
    }
}