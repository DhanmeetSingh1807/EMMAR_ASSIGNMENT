package com.example.emmar_assignment.ui.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emmar_assignment.R;
import com.example.emmar_assignment.databinding.SingleListItemBinding;
import com.example.emmar_assignment.ui.database.entity.User;

import java.util.ArrayList;
/**
 * Created by Dhanmeet on 11/08/23.
 */
public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.DeveloperViewHolder> {

    private ArrayList<User> userList;
    private OnItemClickListener listener;
    public RecylerViewAdapter(OnItemClickListener listener){
        this.listener  = listener;
    }

    @NonNull
    @Override
    public DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SingleListItemBinding mDeveloperListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.single_list_item, viewGroup, false);
        return new DeveloperViewHolder(mDeveloperListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperViewHolder mDeveloperViewHolder, int i) {
        User user = userList.get(i);
        mDeveloperViewHolder.mDeveloperListItemBinding.setUser(user);
        mDeveloperViewHolder.bind(user);
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        } else {
            return 0;
        }
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    class DeveloperViewHolder extends RecyclerView.ViewHolder {
        SingleListItemBinding mDeveloperListItemBinding;
        public DeveloperViewHolder(@NonNull SingleListItemBinding mDeveloperListItemBinding) {
            super(mDeveloperListItemBinding.getRoot());
            this.mDeveloperListItemBinding = mDeveloperListItemBinding;
        }

        public void bind(User user) {
            // click event for selected user details & passed to UI
            mDeveloperListItemBinding.layout.setOnClickListener(view -> listener.onItemClick(user));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User user);
    }
}