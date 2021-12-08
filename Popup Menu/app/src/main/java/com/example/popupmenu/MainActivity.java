package com.example.popupmenu;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button m_btn = (Button) findViewById(R.id.button4);
        m_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu m_popup = new PopupMenu(MainActivity.this, v);
                m_popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) MainActivity.this);

                m_popup.inflate(R.menu.popupmenu);
                m_popup.show();
            }
        });
    }

        public boolean onMenuItemClick (MenuItem item){
            Toast.makeText(this, "Selected Item: " + item.getTitle(),
                    Toast.LENGTH_SHORT).show();
            switch (item.getItemId()) {
                case R.id.itemprofile:

                    return true;

                case R.id.itemcreategroup:

                    return true;

                case R.id.itemsetting:

                    return true;

                case R.id.itemhelp:

                    return true;

                case R.id.itemrequest:

                    return true;

                case R.id.itemlogout:

                    return true;

                default:
                    return false;
            }
        }
}