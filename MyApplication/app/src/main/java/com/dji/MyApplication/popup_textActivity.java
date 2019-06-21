package com.dji.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;


public class popup_textActivity extends Activity {
    String send_text;
    EditText editTextinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input);
        editTextinput = (EditText) findViewById(R.id.input_text);
    }

    public void mOnClose(View v){
        //데이터 전달하기
        send_text = editTextinput.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result",send_text);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
