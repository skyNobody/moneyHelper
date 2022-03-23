package com.example.apptest.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.apptest.R;
import com.example.apptest.adapter.FruitAdapter;
import com.example.apptest.adapter.MsgAdapter;
import com.example.apptest.bean.Fruit;
import com.example.apptest.bean.Msg;
import com.example.apptest.utils.CalendarReminderUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends baseActivity {
    private List<Msg> msgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideActionBar();
        initMsg();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MsgAdapter msgAdapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);

        Button send = findViewById(R.id.sendMsg);
        EditText editText = findViewById(R.id.editMsg);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();
                if (!val.isEmpty()) {
                    Msg msg = new Msg(val, Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemChanged(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    editText.setText("");
                }
                if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALENDAR)
                    || PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CALENDAR)) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR}, 1);
                } else {
                    CalendarReminderUtils.addCalendarEvent(MainActivity.this,"学校读书","吃了饭再去",System.currentTimeMillis()+3600*24*1000*2+10000,2);
                }

            }
        });

        Button quitButton = findViewById(R.id.quit);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.apptest.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1 :
                if (grantResults.length > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    CalendarReminderUtils.addCalendarEvent(MainActivity.this,"学校读书","吃了饭再去",System.currentTimeMillis()+3600*24*1000*2+10000,2);
                } else {
                    Toast.makeText(this, "you denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }

    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello", Msg.TYPE_SEND);
        Msg msg3 = new Msg("What is your name!", Msg.TYPE_RECEIVED);
        Msg msg4 = new Msg("David", Msg.TYPE_SEND);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
        msgList.add(msg4);
    }
}