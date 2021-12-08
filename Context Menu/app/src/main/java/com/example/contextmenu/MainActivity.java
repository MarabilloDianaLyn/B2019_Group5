package com.example.contextmenu;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button m_btn = (Button) findViewById(R.id.buttonn);
        registerForContextMenu(m_btn);
    }


    @Override
    public void onCreateContextMenu(ContextMenu m_menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(m_menu, v, menuInfo);
        m_menu.setHeaderTitle("Context Menu");
        m_menu.add(0, v.getId(), 0, "Create Group");
        m_menu.add(0, v.getId(), 0, "Settings");
        m_menu.add(0, v.getId(), 0, "Request");
        m_menu.add(0, v.getId(), 0, "LogOut");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;

    }
}