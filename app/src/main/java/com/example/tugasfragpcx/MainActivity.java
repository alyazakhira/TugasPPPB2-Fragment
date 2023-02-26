package com.example.tugasfragpcx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button actButton;
    private Boolean isInfo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        show first frag
        InfoFragment infoFragment = InfoFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_info, infoFragment).addToBackStack(null).commit();

//        the button
        actButton = findViewById(R.id.act_button);
        actButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInfo){
                    displayStrFragment();
                } else{
                    closeStrFragment();
                }
            }
        });
    }

//    close first frag, show sec frag
    private void displayStrFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        InfoFragment infoFragment = (InfoFragment) fragmentManager.findFragmentById(R.id.frag_info);
        if (infoFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(infoFragment).commit();
        }
        StrFragment strFragment = StrFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_info, strFragment).addToBackStack(null).commit();
        actButton.setText("Mantap!");
        isInfo = false;
    }

//    close sec frag, show first frag
    private void closeStrFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        StrFragment strFragment = (StrFragment) fragmentManager.findFragmentById(R.id.frag_info);
        if (strFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(strFragment).commit();
        }
        InfoFragment infoFragment = InfoFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_info, infoFragment).addToBackStack(null).commit();
        actButton.setText("Lihat Kelebihan");
        isInfo = true;
    }

}