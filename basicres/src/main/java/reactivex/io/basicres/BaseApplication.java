package reactivex.io.basicres;

import android.app.Application;
import android.support.annotation.Nullable;

public class BaseApplication extends Application {

    private static BaseApplication mAppCotext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppCotext = this;
    }

    @Nullable
    public static Application getAppContext() {
        return mAppCotext;
    }
}
