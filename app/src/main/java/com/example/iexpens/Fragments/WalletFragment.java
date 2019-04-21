package com.example.iexpens.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.iexpens.Activity.AccountList;
import com.example.iexpens.Activity.BankAccount;
import com.example.iexpens.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WalletFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class WalletFragment extends Fragment implements AdapterView.OnItemClickListener {

    private OnFragmentInteractionListener mListener;
    private Button button_add_account;

    ListView listViewAccounts;
    DatabaseReference databaseAccounts;
    List<BankAccount> accountList;
    ArrayAdapter<AccountList> adapter;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        listViewAccounts = (ListView)view.findViewById(R.id.listViewAccounts);
        databaseAccounts = FirebaseDatabase.getInstance().getReference("Bank Accounts");
        accountList = new ArrayList<>();

        button_add_account = (Button)view.findViewById(R.id.button_add_account);
        button_add_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_add_account_onClick(v);
            }
        });
        return view;


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container, new AccountScreenFragment());
        fr.commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void button_add_account_onClick(View view) {
        //Intent intent = new Intent(getActivity(), AddAccountActivity.class);
        //startActivity(intent);
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container, new AddAccountFragment());
        fr.commit();
    }

    public void onStart(){
        super.onStart();

        databaseAccounts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               // accountList.clear();

                for(DataSnapshot accountSnapshot: dataSnapshot.getChildren()){
                    BankAccount bankAccount = accountSnapshot.getValue(BankAccount.class);

                    accountList.add(bankAccount);
                }
              AccountList adapter = new AccountList(getActivity(), accountList);
           listViewAccounts.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
