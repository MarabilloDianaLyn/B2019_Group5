package com.example.toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn_Show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater m_inflater = getLayoutInflater();
                View m_layout = m_inflater.inflate(R.layout.for_customtoast, (ViewGroup) findViewById(R.id.layoutctoast));
                TextView m_tv = (TextView) m_layout.findViewById(R.id.m_textview);
                m_tv.setText("Custom Toast Notification");
                Toast m_toast = new Toast(getApplicationContext());
                m_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
                m_toast.setDuration(Toast.LENGTH_LONG);
                m_toast.setView(m_layout);
                m_toast.show();
            }
        });
    }
}