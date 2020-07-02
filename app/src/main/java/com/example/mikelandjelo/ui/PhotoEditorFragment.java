package com.example.mikelandjelo.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mikelandjelo.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

import ja.burhanrashid52.photoeditor.PhotoEditorView;

public class PhotoEditorFragment extends Fragment {

    private PhotoEditorView photoEditorView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_photo_editor, container, false);

        //View
        photoEditorView = root.findViewById(R.id.photoEditorView);

        assert getArguments() != null;
        PhotoEditorFragmentArgs args = PhotoEditorFragmentArgs.fromBundle(getArguments());
        Uri imageUri = Uri.parse(args.getImage());

        Bitmap selectedImage = null;
        try {
            InputStream imageStream = getActivity().getContentResolver().openInputStream(imageUri);
            selectedImage = BitmapFactory.decodeStream(imageStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        photoEditorView.getSource().setImageBitmap(selectedImage);

        return root;
    }
}