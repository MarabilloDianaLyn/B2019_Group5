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

        Button m_btn = (Button) findViewById(R.id.btn_Show);
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
                case R.id.itemsearch:

                    return true;

                case R.id.itemupload:

                    return true;

                case R.id.copy_item:

                    return true;

                case R.id.print_item:

                    return true;

                case R.id.share_item:

                    return true;

                case R.id.bookmark_item:

                    return true;

                default:
                    return false;
            }
        }
}