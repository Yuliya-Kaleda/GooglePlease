package nyc.c4q.yuliyakaleda.pleasegoogle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by July on 6/25/15.
 */
public class BackFragment extends Fragment {

    EditText userChoice;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_back, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userChoice = (EditText) view.findViewById(R.id.user_input);
    }

    public String getString() {
        return userChoice.getText().toString();
    }
}
