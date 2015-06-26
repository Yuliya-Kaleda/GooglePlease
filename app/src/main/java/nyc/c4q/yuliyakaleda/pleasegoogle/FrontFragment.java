package nyc.c4q.yuliyakaleda.pleasegoogle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

/**
 * Created by July on 6/25/15.
 */
public class FrontFragment extends Fragment implements JobSearchAsync.MyListener {


    //private static final String TAG = FragmentFront.class.getSimpleName();
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        parseData("java");
    }


    @Override
    public void onLoadComplete(List<JobPosition> jobs) {
        // get recycler view
        if(getView() == null || isDetached() ) return;

        progressBar.setVisibility(View.INVISIBLE);

        RecyclerView mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(jobs, getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void parseData(String string) {
        //Log.d(TAG, "parseData: " + string);

        progressBar.setVisibility(View.VISIBLE);

        JobSearchAsync jobSearchAsync = new JobSearchAsync();
        jobSearchAsync.setListener(this);
        jobSearchAsync.execute(string);
    }
}



