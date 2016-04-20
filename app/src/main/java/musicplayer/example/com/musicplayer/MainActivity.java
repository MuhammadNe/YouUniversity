package musicplayer.example.com.musicplayer;

import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void gotoPlaySound(View view) {

        Intent intent = new Intent(getApplicationContext(), MusicPlayer.class);
        startActivity(intent);
    }

    public void gotoLocation(View view) {

        Intent intent = new Intent(getApplicationContext(), GetLocation.class);
        startActivity(intent);
    }
}
