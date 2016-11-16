package com.chensd.byeburgertest;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BadgeItem mHomeBadgeItem;
    private BadgeItem mMusiBadgeItem;
    private BottomNavigationBar bottomNavigationBar;
    private int lastPosition;
    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private MusicFragment mMusicFragment;
    private BooksFragment mBooksFragment;
    private LoveFragment mLoveFragment;
    private int mHomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        mHomeFragment = HomeFragment.newInstance("home");
        fragmentTransaction.add(R.id.tab_container, mHomeFragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        mHomeBadgeItem = new BadgeItem()
                .setBorderWidth(2)
                .setBackgroundColor(Color.RED)
                .setText("")
                .setHideOnSelect(false);

        mMusiBadgeItem = new BadgeItem()
                .setBorderWidth(2)
                .setBackgroundColor(Color.RED)
                .setText("99+")
                .setHideOnSelect(true);


        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigate);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home, "home").
                setActiveColorResource(R.color.colorAccent).setBadgeItem(mHomeBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_books, "books").setActiveColor(Color.GRAY))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music, "music").
                        setActiveColorResource(R.color.colorPrimary).setBadgeItem(mMusiBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_favorite, "favorite").setActiveColor(Color.BLUE))
                .setFirstSelectedPosition(lastPosition)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

        mHomeBadgeItem.hide();
    }


    @Override
    public void onTabSelected(int position) {
        lastPosition = position;

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);

        switch(position){
            case 0:
                if(mHomeFragment == null){
                    mHomeFragment = HomeFragment.newInstance("home");
                    fragmentTransaction.add(R.id.tab_container, mHomeFragment);
                }else{
                    fragmentTransaction.show(mHomeFragment);
                }
                addMsg();
                break;
            case 1:
                if(mBooksFragment == null){
                    mBooksFragment = BooksFragment.newInstance("books");
                    fragmentTransaction.add(R.id.tab_container, mBooksFragment);
                }else{
                    fragmentTransaction.show(mBooksFragment);
                }
                break;
            case 2:
                if(mMusicFragment == null){
                    mMusicFragment = MusicFragment.newInstance("music");
                    fragmentTransaction.add(R.id.tab_container, mMusicFragment);
                }else{
                    fragmentTransaction.show(mMusicFragment);
                }
                break;
            case 3:
                if(mLoveFragment == null){
                    mLoveFragment = LoveFragment.newInstance("favorite");
                    fragmentTransaction.add(R.id.tab_container, mLoveFragment);
                }else{
                    fragmentTransaction.show(mLoveFragment);
                }
                break;
            default:
                break;
        }

        fragmentTransaction.commit();
    }

    private void addMsg() {
        mHomeMsg++;
        mHomeBadgeItem.setText(""+mHomeMsg);
        mHomeBadgeItem.show();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if(mHomeFragment != null){
            fragmentTransaction.hide(mHomeFragment);
        }
        if (mMusicFragment != null){
            fragmentTransaction.hide(mMusicFragment);
        }
        if(mBooksFragment != null){
            fragmentTransaction.hide(mBooksFragment);
        }
        if(mLoveFragment != null){
            fragmentTransaction.hide(mLoveFragment);
        }
    }


    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
