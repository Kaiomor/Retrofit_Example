package com.example.kaio_.entendotudo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.kaio_.entendotudo.Pojos.Posts;
import com.example.kaio_.entendotudo.R;

import java.util.List;


public class KaioAdapter extends RecyclerView.Adapter<KaioAdapter.ViewHolder> {

    List<Posts>listaDePosts;
    Context c;
    public KaioAdapter(Context c,List<Posts>list){

        this.c = c;
        this.listaDePosts = list;
    }

    @Override
    public KaioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(KaioAdapter.ViewHolder holder, int position) {

        Posts ps1 = listaDePosts.get(position);
        holder.bind(ps1.getUserId(),ps1.getId(),ps1.getTitle(),ps1.getBody());

    }

    @Override
    public int getItemCount() {
        return this.listaDePosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userId;
        TextView id;
        TextView title;
        TextView body;


        public ViewHolder(View itemView) {
            super(itemView);

            userId = (TextView) itemView.findViewById(R.id.userId);
            id = (TextView) itemView.findViewById(R.id.id);
            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.body);

        }

        public void bind(String userId, String id, String title, String body) {
            this.userId.setText(userId);
            this.id.setText(id);
            this.title.setText(title);
            this.body.setText(body);
        }
    }
}