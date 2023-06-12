package com.example.note.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.note.Fragment.FolderFragment;
import com.example.note.Fragment.NoteFragment;
import com.example.note.Fragment.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    //Khai báo các Fragment
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new NoteFragment();
            case 1:
                return new FolderFragment();
            default:
                return new UserFragment();
        }
    }

    //Số lượng Fragment
    public int getCount(){
        return 3;
    }
}
