package myapplication.jiyun.com.yue_kao;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView Text;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(Text, "scaleX", 1f, 2f, 1f);
//沿y轴放大
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(Text, "scaleY", 1f, 2f, 1f);
//移动
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(Text, "translationX", 0f, 200f, 0f);
//透明动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(Text, "alpha", 1f, 0f, 1f);
        AnimatorSet set = new AnimatorSet();
//同时沿X,Y轴放大，且改变透明度，然后移动
        set.play(scaleXAnimator).with(scaleYAnimator).with(animator).before(translationXAnimator);
//都设置3s，也可以为每个单独设置
        set.setDuration(3000);
        set.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        },2000);
    }

    private void initView() {
        Text = (TextView) findViewById(R.id.Text);
    }
}
