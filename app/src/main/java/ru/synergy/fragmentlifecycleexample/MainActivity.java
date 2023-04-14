package ru.synergy.fragmentlifecycleexample;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.synergy.fragmentlifecycleexample.fragments.FirstFragment;
import ru.synergy.fragmentlifecycleexample.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    Button fragmentButton1;
    Button fragmentButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentButton1 = (Button) findViewById(R.id.buttonFragment1);
        fragmentButton2 = (Button) findViewById(R.id.buttonFragment2);

        //fragment specific
        // get fragment manager to work with fragment's
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // add fragm to screen
        FirstFragment firstFragment = FirstFragment.newInstance("1", "2");
        fragmentTransaction.add(R.id.container,(Fragment) firstFragment,"String");
        fragmentTransaction.commit();

        fragmentButton1.setOnClickListener(onButtonClickListener);
        fragmentButton2.setOnClickListener(onButtonClickListener);


    }

    Button.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            
            Fragment newFragment = null;
            
            if(v == fragmentButton1){
                newFragment = new FirstFragment();
            }else {
                newFragment = new SecondFragment();
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            
            transaction.replace(R.id.container,newFragment);
            transaction.addToBackStack(null);
            
            transaction.commit();
        }
    };

}