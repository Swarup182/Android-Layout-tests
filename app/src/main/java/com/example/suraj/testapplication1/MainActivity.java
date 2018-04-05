package com.example.suraj.testapplication1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mainContainer;

    private TextView itemfirst;
    private TextView itemsecond;
    private TextView itemthird;
    private TextView itemfourth;
    private TextView itemfifth;

    private TextView selectedItem;

    private Button redButton;
    private Button blueButton;
    private Button greenButton;

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContainer = findViewById(R.id.main_container);

        itemfirst = findViewById(R.id.item1);
        itemsecond = findViewById(R.id.item2);
        itemthird = findViewById(R.id.item3);
        itemfourth = findViewById(R.id.item4);
        itemfifth = findViewById(R.id.item5);

        selectedItem = findViewById(R.id.selectedItem);

        redButton = findViewById(R.id.red_btn);
        blueButton = findViewById(R.id.blue_btn);
        greenButton = findViewById(R.id.green_btn);

        itemfirst.setOnClickListener(this);
        itemsecond.setOnClickListener(this);
        itemthird.setOnClickListener(this);
        itemfourth.setOnClickListener(this);
        itemfifth.setOnClickListener(this);

        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == itemfirst) {
            selectedItem.setText("ItemFirst");
        }
        if (view == itemsecond) {
            selectedItem.setText("ItemSecond");
        }
        if (view == itemthird) {
            selectedItem.setText("ItemThird");
        }
        if (view == itemfourth) {
            selectedItem.setText("Item Fourth");
        }
        if (view == itemfifth) {
            selectedItem.setText("ItemFifth");
        }

        if (view == redButton) {
            mainContainer.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if (view == greenButton) {
            mainContainer.setBackgroundColor(getResources().getColor(R.color.green));
        }
        if (view == blueButton) {
            mainContainer.setBackgroundColor(getResources().getColor(R.color.blue));
        }


    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FragmentOne.newInstance("0", "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FragmentSecond.newInstance("1", "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return FragmentThird.newInstance("2", "Page # 3");
                case 3:
                    return FragmentFourth.newInstance("3", "Page # 4");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}
