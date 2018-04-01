package myapplication.jiyun.com.yue_kao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit1;
    private EditText edit2;
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        button1 = (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = getIntent();
                String string = edit1.getText().toString();
                String string1 = edit2.getText().toString();
                Student student = new Student(string, string1);
                intent.putExtra("a",student);
                setResult(10,intent);
                finish();
                break;
            case R.id.button2:
                Intent intent1 = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent1);

        }
    }

    private void submit() {
        // validate
        String edit1String = edit1.getText().toString().trim();
        if (TextUtils.isEmpty(edit1String)) {
            Toast.makeText(this, "edit1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String edit2String = edit2.getText().toString().trim();
        if (TextUtils.isEmpty(edit2String)) {
            Toast.makeText(this, "edit2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
