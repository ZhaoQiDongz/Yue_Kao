package myapplication.jiyun.com.yue_kao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28 0028.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> implements View.OnClickListener{
    private List<Student> list;
    private Context context;
    private OnClick onClick;

    public MyAdapter(List<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Student student = list.get(position);
        Picasso.with(context).load(student.getImage()).into(holder.imageView);
        holder.textView2.setText(student.getName());
        holder.textView3.setText(student.getSex());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface OnClick{
        void setOnClick(View view,int position);
    }
    public void setOnClick(OnClick onClick){
        this.onClick=onClick;
    }
    @Override
    public void onClick(View v) {
        if (onClick!=null){
            onClick.setOnClick(v, (Integer) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView2,textView3;
        public Holder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.Image);
            textView2=itemView.findViewById(R.id.Text2);
            textView3=itemView.findViewById(R.id.Text3);
        }
    }
}
