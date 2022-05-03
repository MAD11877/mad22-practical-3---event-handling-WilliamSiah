package sg.edu.np.mad.mad_exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Create Alert Box
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                // Getting random integer
                Random rand = new Random();
                int upperbound = 1000;
                int randInt = rand.nextInt(upperbound);

                // Create Intent
                Intent listToMain = new Intent(ListActivity.this, MainActivity.class);
                listToMain.putExtra("randInt", randInt);
                // Start activity
                startActivity(listToMain);
                finish();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });

        // Get imageview object from xml
        ImageView logo = findViewById(R.id.centeredLogo);
        // OnClick event listener
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display Alert
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}