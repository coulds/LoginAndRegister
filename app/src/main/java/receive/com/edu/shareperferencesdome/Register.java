package receive.com.edu.shareperferencesdome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity{
    public SharedPreferences preferences;

    private  Button button;
    private Button button1;
    private EditText ed_username;
    private  EditText ed_password;
    private EditText ed_rpassword;
//    EditText ed_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        SQlite sQlite = new SQlite(this);
        button=findViewById(R.id.btn_register);
        button1=findViewById(R.id.btn_login);
        ed_rpassword=findViewById(R.id.ed_rpassword);
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Register.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ed_username.getText().toString().trim();
                String password = ed_password.getText().toString().trim();
                String remenpassword = ed_rpassword.getText().toString().trim();
                if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(remenpassword)){
                    if (password.equals(remenpassword)){
                        SQlite.add(username,password);
                        Intent intent1 = new Intent(Register.this,Login.class);
                        startActivity(intent1);
                        Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();

                    }else {

                        Toast.makeText(Register.this,"注册失败,两次密码不同",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Register.this,"注册失败,信息不完完整",Toast.LENGTH_SHORT).show();
                }

            }
        });
//        ed_okpasswrod = findViewById(R.id.ed_okpasswrod);

//        if (ed_username.equals("")||ed_password.equals("")||ed_phone.equals("")){
//            Toast.makeText(Register.this,"账号和密码不能为空",Toast.LENGTH_SHORT).show();
//            return;
//        }else if (!(ed_okpasswrod.getText().toString().equals(ed_password.getText().toString()))){
//            Toast.makeText(Register.this,"两次的密码不一样",Toast.LENGTH_SHORT).show();
//            return;
//        }

//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//
//                preferences = getSharedPreferences("data",MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("username",ed_username.getText().toString());
//                editor.putString("password",ed_password.getText().toString());
//                editor.commit();
//                Toast.makeText(Register.this,"注册成功,你的信息为 ",Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
    }
}
