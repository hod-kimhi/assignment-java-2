package com.example.challengetwo.models;

import java.io.Serializable;

public class Mentor implements Serializable {
  public String name;
  public int profilePicture;
  public MentorType mentorType;
  public String linkedInId;

  public enum MentorType {
    DESIGNER, DEVELOPER
  }

  public Mentor(String name, MentorType mentorType, String linkedInId, int profilePicture) {
    this.name = name;
    this.mentorType = mentorType;
    this.linkedInId = linkedInId;
    this.profilePicture = profilePicture;
  }

}
