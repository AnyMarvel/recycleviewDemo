package com.example.lijuntao.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
    Context context;
    List<Integer> items = new ArrayList<>();
    private recycleOnclick recycleOnclick = null;

    public MyRecycleViewAdapter(Context context, List<Integer> items) {
        this.context = context;
        this.items = items;

    }

    public interface recycleOnclick {
        void onClick(View view, int position);
    }


    public void setOnclickItemListener(recycleOnclick recycleOnclick) {
        this.recycleOnclick = recycleOnclick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(String.valueOf(items.get(position)));

        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                recycleOnclick.onClick(view, position);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recycleviewitem);

        }
    }
}
