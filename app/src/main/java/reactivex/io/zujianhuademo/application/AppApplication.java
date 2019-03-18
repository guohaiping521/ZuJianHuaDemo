package reactivex.io.zujianhuademo.application;

import reactivex.io.basicres.BaseApplication;
import reactivex.io.componentlib.router.ui.UIRouter;

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        UIRouter.getInstance().registerUI("app");
    }
}
