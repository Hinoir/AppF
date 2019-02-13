package com.apps.hinoir.appf;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements FragmentA.FragmentAActions {

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.menubar_a:
                        transaction.replace(R.id.contenido, fragmentA);
                        transaction.commit();
                        break;
                    case R.id.menubar_b:
                        transaction.replace(R.id.contenido, fragmentB);
                        transaction.commit();
                        break;
                }

                return true;
            }
        });

    }

    @Override
    public void onMessage(String msj) {

    }
}
