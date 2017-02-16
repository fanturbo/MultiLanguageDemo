package pub.war.multilanguagedemo;

import android.app.Application;
import android.content.Context;

import java.util.Locale;

/**
 * Created by snail on 17/2/16.
 */
public class App extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //设置语言  因为每次app完全退出后重新启动,Local并不会被保存
        String localLanguageType = SPUtils.getLocalLanguageType(mContext);
        if ("中文".equals(localLanguageType)) {
            LanguageUtil.changeLanguageType(mContext, Locale.SIMPLIFIED_CHINESE);
        } else {
            LanguageUtil.changeLanguageType(mContext, Locale.ENGLISH);
        }

    }

    public static Context getContext() {
        return mContext;
    }
}
