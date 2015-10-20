package com.example.alphatabsample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AlphaTabActivity extends Activity {
    private AlphaTabSampleApplication app;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_tab_activity);

        app = (AlphaTabSampleApplication) getApplication();

        // アクションバーの取得
        actionBar = this.getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //actionBar.setTitle("TabTestApp");
        actionBar.setTitle("プロジェクト１");
        // タブに表示する文字の配列
        final String[] tabTitles = {"要求", "システム", "仕事", "チーム"};
        // タブリスナーのリスト
        final TabConnector[] tabConnectors = new TabConnector[4];
        tabConnectors[0] = new TabConnector<TabFirstFragment>(this, "tag1", TabFirstFragment.class);
        tabConnectors[1] = new TabConnector<TabSecondFragment>(this, "tag2", TabSecondFragment.class);
        tabConnectors[2] = new TabConnector<TabThirdFragment>(this, "tag3", TabThirdFragment.class);
        tabConnectors[3] = new TabConnector<TabFourthFragment>(this, "tag4", TabFourthFragment.class);
        for (int position = 0; position < tabTitles.length; position++) {
            String tabTitle = tabTitles[position];
            TabConnector tabConnector = tabConnectors[position];
            // アクションバーにタブを追加する
            actionBar.addTab(actionBar.newTab().setText(tabTitle).setTabListener(tabConnector));
        }
        int tabPosition = app.getAlphaTabPosition();
        actionBar.selectTab(actionBar.getTabAt(tabPosition));
    }

    @Override
    public void onPause() {
        super.onPause();

        app.setAlphaTabPosition(actionBar.getSelectedTab().getPosition());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alpha_tab_menu, menu);
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

        if (id == R.id.action_logout) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            // アラートダイアログのタイトルを設定します
            alertDialogBuilder.setTitle("ログアウト");
            // アラートダイアログのメッセージを設定します
            alertDialogBuilder.setMessage("ログアウトしますか？");
            // アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
            alertDialogBuilder.setPositiveButton("No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            // アラートダイアログの中立ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
            alertDialogBuilder.setNeutralButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            // アラートダイアログのキャンセルが可能かどうかを設定します
            alertDialogBuilder.setCancelable(true);
            AlertDialog alertDialog = alertDialogBuilder.create();
            // アラートダイアログを表示します
            alertDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
