package com.rebean.akbilsesleri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class otobus extends AppCompatActivity {
    Button b_prev, b_next,b_arka;
    ImageSwitcher imageSwitcher;

    Integer [] images={R.drawable.drawable1,R.drawable.drawable2,R.drawable.drawable3,R.drawable.drawable4,R.drawable.drawable5,R.drawable.drawable6,R.drawable.drawable7,
            R.drawable.drawable8,R.drawable.drawable9,R.drawable.drawable10,R.drawable.drawable11,R.drawable.drawable12,R.drawable.drawable13,R.drawable.drawable14,
            R.drawable.drawable15,R.drawable.drawable16,R.drawable.drawable17};

    int i=0;
    Animation in,out,in2,out2;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otobus);





        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2827780552516739/1672413434");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        imageSwitcher=(ImageSwitcher) findViewById(R.id.imageSwithcer);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                return  imageView;
            }
        });

        in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in);
        out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out);

        in2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in2);
        out2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out2);


        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        b_prev=(Button) findViewById(R.id.b_prev);
        b_next=(Button) findViewById(R.id.b_next);

        imageSwitcher.setImageResource(R.drawable.drawable1);

        b_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.setInAnimation(in2);
                imageSwitcher.setOutAnimation(out2);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                if (i >0){
                    i--;
                    imageSwitcher.setImageResource(images[i]);

                }
                else
                {imageSwitcher.setImageResource(images[i]);}

            }
        });

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                imageSwitcher.setInAnimation(in);
                imageSwitcher.setOutAnimation(out);
                if (i < images.length-1){
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                    if (i >= 23)
                    {
                        imageSwitcher.setImageResource(R.drawable.drawable17);
                    }
                }



            }

        });
    }
}