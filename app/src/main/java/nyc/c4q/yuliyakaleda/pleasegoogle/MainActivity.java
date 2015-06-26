package nyc.c4q.yuliyakaleda.pleasegoogle;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends FragmentActivity {

    private boolean showingBack;
    private FrontFragment front = new FrontFragment();
    private BackFragment back = new BackFragment();
    private Context context;
    private Handler handler;
    private FlipAnimation flipAnimation;
    private FlipAnimation backFlip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(getMainLooper());

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, back, "fragmentRight").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, front, "fragmentLeft").commit();
        findViewById(R.id.flip).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                BackFragment right = (BackFragment) getSupportFragmentManager().findFragmentByTag("fragmentRight");
                FrontFragment left = (FrontFragment) getSupportFragmentManager().findFragmentByTag("fragmentLeft");
                left.parseData(right.getString());

                flipAnimation = new FlipAnimation(left.getView(), right.getView());
                backFlip = new FlipAnimation(left.getView(), right.getView());
                handler.removeCallbacks(rotate);
                handler.postDelayed(rotate, 100);
            }

        });
    }

    private Runnable rotate = new Runnable() {

        @Override
        public void run() {
            if (!showingBack) {
                front.getView().startAnimation(flipAnimation);
                back.getView().startAnimation(flipAnimation);
                showingBack = true;
            } else {
                showingBack = false;
                backFlip.reverse();
                front.getView().startAnimation(backFlip);
                back.getView().startAnimation(backFlip);

            }
        }
    };


}