package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhiyicx.testdagger2.R;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/22
 * @Contact 605626708@qq.com
 */

public class DiffRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.only_recycler);
        mRecyclerView = findViewById(R.id.recycler);
        MyView btn = findViewById(R.id.btn);

        MyViewModelFactory myViewModelFactory = new MyViewModelFactory(new UserDao());
        MyViewModel myViewModel = ViewModelProviders.of(this, myViewModelFactory).get(MyViewModel.class);
        UserAdapter userAdapter = new UserAdapter();
        myViewModel.usersList.observe(this, userAdapter::submitList);
        mRecyclerView.setAdapter(userAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getLifecycle().addObserver(myViewModel);
    }
}

/**
 * userAdapter
 */
class UserAdapter extends ListAdapter<User, UserViewHolder> {

    protected UserAdapter() {
        super(User.CALLBACK);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_dropdown_item_1line, null));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }
}

/**
 * ItemViewHolder
 */
class UserViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public UserViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(android.R.id.text1);
    }

    public void bindTo(User user){
        mTextView.setMinHeight(180);
        mTextView.setText(user.getName());
    }
}