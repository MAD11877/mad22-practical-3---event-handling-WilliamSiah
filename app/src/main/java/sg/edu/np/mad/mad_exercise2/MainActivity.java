package sg.edu.np.mad.mad_exercise2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get random integer form ListActivity
        Intent receivingEnd = getIntent();
        int randInt = receivingEnd.getIntExtra("randInt",-1);
        // Get name text
        TextView name = findViewById(R.id.maintext);
        // If random number was generated
        if (randInt > -1){
            String newText = String.format("MAD %s",randInt);
            name.setText(newText);
        }

        // Get follow button from xml
        Button followButton = findViewById(R.id.followButton);
        // OnClick event listener
        followButton.setOnClickListener(new View.OnClickListener() {
            // Init follow variable
            boolean follow = false;

            @Override
            public void onClick(View view) {
                // Unfollowed
                if (follow){
                    followButton.setText("Follow");
                    follow = false;
                    // Toast notification
                    Toast.makeText(getApplicationContext(),"Unfollowed", Toast.LENGTH_SHORT).show();
                }
                // Followed
                else{
                    followButton.setText("Unfollow");
                    follow = true;
                    // Toast notification
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
                }
            }

        });

        // Get message button
        Button messageButton = findViewById(R.id.messageButton);
        // OnClick event listener
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create intent
                Intent mainToMessage = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(mainToMessage);
                finish();
            }
        });
    }

}