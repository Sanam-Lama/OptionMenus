package com.example.optionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button for context menu
        button = (Button)findViewById(R.id.contextButton);
        registerForContextMenu(button);

        // button for popup menu
        button1 = (Button)findViewById(R.id.popupButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }

    /* for Option Menu
     * Option Menu is a primary collection of menu items for an activity and it is useful to implement
     * actions that have a global impact on the app, such as Settings, Search, etc
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         MenuInflater menuInflater = getMenuInflater();
         menuInflater.inflate(R.menu.option_menu, menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected item: " + item.getTitle(),Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.mail:
                return true;
            case R.id.share:
                return true;
            case R.id.upload:
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    /* For Context Menu
     * Context menu is like a floating menu and that appears when the user performs a long press */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Upload");
        menu.add(0, v.getId(), 0, "Search");
        menu.add(0, v.getId(), 0, "Share");
        menu.add(0, v.getId(), 0, "Bookmark");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected item: " + item.getTitle(),Toast.LENGTH_SHORT).show();
        return true;
    }

    /* for popup menu
     * Popup menu displays a list of items in a modal popup window that is anchored to the view */

    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.show();
    }

    public boolean onMenuItemClicked(MenuItem item) {

        // this Toast is not working
      //  Toast.makeText(this, "Selected item: " + item.getTitle(),Toast.LENGTH_SHORT).show();
       // Log.e("Selected item: " + item.getItemId(), "clicked");
        switch (item.getItemId()) {
            case R.id.search:
                return true;
            case R.id.upload:
                return true;
            case R.id.share:
                return true;
            case R.id.mail:
                return true;
                default:
                    return false;
        }
    }
}
