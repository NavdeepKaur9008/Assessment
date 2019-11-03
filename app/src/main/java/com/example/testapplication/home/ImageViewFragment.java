package com.example.testapplication.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.testapplication.R;

public class ImageViewFragment extends Fragment {
    private ImageView imgProduct;
    public static final String TAG = "ImageViewFragment";

    public ImageViewFragment() {
    }

    public static ImageViewFragment newInstance(String imageName) {
        ImageViewFragment fragment = new ImageViewFragment();
        Bundle args = new Bundle();
        args.putString("image", imageName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_view, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgProduct=view.findViewById(R.id.img_product);
        if(getArguments() !=null) {
            Bundle b= getArguments();
            String resourceName =  b.getString("image");
            int resourceId= getActivity().getResources().getIdentifier(resourceName, "drawable", getActivity().getPackageName());
            imgProduct.setImageDrawable(getActivity().getResources().getDrawable(resourceId));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
