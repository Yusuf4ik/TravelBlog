package itacademy.kg.travelblogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DecriptionsActivity extends AppCompatActivity {
TextView tags, title, description;
ImageView imageView;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decriptions);
        tags = (TextView) findViewById(R.id.travelTags);
        description = (TextView) findViewById(R.id.descriptions1);
        title = (TextView) findViewById(R.id.travelTitle);
       imageView = (ImageView) findViewById(R.id.imageTravel);
       givingInfo();
    }
    public void givingInfo(){
        Travel currentItem = MainActivity.travels.get(position);
        tags.setText(currentItem.getTags());
        title.setText(currentItem.getTitle());
        description.setText(currentItem.getDescriptions());
        imageView.setImageResource(currentItem.getImage());
    }
}