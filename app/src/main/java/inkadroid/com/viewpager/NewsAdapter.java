package inkadroid.com.viewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by CAAVM on 20/05/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {
    public Context context;
    public FragmentActivity activity;
    public LayoutInflater inflater;
    public List<News> data = Collections.emptyList();

    public NewsAdapter(FragmentActivity context, List<News> data) {
        activity = context;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public NewsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsVH(inflater.inflate(R.layout.row_news, parent, false));
    }

    public void onBindViewHolder(NewsVH holder, int position) {
        News news = data.get(position);
        holder.txt_title.setText(news.getTitle());
        holder.txt_date.setText(news.getMdate());
        Picasso.with(context).load(news.getImage()).resize(120, 120).into(holder.img_news);
    }

    public int getItemCount() {
        return data.size();
    }

    class NewsVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img_news;
        private TextView txt_title;
        private TextView txt_date;

        public NewsVH(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            img_news = (ImageView) itemView.findViewById(R.id.img_news);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
        }

        @Override
        public void onClick(View v) {
            News news = data.get(getAdapterPosition());
            Intent intent = new Intent(activity, Noticias.class);
            intent.putExtra("image", news.getImage());
            intent.putExtra("title", news.getTitle());
            intent.putExtra("date", news.getMdate());
            intent.putExtra("description", news.getDescription());
            intent.putExtra("source", news.getSource());
            activity.startActivity(intent);
        }

    }


}