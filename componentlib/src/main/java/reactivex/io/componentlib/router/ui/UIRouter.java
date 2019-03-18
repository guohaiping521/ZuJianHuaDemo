package reactivex.io.componentlib.router.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import reactivex.io.router_annotation.RouteUtils;

public class UIRouter implements IUIRouter{

    private static Map<String, IComponentRouter> routerInstanceCache = new HashMap<>();
    private List<IComponentRouter> uiRouters = new ArrayList<>();
    private HashMap<IComponentRouter, Integer> priorities = new HashMap<>();

    private static volatile UIRouter instance;

    private UIRouter() {
    }

    public static UIRouter getInstance() {
        if (instance == null) {
            synchronized (UIRouter.class) {
                if (instance == null) {
                    instance = new UIRouter();
                }
            }
        }
        return instance;
    }

    @Override
    public void registerUI(IComponentRouter router, int priority) {
        if (priorities.containsKey(router) && priority == priorities.get(router)) {
            return;
        }
        removeOldUIRouter(router);
        int i = 0;
        for (IComponentRouter temp : uiRouters) {
            Integer tp = priorities.get(temp);
            if (tp == null || tp <= priority) {
                break;
            }
            i++;
        }
        uiRouters.add(i, router);
        priorities.put(router, priority);
    }

    private void removeOldUIRouter(IComponentRouter router) {
        Iterator<IComponentRouter> iterator = uiRouters.iterator();
        while (iterator.hasNext()) {
            IComponentRouter tmp = iterator.next();
            if (tmp == router) {
                iterator.remove();
                priorities.remove(tmp);
            }
        }
    }

    @Override
    public void registerUI(IComponentRouter router) {
        registerUI(router, PRIORITY_NORMAL);
    }

    @Override
    public void registerUI(String host) {
        IComponentRouter router = fetch(host);
        if (router != null) {
            registerUI(router, PRIORITY_NORMAL);
        }
    }

    private IComponentRouter fetch(@NonNull String host) {

        String path = RouteUtils.genHostUIRouterClass(host);

        if (routerInstanceCache.containsKey(path))
            return routerInstanceCache.get(path);

        try {
            Class cla = Class.forName(path);
            IComponentRouter instance = (IComponentRouter) cla.newInstance();
            routerInstanceCache.put(path, instance);
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void registerUI(String host, int priority) {

    }

    @Override
    public void unregisterUI(IComponentRouter router) {

    }

    @Override
    public void unregisterUI(String host) {

    }

    @Override
    public boolean openUri(Context context, String url, Bundle bundle) {
        return false;
    }

    @Override
    public boolean openUri(Context context, Uri uri, Bundle bundle) {
        return false;
    }

    @Override
    public boolean openUri(Context context, String url, Bundle bundle, Integer requestCode) {
        return false;
    }

    @Override
    public boolean openUri(Context context, Uri uri, Bundle bundle, Integer requestCode) {
        return false;
    }

    @Override
    public boolean verifyUri(Uri uri) {
        return false;
    }
}
