package com.xiaoming.giftspeak.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoming.giftspeak.R;

/**
 * Created by my on 2016/6/30.
 */
public class LoginActivity extends AppCompatActivity {

    private TextView tv_changeLogin;
    private TextView tv_getCode;
    private EditText et_password;
    private ImageView iv_password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        tv_changeLogin = (TextView) findViewById(R.id.tv_change_login_way);
        tv_getCode = (TextView) findViewById(R.id.tv_get_code);
        et_password = (EditText) findViewById(R.id.et_password);
        iv_password= (ImageView) findViewById(R.id.iv_password);
        tv_changeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_getCode.isShown()) {
                    tv_changeLogin.setText("使用密码登录");
                    tv_getCode.setVisibility(v.VISIBLE);
                    et_password.setText("短信验证码");
                    iv_password.setImageResource(R.drawable.icon_login_message);
                }else{
                    tv_changeLogin.setText("使用验证码登录");
                    tv_getCode.setVisibility(v.GONE);
                    et_password.setText("密码");
                    iv_password.setImageResource(R.drawable.icon_password);
                }
            }
        });
    }

    public void onClose(View view) {
        LoginActivity.this.finish();
    }

}
