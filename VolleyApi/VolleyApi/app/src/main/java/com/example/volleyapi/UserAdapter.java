package com.example.volleyapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    User userData;
    public UserAdapter(Context context,User userData) {
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.item_user_layout,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
      User user = userData;
      holder.userTextView.setText(user.getLogin());
        Glide.with(holder.userImage.getContext()).load(user.getAvatarUrl()).circleCrop().into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView userImage;
        TextView userTextView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.imageUser);
            userTextView = itemView.findViewById(R.id.userTextView);
        }
    }
}
