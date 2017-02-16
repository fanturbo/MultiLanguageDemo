package pub.war.multilanguagedemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
/**
 *
 * 对话框辅助类
 */
public class DialogHelp {

    /***
     * 获取一个dialog
     *
     * @param context
     * @return
     */
    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }

    /***
     * 获取一个耗时等待对话框
     *
     * @param context
     * @param message
     * @return
     */
    public static ProgressDialog getWaitDialog(Context context, String message) {
        ProgressDialog waitDialog = new ProgressDialog(context);
        if (!TextUtils.isEmpty(message)) {
            waitDialog.setMessage(message);
        }
        return waitDialog;
    }

    /**
     * 获取一个确认对话框
     *
     * @param context
     * @param title
     * @param unConfirmText
     * @param confirmText
     * @param message
     * @param positiveClickListener
     * @param negativeClickListener
     * @return
     */
    public static AlertDialog.Builder getConfirmDialog(Context context, String title, String unConfirmText, String confirmText, String message, DialogInterface.OnClickListener positiveClickListener, DialogInterface.OnClickListener negativeClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(Html.fromHtml("<font color='#0c50a6'>" + title + "</font>"));
        }
        builder.setPositiveButton(confirmText, positiveClickListener);
        builder.setNegativeButton(unConfirmText, negativeClickListener);
        return builder;
    }

    /**
     * 获取一个单选对话框
     *
     * @param context
     * @param title
     * @param arrays
     * @param selectIndex
     * @param onClickListener
     * @return
     */
    public static AlertDialog.Builder getSingleChoiceDialog(Context context, String title, String[] arrays, int selectIndex, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setSingleChoiceItems(arrays, selectIndex, onClickListener);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setNegativeButton("确定", null);
        return builder;
    }

}