package com.example.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }
    int imagesArray[] = {
            R.raw.first,
            R.raw.second,
            R.raw.third
    };

    int headingArray[] = {
            R.string.first_slide,
            R.string.second_slide,
            R.string.third_slide
    };

    int descriptionArray[] = {
            R.string.description,
            R.string.description,
            R.string.description
    };


    @Override
    public int getCount() {
        return headingArray.length;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliding_layout, container,false);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.lottie);
        LottieAnimationView lottieAnimationView2 = view.findViewById(R.id.lottie2);
        LottieAnimationView lottieAnimationView3 = view.findViewById(R.id.lottie3);
        TextView heading = view.findViewById(R.id.heading);
        TextView description = view.findViewById(R.id.description);

        lottieAnimationView.setAnimation(imagesArray[position]);
        lottieAnimationView2.setAnimation(imagesArray[position]);
        lottieAnimationView3.setAnimation(imagesArray[position]);
        heading.setText(headingArray[position]);
        description.setText(descriptionArray[position]);

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
