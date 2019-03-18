package runalone.java.com.mrzhang.reader.runalone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import reactivex.io.onecompone.R;

/**
 * Created by mrzhang on 2017/6/15.
 */

public class OneTestActivity extends AppCompatActivity {

    OneFragment oneFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readerbook_activity_test);

        oneFragment= new OneFragment();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, oneFragment).commitAllowingStateLoss();
    }
}
