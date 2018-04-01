package myapplication.jiyun.com.yue_kao;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static myapplication.jiyun.com.yue_kao.R.id.recy;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private int aaa;
    private List<Student> student2;
    private Button button;
    private Handler handler=new Handler(){



        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                String str= (String) msg.obj;
                Gson gson = new Gson();
                Feng feng = gson.fromJson(str, Feng.class);
                Feng.StudentsBean students = feng.getStudents();
                List<Feng.StudentsBean.StudentBean> student = students.getStudent();
                for (int i = 0; i < student.size(); i++) {
                    student1=new Student(student.get(i).getName(),student.get(i).getContent(),student.get(i).getImg());
                    studentDao.insert(student1);
                }
                student2 = studentDao.loadAll();
                myAdapter=new MyAdapter(student2,Main2Activity.this);
                recyclerView.setAdapter(myAdapter);
                myAdapter.setOnClick(new MyAdapter.OnClick() {
                    @Override
                    public void setOnClick(View view, final int position) {
                        new AlertDialog.Builder(Main2Activity.this)
                                .setTitle("提示")
                                .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        student2.remove(position);
                                        myAdapter.notifyDataSetChanged();
                                    }
                                })
                                .setNegativeButton("修改", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        aaa=position;
                                        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                                        startActivityForResult(intent,10);
                                    }
                                })
                                .create().show();
                    }
                });
            }
        }
    };
    private StudentDao studentDao;
    private Student student1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button= (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
        initView();
        initData();
        initDaTa();
    }


    private void initDaTa() {
        DaoMaster.DevOpenHelper bbb = new DaoMaster.DevOpenHelper(this, "bbb", null);
        DaoMaster daoMaster = new DaoMaster(bbb.getReadableDb());
        studentDao = daoMaster.newSession().getStudentDao();
    }


    private void initData() {
        OkHttpClient ok=new OkHttpClient.Builder().build();
        String string="http://169.254.116.190:8080/test/student1.txt";
        Request build = new Request.Builder().url(string).build();
        ok.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string=response.body().string();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage(1, string);
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }

    private void initView() {
        recyclerView= (RecyclerView) findViewById(recy);
        LinearLayoutManager lin=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lin);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10&&resultCode==10){
             Student stu= (Student) data.getSerializableExtra("a");
            Student student = new Student((long) aaa, stu.getName(), stu.getSex());
            studentDao.update(student);
            student2.set(aaa,stu);
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
        startActivityForResult(intent,10);
    }
}
