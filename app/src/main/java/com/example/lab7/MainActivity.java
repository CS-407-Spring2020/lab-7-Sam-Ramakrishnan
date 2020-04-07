package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.lab7.App.CHANNEL_1;
import static com.example.lab7.App.CHANNEL_2;

public class MainActivity extends AppCompatActivity {
    EditText txtTitle, txtMessage;
    Button btnChannel1, btnChannel2;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = findViewById(R.id.txt_message);
        txtTitle = findViewById(R.id.txt_title);
        btnChannel1 = findViewById(R.id.btn_channel_1);
        btnChannel2 = findViewById(R.id.btn_channel_2);

        notificationManager = NotificationManagerCompat.from(this);
        setListeners();
    }

     void setListeners() {
        btnChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_1)

                        .setSmallIcon(R.drawable.ic_warning_red_24dp)

                        .setContentTitle(txtTitle.getText())

                        .setContentText(txtMessage.getText())

                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

                notificationManager.notify(1, notification);

            }
        });

         btnChannel2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_2)

                         .setSmallIcon(R.drawable.ic_offline_pin_green_24dp)

                         .setContentTitle(txtTitle.getText())

                         .setContentText(txtMessage.getText())

                         .setPriority(NotificationCompat.PRIORITY_LOW).build();

                 notificationManager.notify(2, notification);

             }
         });
    }
}
