package com.DatNguyen.Resume_Builder_Service.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import lombok.Data;
import java.util.Map;

@Data
@Document(collection = "resume_collection")
public class Resume {
    @Id
    private String email; // Use email as ID

    private Map<String, Object> personalInformation;
    private List<Map<String, Object>> skills;
    private List<Map<String, Object>> experience;
    private List<Map<String, Object>> education;
    private List<Map<String, Object>> certifications;
    private Object projects; // Nullable
    private List<Object> achievements; // Can be empty
    private List<Map<String, Object>> languages;
    private List<Map<String, Object>> interests;

    public Resume(){}

    public Resume(String email, Map<String, Object> personalInformation, List<Map<String, Object>> skills, List<Map<String, Object>> experience, List<Map<String, Object>> education, List<Map<String, Object>> certifications, Object projects, List<Object> achievements, List<Map<String, Object>> languages, List<Map<String, Object>> interests) {
        this.email = email;
        this.personalInformation = personalInformation;
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.certifications = certifications;
        this.projects = projects;
        this.achievements = achievements;
        this.languages = languages;
        this.interests = interests;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(Map<String, Object> personalInformation) {
        this.personalInformation = personalInformation;
    }

    public List<Map<String, Object>> getSkills() {
        return skills;
    }

    public void setSkills(List<Map<String, Object>> skills) {
        this.skills = skills;
    }

    public List<Map<String, Object>> getExperience() {
        return experience;
    }

    public void setExperience(List<Map<String, Object>> experience) {
        this.experience = experience;
    }

    public List<Map<String, Object>> getEducation() {
        return education;
    }

    public void setEducation(List<Map<String, Object>> education) {
        this.education = education;
    }

    public List<Map<String, Object>> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Map<String, Object>> certifications) {
        this.certifications = certifications;
    }

    public Object getProjects() {
        return projects;
    }

    public void setProjects(Object projects) {
        this.projects = projects;
    }

    public List<Object> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Object> achievements) {
        this.achievements = achievements;
    }

    public List<Map<String, Object>> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Map<String, Object>> languages) {
        this.languages = languages;
    }

    public List<Map<String, Object>> getInterests() {
        return interests;
    }

    public void setInterests(List<Map<String, Object>> interests) {
        this.interests = interests;
    }
}
