package musicplayer.example.com.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MusicPlayer extends AppCompatActivity {

    MediaPlayer myMediaPlayer;
    boolean isPaused = false;
    boolean isStopped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        myMediaPlayer = new MediaPlayer();

    }

    public void gotoPlay(View view) {
        try {

            if (!isPaused && !isStopped) {
                myMediaPlayer.setDataSource("/storage/emulated/0/Ringtones/" + "hangouts_incoming_call.ogg");
                myMediaPlayer.prepare();
            } else {
                isPaused = false;
                isStopped = false;
            }
            myMediaPlayer.start();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Could not start music", Toast.LENGTH_SHORT).show();
            System.out.println("Error : " + e);

        }
    }

    public void gotoPause(View view) {

        isPaused = true;
        myMediaPlayer.pause();
        Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();

    }


    public void gotoStop(View view) {

        isStopped = true;
        myMediaPlayer.stop();
        Toast.makeText(getApplicationContext(), "Stopped", Toast.LENGTH_SHORT).show();

    }
}
