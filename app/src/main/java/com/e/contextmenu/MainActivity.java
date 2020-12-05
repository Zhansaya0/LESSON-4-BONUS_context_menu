package com.e.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] course_lessons = {"Videolesson 1", "Videolesson 2", "Videolesson 3", "Videolesson 4", "Videolesson 5", "Videolesson 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, course_lessons);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contextmenu_view:
                Toast.makeText(this, "View selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextmenu_done:
                Toast.makeText(this, "Done selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextmenu_share:
                Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextmenu_download:
                Toast.makeText(this, "Download selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextmenu_questions:
                Toast.makeText(this, "Questions selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextmenu_update:
                Toast.makeText(this, "Update selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            switch (item.getItemId()) {
                case R.id.menu_extra:
                    Toast.makeText(this, "Extra menu clicked", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;
        }
    }

