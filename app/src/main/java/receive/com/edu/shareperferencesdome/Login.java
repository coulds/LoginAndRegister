package receive.com.edu.shareperferencesdome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    private Button button,button1;
    private EditText ed_mima,ed_zhanghao;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        ed_zhanghao = findViewById(R.id.ed_zhanghao);
        ed_mima = findViewById(R.id.ed_mima);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_zhanghao.getText().toString();
                String password = ed_mima.getText().toString();

                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)){
                    ArrayList<user> data= SQlite.getAllData();
                    boolean match = false;
                    for (int i=0;i<data.size();i++){
                        user user = data.get(i);
                        if (name.equals(user.getName())&&password.equals(user.getPassword())){
                            match =true;

                        }else{
                            match = false;
                            //Toast.makeText(Login.this, "用户不存在", Toast.LENGTH_SHORT).show();

                        }
                    }
                    if (match=true){
                        Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(Login.this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Login.this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Login.this,Register.class);
                startActivity(intent);

            }
        });

    }
}
