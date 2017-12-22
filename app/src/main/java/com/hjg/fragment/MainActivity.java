package com.hjg.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fl_container;
    private TextView tv_news, tv_notice;
    private FragmentManager fragmentManager;
    private FragmentNews fragmentNews;
    private FragmentNotice fragmentNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_container = (FrameLayout) findViewById(R.id.fl_container);
        tv_news = (TextView) findViewById(R.id.tv_news);
        tv_notice = (TextView) findViewById(R.id.tv_notice);
        tv_news.setOnClickListener(this);
        tv_notice.setOnClickListener(this);

        initFragmentNews();
    }

    private void initFragmentNews() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentNews == null) {
            fragmentNews = new FragmentNews();
            transaction.add(R.id.fl_container, fragmentNews);
        }
        transaction.show(fragmentNews);
        transaction.commit();
    }

    private void initFragmentNotice() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentNotice == null) {
            fragmentNotice = new FragmentNotice();
            transaction.add(R.id.fl_container, fragmentNotice);
        }

        transaction.show(fragmentNotice);
        transaction.commit();
    }

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (fragmentNews != null) {
            transaction.hide(fragmentNews);
        }
        if (fragmentNotice != null) {
            transaction.hide(fragmentNotice);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_news:
                initFragmentNews();
                break;
            case R.id.tv_notice:
                initFragmentNotice();
                break;
        }
    }
}
