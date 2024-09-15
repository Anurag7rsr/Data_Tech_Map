package com.data.techMap.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CollegeData")
public class CollegeData {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "college_name")
   private String collegeName;

   @Column(name = "genders_accepted")
   private String gendersAccepted;

   @Column(name = "campus_size")
   private String campusSize;

   @Column(name = "total_student_enrollments")
   private int totalStudentEnrollments;

   @Column(name = "total_faculty")
   private int totalFaculty;

   @Column(name = "established_year")
   private int establishedYear;

   @Column(name = "rating")
   private float rating;

   @Column(name = "university")
   private String university;

   @Column(name = "courses")
   private String courses;

   @Column(name = "facilities")
   private String facilities;

   @Column(name = "city")
   private String city;

   @Column(name = "state")
   private String state;

   @Column(name = "country")
   private String country;

   @Column(name = "college_type")
   private String collegeType;

   @Column(name = "average_fees", precision = 10, scale = 2)
   private BigDecimal averageFees;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCollegeName() {
      return collegeName;
   }

   public void setCollegeName(String collegeName) {
      this.collegeName = collegeName;
   }

   public String getGendersAccepted() {
      return gendersAccepted;
   }

   public void setGendersAccepted(String gendersAccepted) {
      this.gendersAccepted = gendersAccepted;
   }

   public String getCampusSize() {
      return campusSize;
   }

   public void setCampusSize(String campusSize) {
      this.campusSize = campusSize;
   }

   public int getTotalStudentEnrollments() {
      return totalStudentEnrollments;
   }

   public void setTotalStudentEnrollments(int totalStudentEnrollments) {
      this.totalStudentEnrollments = totalStudentEnrollments;
   }

   public int getTotalFaculty() {
      return totalFaculty;
   }

   public void setTotalFaculty(int totalFaculty) {
      this.totalFaculty = totalFaculty;
   }

   public int getEstablishedYear() {
      return establishedYear;
   }

   public void setEstablishedYear(int establishedYear) {
      this.establishedYear = establishedYear;
   }

   public float getRating() {
      return rating;
   }

   public void setRating(float rating) {
      this.rating = rating;
   }

   public String getUniversity() {
      return university;
   }

   public void setUniversity(String university) {
      this.university = university;
   }

   public String getCourses() {
      return courses;
   }

   public void setCourses(String courses) {
      this.courses = courses;
   }

   public String getFacilities() {
      return facilities;
   }

   public void setFacilities(String facilities) {
      this.facilities = facilities;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getCollegeType() {
      return collegeType;
   }

   public void setCollegeType(String collegeType) {
      this.collegeType = collegeType;
   }

   public BigDecimal getAverageFees() {
      return averageFees;
   }

   @Override
   public String toString() {
      return "CollegeData{" +
              "id=" + id +
              ", collegeName='" + collegeName + '\'' +
              ", gendersAccepted='" + gendersAccepted + '\'' +
              ", campusSize='" + campusSize + '\'' +
              ", totalStudentEnrollments=" + totalStudentEnrollments +
              ", totalFaculty=" + totalFaculty +
              ", establishedYear=" + establishedYear +
              ", rating=" + rating +
              ", university='" + university + '\'' +
              ", courses='" + courses + '\'' +
              ", facilities='" + facilities + '\'' +
              ", city='" + city + '\'' +
              ", state='" + state + '\'' +
              ", country='" + country + '\'' +
              ", collegeType='" + collegeType + '\'' +
              ", averageFees=" + averageFees +
              '}';
   }

   public void setAverageFees(BigDecimal averageFees) {
      this.averageFees = averageFees;
   }


}
