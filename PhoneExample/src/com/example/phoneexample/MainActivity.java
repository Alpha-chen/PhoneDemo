package com.example.phoneexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** 显示输入的数字，并显示结果 */
	private TextView mResultTV;
	private Button mOneBtn, mTwoBtn, mThreeBtn, mSixBtn, mSevenBtn, mEightBtn,
			mNineBtn, mFourBtn, mFiveBtn, mZeroBtn, mXingBtn, mBodaBtn,
			mDeleteBtn, mJingBtn;
	/** 为所有的按钮注册监听器 */
	ButtonListener buttonListener = new ButtonListener();

	/** 存储结果 */
	static String result = "";
	/** 对字符串进行追加 */
	static StringBuilder builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/** 没初始化一次StringBuilder原来的就会被系统回收 */
		builder = new StringBuilder();

		initView();
	}

	private void initView() {
		mResultTV = (TextView) findViewById(R.id.TV_result_main);
		mOneBtn = (Button) findViewById(R.id.BTN_one_main);
		mTwoBtn = (Button) findViewById(R.id.BTN_two_main);
		mThreeBtn = (Button) findViewById(R.id.BTN_three_main);
		mFourBtn = (Button) findViewById(R.id.BTN_four_main);
		mFiveBtn = (Button) findViewById(R.id.BTN_five_main);
		mSixBtn = (Button) findViewById(R.id.BTN_six_main);
		mSevenBtn = (Button) findViewById(R.id.BTN_seven_main);
		mEightBtn = (Button) findViewById(R.id.BTN_eight_main);
		mNineBtn = (Button) findViewById(R.id.BTN_nine_main);
		mXingBtn = (Button) findViewById(R.id.BTN_xing_main);
		mZeroBtn = (Button) findViewById(R.id.BTN_zero_main);
		mJingBtn = (Button) findViewById(R.id.BTN_jing_main);
		mDeleteBtn = (Button) findViewById(R.id.BTN_delete_main);
		//

		mBodaBtn = (Button) findViewById(R.id.BTN_deng_main);
		mDeleteBtn.setOnClickListener(buttonListener);
		mJingBtn.setOnClickListener(buttonListener);
		mOneBtn.setOnClickListener(buttonListener);
		mTwoBtn.setOnClickListener(buttonListener);
		mThreeBtn.setOnClickListener(buttonListener);
		mFourBtn.setOnClickListener(buttonListener);
		mFiveBtn.setOnClickListener(buttonListener);
		mSixBtn.setOnClickListener(buttonListener);
		mSevenBtn.setOnClickListener(buttonListener);
		mEightBtn.setOnClickListener(buttonListener);
		mNineBtn.setOnClickListener(buttonListener);
		mZeroBtn.setOnClickListener(buttonListener);

		mXingBtn.setOnClickListener(buttonListener);

		mBodaBtn.setOnClickListener(buttonListener);
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.BTN_zero_main:
				/** 每次点击数的时候追加 */
				result = builder.append("0").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_one_main:
				result = builder.append("1").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_two_main:
				result = builder.append("2").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_three_main:
				result = builder.append("3").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_four_main:
				result = builder.append("4").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_five_main:
				result = builder.append("5").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_six_main:
				result = builder.append("6").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_seven_main:
				result = builder.append("7").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_eight_main:
				result = builder.append("8").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_nine_main:
				result = builder.append("9").toString();
				mResultTV.setText(result);
				break;
			// 删除
			case R.id.BTN_delete_main:
				if (result.length() <= 0) {
					mResultTV.setText(result);
				} else {
					result = builder.deleteCharAt(result.length() - 1)
							.toString();
					mResultTV.setText(result);
				}
				break;
			case R.id.BTN_jing_main:
				result = builder.append("#").toString();
				mResultTV.setText(result);
				break;
			case R.id.BTN_xing_main:

				result = builder.append("*").toString();
				mResultTV.setText(result);
				break;

			// 点击拨打电话
			case R.id.BTN_deng_main:
				if (result.length() == 0) {
					Toast.makeText(getApplicationContext(), "请输入拨打的嗲话",
							Toast.LENGTH_SHORT).show();
				} else {
					mResultTV.setText(result);
					Intent phoneIntent = new Intent(
							"android.intent.action.CALL", Uri.parse("tel:"
									+ result));
					// 启动
					startActivity(phoneIntent);
				}

				break;

			default:
				break;
			}

		}
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
}
