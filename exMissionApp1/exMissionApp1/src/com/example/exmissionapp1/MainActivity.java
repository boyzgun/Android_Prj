package com.example.exmissionapp1;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //1)어플을 실행할때 토스트 메세지가 뜨도록 구현합니다
        showToastMsg();
        
        //1)+a Toast Test Button
        findViewById(R.id.btnTest).setOnClickListener(btnClick);
        
        //2)처음화면(MainActivity)에는 TextView와 Button이 하나씩 있으며 위치는 자유입니다 -> activity_main.xml
        //3)버튼을 누르면 알림이 뜨며 그때 예, 아니오를 선택할수 있습니다
        findViewById(R.id.button1).setOnClickListener(btnClick);
        
    }

    //1)어플을 실행할때 토스트 메세지가 뜨도록 구현합니다
    private void showToastMsg() {
    	Toast.makeText(MainActivity.this, getString(R.string.msg_onLoadApp), Toast.LENGTH_SHORT).show();
    }
    
    //1)+a Button Click Listener
    public Button.OnClickListener btnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			
			switch(v.getId()) {
			case R.id.btnTest:
				showToastMsg();
				break;
			case R.id.button1:
				popupAlert();
				break;
			default:
				break;
			}
		}
    	
    };
    
    private void popupAlert() {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);
    	
    	alert.setTitle(R.string.alert_title);
    	alert.setIcon(R.drawable.ic_launcher);
    	alert.setMessage(R.string.alert_text);
    	
    	alert.setPositiveButton(R.string.alert_pos_btn, dialogClick);
    	alert.setNegativeButton(R.string.alert_neg_btn, dialogClick);
    	
    	alert.show();
    }
    
    private DialogInterface.OnClickListener dialogClick = new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {

		    //4)예를 누를경우 다른 액티비티로 이동합니다
		    //5)다른 액티비티에는 EditView와 그아래 버튼이 있습니다 - activity_another.xml
			switch(which) {
			case DialogInterface.BUTTON_POSITIVE:
				Intent nxIntent = new Intent(MainActivity.this, AnotherActivity.class);
				startActivity(nxIntent);
				break;
			case DialogInterface.BUTTON_NEGATIVE:
				
				break;
			}
			dialog.dismiss();
		}
	};
    
    //6)EditView에는 hint속성이 지정되어야 합니다
    //7)버튼을 누르면 입력한 글자를 토스트 메세지로 띄워줍니다
    //7+)할수 있다면 버튼을 누를때 입력한 글자를 초기화 해봅시다
    //8)TextView의 글자색은 초록색이고 굵은글자 입니다
    
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
