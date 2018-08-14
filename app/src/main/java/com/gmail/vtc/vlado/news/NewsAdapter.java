package com.gmail.vtc.vlado.news;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;

    public NewsAdapter(NewsActivity newsActivity, List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final News news = newsList.get(position);

        holder.tvTitle.setText(news.getTitle());

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
        Date dateObject = null;

        try {
            dateObject = df.parse(news.getDateAndTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedDate = formatDate(dateObject);
        holder.tvDate.setText(formattedDate);
        String formattedTime = formatTime(dateObject);
        holder.tvTime.setText(formattedTime);
        holder.tvSection.setText(news.getSection());
        holder.tvAuthor.setText(news.getAuthor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWebIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getWebLink()));
                v.getContext().startActivity(openWebIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
        return timeFormat.format(dateObject);
    }

    public void addAll(List<News> data) {
        newsList.addAll(data);
    }

    public void clear() {
        if (newsList != null) {
            newsList.clear();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDate, tvTime, tvSection, tvAuthor, emptyView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvSection = itemView.findViewById(R.id.tv_section);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            emptyView = itemView.findViewById(R.id.tv_empty_view);
        }
    }
}
