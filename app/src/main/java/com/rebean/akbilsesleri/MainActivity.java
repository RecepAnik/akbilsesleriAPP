package com.rebean.akbilsesleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    Animation anim1;
    Animation anim2;

ImageButton otobus;
    ImageView  imageVie22w1,bos,ana,indi,akt;
    private int res1,value1,ia=1;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer ses= MediaPlayer.create(this,R.raw.bos);
        final MediaPlayer ses1= MediaPlayer.create(this,R.raw.tam);
        final MediaPlayer ses2= MediaPlayer.create(this,R.raw.aktarma);
        final MediaPlayer ses3= MediaPlayer.create(this,R.raw.ind);
          bos =(ImageView) findViewById(R.id.imageButton1);
          ana =(ImageView) findViewById(R.id.imageButton2);
          indi =(ImageView) findViewById(R.id.imageButton3);
          akt =(ImageView) findViewById(R.id.imageButton5);
        otobus=(ImageButton) findViewById(R.id.imageButton);
        bos =(ImageView) findViewById(R.id.imageButton1);
        anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);

        this.setUpAnimation();
        AdView mAdView=(AdView)findViewById(R.id.adView);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2827780552516739/8836354137");

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2827780552516739/8174009150");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());






         bos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (mInterstitialAd.isLoaded()) {
                     mInterstitialAd.show();
                 } else {
                     Log.d("TAG", "The interstitial wasn't loaded yet.");
                 }
                 bos.startAnimation(anim1);
                 ses.start();
             }
         });
        ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                ana.startAnimation(anim1);
                ses1.start();ia++;
            }
        });
        indi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                ses3.start();ia++;
                indi.startAnimation(anim1);
            }
        });
        akt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                ses2.start();ia++;
                akt.startAnimation(anim1);
            }
        });


        otobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent intent = new Intent(MainActivity.this, otobus.class);
                startActivity(intent);
            }
        });
    }


    public void setUpAnimation() {
        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {



                if(animation == anim1){


                }
                value1=1;






            }

            @Override
            public void onAnimationRepeat(Animation animation) {


            }
        };

        anim1.setAnimationListener(animationListener);
    }







}