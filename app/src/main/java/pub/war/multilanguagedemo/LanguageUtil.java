package pub.war.multilanguagedemo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

import static java.security.AccessController.getContext;

/**
 * Created by turbo on 2017/2/16.
 */

public class LanguageUtil {
    public static void changeLanguageType(Context context, Locale localelanguage) {
        Log.i("=======", "context = " + context);
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        // 应用用户选择语言
        config.locale = localelanguage;
        resources.updateConfiguration(config, dm);
    }

    public static Locale getLanguageType(Context context) {
        Log.i("=======", "context = " + context);
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        // 应用用户选择语言
        return config.locale;
    }
}
