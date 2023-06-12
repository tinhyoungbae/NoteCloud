package com.example.note.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.note.Model.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> userList;

    public void UserAdapter(){

    }

    public UserAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup parent) {
        return null;
    }
}
