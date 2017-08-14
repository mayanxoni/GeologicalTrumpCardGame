package kookyinfomedia.com.gtcg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Category extends AppCompatActivity {
    private int flag;
    private boolean mIsBound = false;
    public static String selectedContinent="";
    LinearLayout pop;
    RelativeLayout img;
    MediaPlayer clicksound;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category);
        clicksound= MediaPlayer.create(this, R.raw.clicksound);
        doBindService();
        img=(RelativeLayout)findViewById(R.id.selected);
        pop=(LinearLayout)findViewById(R.id.pop);


        flag= getIntent().getIntExtra("int_value", 0);
        if(flag==1)
        {
            stopMusic();
        }
        else{
            startMusic();
        }
        initialize();
    }
    @Override
    public void onStop(){
        super.onStop();
        doUnbindService();
        stopMusic();
    }

    @Override
    public void onResume(){
        super.onResume();
        doBindService();

        if(flag==1)
        {
            stopMusic();
        }
        else{
            startMusic();
        }
    }
    @Override
    public  void onPause()
    {
        super.onPause();
        // If the screen is off then the device has been locked
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        boolean isScreenOn;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT_WATCH) {
            isScreenOn = powerManager.isScreenOn();
        }else{
            isScreenOn = powerManager.isScreenOn();
        }
        if (!isScreenOn) {

            doUnbindService();
            stopMusic();
        }
    }
    @Override
    public void onBackPressed(){
        clicksound.start();
        Intent intent=new Intent(this,Options.class);
        intent.putExtra("int_value",flag);
        startActivity(intent);
        finish();
    }
    public void startMusic(){
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        startService(music);
    }
    public void stopMusic(){
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);
    }



    public void openDeckAsia(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="asia";
        img.setBackground(getResources().getDrawable(R.drawable.asia));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();


    }
    public void openDeckNorthAmerica(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="north_america";
        img.setBackground(getResources().getDrawable(R.drawable.north_america));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void openDeckSouthAmerica(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="south_america";
        img.setBackground(getResources().getDrawable(R.drawable.south_america));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void openDeckAfrica(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="africa";
        img.setBackground(getResources().getDrawable(R.drawable.africa));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    public void openDeckEurope(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="europe";
        img.setBackground(getResources().getDrawable(R.drawable.europe));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void openDeckIndia(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="india";
        img.setBackground(getResources().getDrawable(R.drawable.india));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void openDeckAustralia(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="australia";
        img.setBackground(getResources().getDrawable(R.drawable.australia));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void openDeckWorld(View view){
        clicksound.start();
        view.setClickable(false);
        view.setEnabled(false);
        selectedContinent="world";
        view.setBackground(getResources().getDrawable(R.drawable.earth_hov));
        new CountDownTimer(1000,100){
            public void onTick(long ms){

            }
            public void onFinish(){
                Intent intent =new Intent(Category.this,DeckSelect.class);
                intent.putExtra("int_value",flag);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void initialize() {
        final LinearLayout pop=(LinearLayout)findViewById(R.id.pop);
        final RelativeLayout map = (RelativeLayout) findViewById(R.id.map);
        pop.animate()
                .setStartDelay(1500)
                .translationY(pop.getHeight())
                .alpha(0.0f)
                .setDuration(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.animate().cancel();
                pop.animate()
                        .translationY(pop.getHeight())
                        .alpha(0.0f)
                        .setDuration(1500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                pop.setVisibility(View.GONE);
                            }
                        });
            }
        });


    }

}
