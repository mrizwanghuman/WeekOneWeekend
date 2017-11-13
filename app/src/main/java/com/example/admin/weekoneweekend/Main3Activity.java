package com.example.admin.weekoneweekend;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main3Activity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ListView listView;
    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout =findViewById(R.id.drawerlayout);
        listView = findViewById(R.id.listview);
        mToggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close);

        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigation);

        addDrawerItems();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                OnDrawItemSelected(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addDrawerItems() {
        String[] osArray = { "Home", "Audio Songs", "Videos", "Search Google" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        listView.setAdapter(mAdapter);
    }

    public void OnDrawItemSelected(int postion){

        switch (postion){
            case 0:{
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case 1 : {
                Intent intent = new Intent(Main3Activity.this, Main3Activity.class);
                startActivity(intent);
                finish();
                break;
            }
            case 2:{
                Intent intent = new Intent(Main3Activity.this, YouTube.class);
                startActivity(intent);
                finish();
                break;

            }
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }
}
