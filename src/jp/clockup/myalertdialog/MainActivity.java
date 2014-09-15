package jp.clockup.myalertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView)findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void buttonMethod(View myButton) {
    	// 選択肢クリックイベント受け取り
    	DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
    			String result = "？";
    			switch(which){
    			case DialogInterface.BUTTON_POSITIVE: result = "ハイ"; break;
    			case DialogInterface.BUTTON_NEUTRAL:  result = "ドッチデモイイ"; break;
    			case DialogInterface.BUTTON_NEGATIVE: result = "イイエ"; break;
    			}
    			mTextView.setText(result);
    		}

		};
    	// キャンセル時
		DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {				
				mTextView.setText("キャンセルされました");
			}
		};
		// 閉じたとき
		DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface dialog) {
				Log.d("myalertdialog", "dismissed");
			}
		};
		// ダイアログ作成
		Dialog dialog =
				new AlertDialog.Builder(this)
				.setTitle("たいとる")
				.setMessage("えらんでください")
				.setPositiveButton("はい", onClickListener)
				.setNeutralButton("どっちでもいい", onClickListener)
				.setNegativeButton("いいえ", onClickListener)
				.setCancelable(true)
				.setOnCancelListener(onCancelListener)
				.setOnDismissListener(onDismissListener) // Required API level >= 17
				.create();
		// 表示
		dialog.show();
    }
}
