package org.jplas.android.belajar.fragment;




import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jplas.android.belajar.R;
import org.jplas.android.belajar.activities.PerkenalanActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class KalimatFragment extends Fragment {

    View view;
    PerkenalanActivity items;

    public KalimatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_kalimat, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textData);
        Bundle data = this.getArguments();

        items = data.getParcelable("kenal");
        String dat = items.getNama()+" Total biaya anda "+items.getJumlah();
        textView.setText(dat);

        return view;

    }

}

