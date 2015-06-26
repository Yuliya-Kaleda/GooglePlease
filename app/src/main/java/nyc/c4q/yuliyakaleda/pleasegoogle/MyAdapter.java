package nyc.c4q.yuliyakaleda.pleasegoogle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by July on 6/25/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final Activity mActivity;

    private List<JobPosition> arrayJobs;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<JobPosition> arrayJobs, Activity mActivity) {
        this.arrayJobs = arrayJobs;
        this.mActivity = mActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.my_text_view, parent, false);
        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        arrayJobs.get(position);
//        arrayJobs.get(position+1);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        CardView card = (CardView) holder.view.findViewById(R.id.card_view);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl(position);
            }
        });
        TextView title = (TextView) holder.view.findViewById(R.id.title);
        TextView link = (TextView) holder.view.findViewById(R.id.link);

        title.setText(arrayJobs.get(position).getTitle());
        link.setText(arrayJobs.get(position).getLink());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return arrayJobs.size();
    }

    public void openUrl(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(arrayJobs.get(position).getLink()));
        mActivity.startActivity(browserIntent);
    }
}