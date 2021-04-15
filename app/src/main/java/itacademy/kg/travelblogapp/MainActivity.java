package itacademy.kg.travelblogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
   static  ArrayList<Travel> travels;
    TravelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        createArrayList();
        buildRecyclerView();
    }

    private void createArrayList() {
        travels = new ArrayList<>();
        travels.add(new Travel("My first vacation to Japan", "#hiJapan", "We were driven from Khao Lak down to Phuket, and then caught the ferry across to Ko Phi Phi Don where we spent the second part of our Thai sojourn. There's something about signs at Thai tourist hotspots that's always brought a smile to my face, and I got an instant reminder of this as we got off the ferry. The large board hanging above the entrance to the pier instructed us to \"Funnel into out the Passenger\". Hopefully we complied. The rubbish bin in reception at the resort was labelled \"Poisoning Garbage\". Hmm. Probably best not to let any of that leak into the ocean. Finding the resort restaurant on the first night proved to be a bit of challenge - there",
                R.drawable.travel, "https://www.travelblog.org/"));
        travels.add(new Travel("My second vacation to Japan", "#IAmInJapan", "We were driven from Khao Lak down to Phuket, and then caught the ferry across to Ko Phi Phi Don where we spent the second part of our Thai sojourn. There's something about signs at Thai tourist hotspots that's always brought a smile to my face, and I got an instant reminder of this as we got off the ferry. The large board hanging above the entrance to the pier instructed us to \"Funnel into out the Passenger\". Hopefully we complied. The rubbish bin in reception at the resort was labelled \"Poisoning Garbage\". Hmm. Probably best not to let any of that leak into the ocean. Finding the resort restaurant on the first night proved to be a bit of challenge - there",
                R.drawable.travel_blog2, "https://romanroams.com/ru/dobro-pozhalovat/"));
        travels.add(new Travel("My third vacation to Japan", "#byeJapan", "We were driven from Khao Lak down to Phuket, and then caught the ferry across to Ko Phi Phi Don where we spent the second part of our Thai sojourn. There's something about signs at Thai tourist hotspots that's always brought a smile to my face, and I got an instant reminder of this as we got off the ferry. The large board hanging above the entrance to the pier instructed us to \"Funnel into out the Passenger\". Hopefully we complied. The rubbish bin in reception at the resort was labelled \"Poisoning Garbage\". Hmm. Probably best not to let any of that leak into the ocean. Finding the resort restaurant on the first night proved to be a bit of challenge - there",
                R.drawable.travel_blog, "https://www.onetwotrip.com/ru/blog/journeys/"));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.settings:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share web site");
                String shareMessage= "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://www.onetwotrip.com/ru/blog/journeys/" + BuildConfig.APPLICATION_ID +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new TravelAdapter(travels);
        recyclerView.setAdapter(adapter);
        adapter.setTravelClickListener(new TravelClickListener() {
            @Override
            public void onClickItem(int position) {

                Intent  intent = new Intent(MainActivity.this, DecriptionsActivity.class);
                intent.putExtra("listMeal", String.valueOf(position));
                startActivity(intent);

            }
        });
    }
}