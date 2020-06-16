package com.example.challengetwo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.challengetwo.R;
import com.example.challengetwo.databinding.ActivityMainBinding;
import com.example.challengetwo.models.ImageAdapter;
import com.example.challengetwo.models.Mentor;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;

  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;

  private ArrayList<Mentor> designMentors = new ArrayList<>();
  private ArrayList<Mentor> developerMentors = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    View rootView = binding.getRoot();
    setContentView(rootView);

    setupTabLayout();
    createMentors();

    binding.imageList.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(this);
    binding.imageList.setLayoutManager(layoutManager);

    mAdapter = new ImageAdapter(designMentors); //default selected tab in tabLayout is the "Designer" tab
    binding.imageList.setAdapter(mAdapter);

    DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
    binding.imageList.addItemDecoration(decoration);
  }

  private void setupTabLayout() {
    binding.tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();

        switch(position) {
          case 0: //corresponds to the "designer" tab
            mAdapter = new ImageAdapter(designMentors);
            binding.imageList.setAdapter(mAdapter);
            break;
          case 1: //corresponds to the "developer" tab
            mAdapter = new ImageAdapter(developerMentors);
            binding.imageList.setAdapter(mAdapter);
        }
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });
  }

  private void createMentors() {
    Mentor adrian = new Mentor("Adrian Van Der Est", Mentor.MentorType.DEVELOPER, "adrian-van-der-est-193ab5a5", R.drawable.mentor_adrian);
    Mentor amir = new Mentor("Amir Chabi", Mentor.MentorType.DEVELOPER, "amirchabi", R.drawable.mentor_amir);
    Mentor andrey = new Mentor("Andrey Safonov", Mentor.MentorType.DEVELOPER, "andrey-safonov1", R.drawable.mentor_andrey);
    Mentor colin = new Mentor("Colin To", Mentor.MentorType.DESIGNER, "colinqto", R.drawable.mentor_colin);
    Mentor henry = new Mentor("Henry Lo", Mentor.MentorType.DEVELOPER, "henrilo", R.drawable.mentor_henry);
    Mentor janice = new Mentor("Janice Ng", Mentor.MentorType.DESIGNER, "janicewzn", R.drawable.mentor_janice);
    Mentor jeffrey = new Mentor("Jeffrey Qua", Mentor.MentorType.DESIGNER, "jeffreyqua", R.drawable.mentor_jeffrey);
    Mentor justin = new Mentor("Justin Lim", Mentor.MentorType.DESIGNER, "justinlwz", R.drawable.mentor_justin);
    Mentor katherine = new Mentor("Katherine Zhang", Mentor.MentorType.DESIGNER, "katherinexz", R.drawable.mentor_katherine);
    Mentor kevin = new Mentor("Kevin Choy", Mentor.MentorType.DESIGNER, "kgchoy", R.drawable.mentor_kevin);
    Mentor kitty = new Mentor("Kitty Chan", Mentor.MentorType.DESIGNER, "kittychan319", R.drawable.mentor_kitty);
    Mentor lia = new Mentor("Lia Estrellado", Mentor.MentorType.DESIGNER, "liaestrellado", R.drawable.mentor_lia);
    Mentor lien = new Mentor("Lien Quach", Mentor.MentorType.DESIGNER, "lienq", R.drawable.mentor_lien);
    Mentor peter = new Mentor("Peter Buk", Mentor.MentorType.DESIGNER, "peterbuk", R.drawable.mentor_peter);
    Mentor pevisha = new Mentor("Pevisha Joshi", Mentor.MentorType.DEVELOPER, "pevisha", R.drawable.mentor_pevisha);
    Mentor roland = new Mentor("Roland Tecson", Mentor.MentorType.DEVELOPER, "roland-tecson", R.drawable.mentor_roland);
    Mentor ronald = new Mentor("Ronald Ho", Mentor.MentorType.DEVELOPER, "rnldh", R.drawable.mentor_ronald);
    Mentor vivien = new Mentor("Vivien Anayian", Mentor.MentorType.DESIGNER, "vguniverse", R.drawable.mentor_vivien);
    Mentor yan = new Mentor("Yan Wu", Mentor.MentorType.DESIGNER, "yanwucreative", R.drawable.mentor_yan);
    Mentor yuki = new Mentor("Yuki Sato", Mentor.MentorType.DEVELOPER, "yuki-sato", R.drawable.mentor_yuki);
    Mentor yuria = new Mentor("Yuria Nishimura", Mentor.MentorType.DEVELOPER, "yurianishimura", R.drawable.mentor_yuria);

    designMentors.add(colin);
    designMentors.add(janice);
    designMentors.add(jeffrey);
    designMentors.add(justin);
    designMentors.add(katherine);
    designMentors.add(kevin);
    designMentors.add(kitty);
    designMentors.add(lia);
    designMentors.add(lien);
    designMentors.add(peter);
    designMentors.add(vivien);
    designMentors.add(yan);

    developerMentors.add(adrian);
    developerMentors.add(amir);
    developerMentors.add(andrey);
    developerMentors.add(henry);
    developerMentors.add(pevisha);
    developerMentors.add(roland);
    developerMentors.add(ronald);
    developerMentors.add(yuki);
    developerMentors.add(yuria);
  }
}