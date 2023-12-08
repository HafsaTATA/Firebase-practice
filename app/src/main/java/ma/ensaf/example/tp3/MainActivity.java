package ma.ensaf.example.tp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import java.net.Authenticator;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    FirebaseAuth mAuth;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        Menu menu = navigationView.getMenu();
        MenuItem loginItem = menu.findItem(R.id.login);
        MenuItem logoutItem = menu.findItem(R.id.logout);

        loginItem.setVisible(false);
        logoutItem.setVisible(true);

        drawerToggle =new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    Toast.makeText(getApplicationContext(), "Vous avez cliqué sur Home", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.calculator) {
                    Intent intent = new Intent(MainActivity.this, calculatriceActivity.class);
                    startActivity(intent);

                    return true;
                }  else if (itemId == R.id.dictionary) {
                    Toast.makeText(getApplicationContext(), "Vous avez cliqué sur dictionary", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.chat) {
                    Toast.makeText(getApplicationContext(), "Vous avez cliqué sur chat", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.google_map) {
                    Intent intent = new Intent(MainActivity.this, GoogleMapActivity.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    if (mAuth.getCurrentUser() != null) {
                        mAuth.signOut();

                        Intent intent = new Intent(MainActivity.this, FirebaseAuthentification.class);
                        startActivity(intent);
                    }
                    return true;
                } else if (itemId == R.id.share) {
                    Toast.makeText(getApplicationContext(), "Vous avez cliqué sur share", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.rateUs) {
                    Toast.makeText(getApplicationContext(), "Vous avez cliqué sur rateUs", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

}