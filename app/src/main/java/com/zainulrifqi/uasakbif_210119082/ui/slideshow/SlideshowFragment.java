package com.zainulrifqi.uasakbif_210119082.ui.slideshow;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.zainulrifqi.uasakbif_210119082.R;
import com.zainulrifqi.uasakbif_210119082.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    ViewPager viewPager;
    Adapter adapter;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupViewPager() {
        adapter = new Adapter(requireActivity());
        viewPager = getView().findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }

    private class Adapter extends PagerAdapter {
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
        }

        // list img
        int[] list_img = {
                R.drawable.icon,
                R.drawable.unikom,
                R.drawable.icon
        };

        // list judul
        int[] list_judul = {
                R.string.judul1,
                R.string.judul2,
                R.string.judul3
        };

        //list deskripsi
        int[] list_desk = {
                R.string.desk_1,
                R.string.desk_2,
                R.string.desk_3
        };


        @Override
        public int getCount() {
            return list_judul.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_layout, container, false);
            LinearLayout linearLayout = view.findViewById(R.id.item_layout);
            ImageView imageView = view.findViewById(R.id.img);
            TextView judul = view.findViewById(R.id.judul);
            TextView desk = view.findViewById(R.id.deskripsi);

            imageView.setImageResource(list_img[position]);
            judul.setText(list_judul[position]);
            desk.setText(list_desk[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}