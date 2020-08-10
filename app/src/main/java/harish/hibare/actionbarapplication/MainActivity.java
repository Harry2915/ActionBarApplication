package harish.hibare.actionbarapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Gallery;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static android.app.ActionBar.NAVIGATION_MODE_LIST;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        bottomNavigationView=findViewById(R.id.test);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_camera:
                        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(camera_intent);


                        break;
                    case R.id.action_gallery:
                        finish();;
                        //  Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Intent intent_set = new Intent(Settings.ACTION_SETTINGS);
                        startActivity(intent_set);
                        break;

                }
                return MainActivity.super.onOptionsItemSelected(item);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        setContentView(R.layout.activity_main);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_camera:
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camera_intent);


                break;
            case R.id.action_gallery:
                finish();;
               //  Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Intent intent_set = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent_set);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}