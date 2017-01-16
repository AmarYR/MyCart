package assessment.android.istar.com.mycart.adapter;

/**
 * Created by ajith on 14-01-2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

import assessment.android.istar.com.mycart.R;
import assessment.android.istar.com.mycart.pojo.CarServicePojo;

public class CarServiceAdapter extends RecyclerView.Adapter<CarServiceAdapter.MyViewHolder> {

    private List<CarServicePojo> moviesList;
    private Context context;
    private int lastPosition = -1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }

        public void clearAnimation() {
            itemView.clearAnimation();
        }
    }


    public CarServiceAdapter(List<CarServicePojo> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        ((MyViewHolder) holder).clearAnimation();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CarServicePojo movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

        // Here you apply the animation when the view is bound
        setAnimation(holder.itemView, position);


    }


    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        viewToAnimate.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}