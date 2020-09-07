package com.example.gadsproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gadsproject.R;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter
    {
        public ViewPagerAdapter(@NonNull FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            switch (position) {
                case 0:
                    return new LearningLeadersFragment();
                case 1:
                    return new IQLeadersFragment();
            }
            return null;
        }

        @Override
        public int getCount()
        {
            return 2;
        }
    }
}