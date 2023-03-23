package com.kumardsingh.gaya.cameraexample;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;

public class MainActivity extends AppCompatActivity  {

    Button btnActivity;
    Button btnCameraActivity;

    Button btnGalleryActivity;
    ImageView camImageView;
    //Uri imageFilePath;
    private static final int pic_id = 12356;
    private static final int gal_id = 12345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Deepak MainActivity","On Create");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity = findViewById(R.id.button);
        btnCameraActivity = findViewById(R.id.openCamera);
        btnGalleryActivity = findViewById(R.id.openGallery);

        camImageView = findViewById(R.id.camImage);
        // creating a bundle object
        Bundle bundle = new Bundle();
        //createImageURI();
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);

                bundle.putString("Name","Deepak Kumar");
                bundle.putString("course","Masters");
                //intent.putExtra("name","Deepak Kumar");
                intent.putExtra("myBundle",bundle);
                startActivity(intent);
            }
        });

        btnCameraActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,pic_id);
            }
        });

        btnGalleryActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,gal_id);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Deepak MainActivity","On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Deepak MainActivity","On Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Deepak MainActivity","On Restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Deepak MainActivity","On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Deepak MainActivity","On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Deepak MainActivity","On Destroy");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Deepak MainActivity","On onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Deepak MainActivity","On onSaveInstanceState");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            camImageView.setImageBitmap(photo);
        } else
        if (requestCode == gal_id) {
            // BitMap is data structure of image file which store the image in memory
            Uri selectedImageUri = data.getData();
            // Set the image in imageview for display
            if (null != selectedImageUri) {
                camImageView.setImageURI(selectedImageUri);
            }
        }
    }
}