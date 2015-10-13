package com.algo.ygntrain.ui.activity;

import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.algo.ygntrain.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button btn_showlist;
    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_showlist = (Button)findViewById(R.id.btn_showlist);
        btn_showlist.setOnClickListener(this);

        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }



    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,StationListActivity.class));
        finish();
    }
}
