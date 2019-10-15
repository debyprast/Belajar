package org.jplas.android.belajar.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jplas.android.belajar.R;
import org.jplas.android.belajar.activities.PerkenalanActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerkenalanFragment extends Fragment implements View.OnClickListener {

    View view;
    Button submit;
    RadioGroup radioGroup;
    EditText namaText, angkaText;


    public PerkenalanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perkenalan, container, false);
        view = inflater.inflate(R.layout.fragment_perkenalan, container, false);

        radioGroup = view.findViewById(R.id.radio_group);
        namaText = view.findViewById(R.id.text_nama);
        submit = (Button) view.findViewById(R.id.button);
        submit.setOnClickListener((View.OnClickListener) this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String nama = namaText.getText().toString();
        int item = 0;
        int checkId = radioGroup.getCheckedRadioButtonId();
        if((checkId != -1) && !TextUtils.isEmpty(nama)){
            int jumlah = Integer.parseInt(angkaText.getText().toString());
            if (checkId == R.id.radio_laki){
                item = PerkenalanActivity.Laki;
            }else if (checkId == R.id.radio_perempuan){
                item = PerkenalanActivity.Perempuan;
            }
            PerkenalanActivity kenal = new PerkenalanActivity(nama, item, jumlah);
            Bundle args = new Bundle();
            args.putParcelable("shop", (Parcelable) kenal);
            Fragment TotalItem = new Kalimat();
            TotalItem.setArguments(args);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, TotalItem);
            fragmentTransaction.commit();
        }else {
            Toast.makeText(getActivity(), "Please select equipment and your name !", Toast.LENGTH_SHORT).show();
        }
    }

}
