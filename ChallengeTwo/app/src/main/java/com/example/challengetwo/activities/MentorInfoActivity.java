package com.example.challengetwo.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.challengetwo.R;
import com.example.challengetwo.databinding.ActivityMentorInfoBinding;
import com.example.challengetwo.models.Mentor;

import static android.text.Html.fromHtml;

public class MentorInfoActivity extends AppCompatActivity {

    private ActivityMentorInfoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMentorInfoBinding.inflate(getLayoutInflater());
        View rootView = binding.getRoot();
        setContentView(rootView);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.show();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = this.getIntent();
        final Mentor mentor = (Mentor) intent.getSerializableExtra("mentor");

        binding.profilePicture.setImageResource(mentor.profilePicture);
        binding.mentorName.setText(mentor.name);

        switch(mentor.mentorType) {
            case DESIGNER:
                binding.mentorType.setText(R.string.designer);
                break;
            case DEVELOPER:
                binding.mentorType.setText(R.string.developer);
                break;
        }

        final String uri = "https://www.linkedin.com/in/" + mentor.linkedInId;
        final Uri webpage = Uri.parse(uri);

        binding.linkedInImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(browserIntent);
            }
        });
    }
}
