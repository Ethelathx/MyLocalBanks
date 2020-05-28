package com.example.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView DBS, OCBC, UOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.tvDBS);
        OCBC = findViewById(R.id.tvOCBC);
        UOB = findViewById(R.id.tvUOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.tvDBS) {
            getMenuInflater().inflate(R.menu.menuoption, menu);


        }
        else if(v.getId() == R.id.tvOCBC){
            getMenuInflater().inflate(R.menu.menuocbc, menu);
        }
        else if(v.getId() == R.id.tvUOB){
            getMenuInflater().inflate(R.menu.menuuob, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mnuContact){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsContact)));
            startActivity(intentCall);
        }
        if(item.getItemId() == R.id.mnuWeb){
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
            startActivity(intentWeb);
        }


        if(item.getItemId() == R.id.mnuContactocbc){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcContact)));
            startActivity(intentCall);
        }
        if(item.getItemId() == R.id.mnuWebuocbc){
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
            startActivity(intentWeb);
        }


        if(item.getItemId() == R.id.mnuContactuob){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobContact )));
            startActivity(intentCall);
        }
        if(item.getItemId() == R.id.mnuContactuob){
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
            startActivity(intentWeb);
        }
        return super.onContextItemSelected(item);
    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if(item.getItemId() == R.id.mnuEnglish){
                UOB.setText(getString(R.string.uobEnglish));
                DBS.setText(getString(R.string.dbsEnglish));
                OCBC.setText(getString(R.string.ocbcEnglish));
            }
            if(item.getItemId() == R.id.mnuChinese){
                UOB.setText(getString(R.string.uobChinese));
                DBS.setText(getString(R.string.dbsChinese));
                OCBC.setText(getString(R.string.ocbcChinese));
            }

            return super.onOptionsItemSelected(item);
        }


    }