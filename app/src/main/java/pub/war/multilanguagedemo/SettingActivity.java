package pub.war.multilanguagedemo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class SettingActivity extends AppCompatActivity {

    private Context mContext;
    private TextView mTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setText(mContext.getString(R.string.test) + "---"+LanguageUtil.getLanguageType(mContext));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeLanguage(View view) {
        int index;
        String localLanguageType = SPUtils.getLocalLanguageType(mContext);
        if ("中文".equals(localLanguageType)) {
            index = 0;
        } else {
            index = 1;
        }
        String[] array = {"中文", "EngLish"};
        String settingStr = getResources().getString(R.string.action_settings);
        DialogHelp.getSingleChoiceDialog(mContext, settingStr, array, index, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("======", "i = " + i);
                if (i == 0) {
                    LanguageUtil.changeLanguageType(mContext, Locale.SIMPLIFIED_CHINESE);
                } else {
                    LanguageUtil.changeLanguageType(mContext, Locale.ENGLISH);
                }
                SPUtils.setLocalLanguageType(mContext, i == 0 ? "中文" : "EngLish");
                finish();
            }
        }).show();

    }
}
