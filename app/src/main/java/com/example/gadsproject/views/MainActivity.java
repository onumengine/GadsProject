package com.example.gadsproject.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gadsproject.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submitButton);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void goToSubmitActivity(View view)
    {
        Intent submitActivityIntent = new Intent(this, SubmitActivity.class);
        startActivity(submitActivityIntent);
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
            switch (position)
            {
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return getText(R.string.learning_leaders);
                case 1:
                    return getText(R.string.skill_iq_leaders);
                default:
                    return null;
            }
        }
    }
}