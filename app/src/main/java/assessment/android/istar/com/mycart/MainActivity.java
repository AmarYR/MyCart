package assessment.android.istar.com.mycart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import assessment.android.istar.com.mycart.adapter.CarServiceAdapter;
import assessment.android.istar.com.mycart.adapter.ClickListener;
import assessment.android.istar.com.mycart.adapter.DividerItemDecoration;
import assessment.android.istar.com.mycart.adapter.RecyclerTouchListener;
import assessment.android.istar.com.mycart.map.MapActivity;
import assessment.android.istar.com.mycart.pojo.CarServicePojo;

public class MainActivity extends AppCompatActivity {
    private List<CarServicePojo> carserviceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CarServiceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new CarServiceAdapter(carserviceList, MainActivity.this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                CarServicePojo movie = carserviceList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareCarServicePojoData();
    }

    private void prepareCarServicePojoData() {
        CarServicePojo movie = new CarServicePojo("Mad Max: Fury Road", "Action & Adventure", "2015");
        carserviceList.add(movie);

        movie = new CarServicePojo("Inside Out", "Animation, Kids & Family", "2015");
        carserviceList.add(movie);

        movie = new CarServicePojo("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        carserviceList.add(movie);

        movie = new CarServicePojo("Shaun the Sheep", "Animation", "2015");
        carserviceList.add(movie);

        movie = new CarServicePojo("The Martian", "Science Fiction & Fantasy", "2015");
        carserviceList.add(movie);

        movie = new CarServicePojo("Mission: Impossible Rogue Nation", "Action", "2015");
        carserviceList.add(movie);

        movie = new CarServicePojo("Up", "Animation", "2009");
        carserviceList.add(movie);

        movie = new CarServicePojo("Star Trek", "Science Fiction", "2009");
        carserviceList.add(movie);

        movie = new CarServicePojo("The LEGO CarServicePojo", "Animation", "2014");
        carserviceList.add(movie);

        movie = new CarServicePojo("Iron Man", "Action & Adventure", "2008");
        carserviceList.add(movie);

        movie = new CarServicePojo("Aliens", "Science Fiction", "1986");
        carserviceList.add(movie);

        movie = new CarServicePojo("Chicken Run", "Animation", "2000");
        carserviceList.add(movie);

        movie = new CarServicePojo("Back to the Future", "Science Fiction", "1985");
        carserviceList.add(movie);

        movie = new CarServicePojo("Raiders of the Lost Ark", "Action & Adventure", "1981");
        carserviceList.add(movie);

        movie = new CarServicePojo("Goldfinger", "Action & Adventure", "1965");
        carserviceList.add(movie);

        movie = new CarServicePojo("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        carserviceList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

}
