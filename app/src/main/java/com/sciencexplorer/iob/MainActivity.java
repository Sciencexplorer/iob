package com.sciencexplorer.iob;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
//import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.Window;
import android.widget.Toast;
//import android.app.Activity;

public class MainActivity extends Activity {

    ImageView imageView;
    ImageView imageView2;

    Button button;
    Button button2;
    Button button3;

    private static final int PICK_IMAGE_1 = 100;
    private static final int PICK_IMAGE_2 = 101;

    Uri resulturi;

    //Uri imageUri;
    //Uri imageUri2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        button2 = (Button) findViewById(R.id.button2);

        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(PICK_IMAGE_1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(PICK_IMAGE_2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(0);
                imageView2.setImageResource(0);
            }
        });
    }

    private void openGallery(int buttonID) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, buttonID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        /*if (data == null) {
            //Log.d(TAG, "Data is null");
            Toast.makeText(getActivity(), getString(R.string.general_error), Toast.LENGTH_LONG).show();
        } else {*/
        //Log.d(TAG, "Data: " + data);
        // the intent has data, so set the media uri
        //Log.d(TAG, "adding the data using the getData() method");
        //mMediaUri = data.getData();
        //Log.d(TAG, "Media Uri: " + mMediaUri);



        if(resultCode != RESULT_CANCELED){

            resulturi = data.getData();

            if (requestCode == PICK_IMAGE_1) {

                imageView.setImageURI(resulturi);
            }

            else if (requestCode == PICK_IMAGE_2) {

                imageView2.setImageURI(resulturi);
            }
            /*switch (requestCode) {
                case PICK_IMAGE_1:
                    imageView.setImageURI(resulturi);
                    break;
                case PICK_IMAGE_2:
                    imageView2.setImageURI(resulturi);
                    break;


            }*/


        }
    }
}

        /*if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            imageUri2 = data.getData();
            imageView2.setImageURI(imageUri2);
        }*/

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable("picUri", resulturi);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        resulturi = savedInstanceState.getParcelable("picUri");

    }*/





