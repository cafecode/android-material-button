package me.cafecode.android.material.button.sample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private ListView mListView;
    private String[] mMenuTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list);

        mMenuTitles = new String[]{"Raised button", "Floating action button", "Flat button", "Other button"};

        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mMenuTitles));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();

                switch (position) {
                    case 0:
                        intent.setClass(MainActivity.this, RaisedButtonActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, FloatingActionButtonActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, FlatButtonActivity.class);
                        break;
                    default:
                        intent.setClass(MainActivity.this, OtherButtonActivity.class);
                        break;
                }

                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
