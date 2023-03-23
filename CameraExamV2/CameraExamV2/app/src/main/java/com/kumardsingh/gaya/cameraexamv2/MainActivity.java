package com.kumardsingh.gaya.cameraexamv2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnCameraActivity;
    Button btnGalleryActivity;
    ImageView camImageView;
    Uri imageUri;

    private final String contentType = "image/*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCameraActivity = findViewById(R.id.openCamera);
        camImageView = findViewById(R.id.camImage);
        btnGalleryActivity = findViewById(R.id.openGallery);

        imageUri = createImageURI();

        ActivityResultLauncher<Uri> launcher= registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if(result){
                    camImageView.setImageURI(imageUri);
                }
            }
        });

        btnCameraActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch(imageUri);
            }
        });

        ActivityResultLauncher glauncher=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                camImageView.setImageURI(result);
            }
        });

        btnGalleryActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glauncher.launch(contentType);
            }
        });
    }

        private Uri createImageURI(){
         File imageFile = new File(getApplicationContext().getFilesDir(),"camera_phone.png");
         imageUri = FileProvider.getUriForFile(getApplicationContext(),
                 "com.gaya.kumardsingh.FileProvider",
                 imageFile);

        return imageUri;
    }


}