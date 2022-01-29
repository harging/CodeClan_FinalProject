package com.codeclan.DiveLog.DiveLog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dives")
public class Dive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dive_num")
    private int diveNum;

    @Column(name = "date")
    private Date date;

    @Column(name = "entry_time")
    private Time entryTime;

    @Column(name = "surface_interval")
    private int surfaceInterval;

    @Column(name = "max_depth")
    private int maxDepth;

    @Column(name = "average_depth")
    private int averageDepth;

    @Column(name = "place")
    private String place;

    @Column(name = "dive_site")
    private String diveSite;

    @Column(name = "latitude")
    private DecimalFormat latitude;

    @Column(name = "longitude")
    private DecimalFormat longitude;

    @Column(name = "weather")
    private String weather;

    @Column(name = "visibility")
    private int visibility;

    @Column(name = "air_temp")
    private int airTemp;

    @Column(name = "bottom_temp")
    private int bottomTemp;

    @Column(name = "surface_temp")
    private int surfaceTemp;

    @Column(name = "buddy")
    private String buddy;

    @Column(name = "boat")
    private String boat;

    @Column(name = "tank")
    private String tank;

    @Column(name = "tank_volume")
    private float tankVolume;

    @Column(name = "working_pressure")
    private float workingPressure;

    @Column(name = "double_tank")
    private float doubleTank;

    @Column(name = "bar_start")
    private int barStart;

    @Column(name = "bar_end")
    private int barEnd;

    @Column(name = "weight")
    private float weight;

    @Column(name = "o2")
    private int o2;

    @Column(name = "he")
    private int he;

    @Column(name = "notes")
    private String notes;

    @Column(name = "sample_rate")
    private int sampleRate;

    @OneToMany(mappedBy = "dive")
    @Column(name = "profile")
    private List<SamplePoint> profile = new ArrayList<>();

    public Dive(int diveNum, Date date, Time entryTime, int surfaceInterval, int maxDepth, int averageDepth, String place, String diveSite, DecimalFormat latitude, DecimalFormat longitude, String weather, int visibility, int airTemp, int bottomTemp, int surfaceTemp, String buddy, String boat, String tank, float tankVolume, float workingPressure, float doubleTank, int barStart, int barEnd, float weight, int o2, int he, String notes, int sampleRate) {
        this.diveNum = diveNum;
        this.date = date;
        this.entryTime = entryTime;
        this.surfaceInterval = surfaceInterval;
        this.maxDepth = maxDepth;
        this.averageDepth = averageDepth;
        this.place = place;
        this.diveSite = diveSite;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
        this.visibility = visibility;
        this.airTemp = airTemp;
        this.bottomTemp = bottomTemp;
        this.surfaceTemp = surfaceTemp;
        this.buddy = buddy;
        this.boat = boat;
        this.tank = tank;
        this.tankVolume = tankVolume;
        this.workingPressure = workingPressure;
        this.doubleTank = doubleTank;
        this.barStart = barStart;
        this.barEnd = barEnd;
        this.weight = weight;
        this.o2 = o2;
        this.he = he;
        this.notes = notes;
        this.sampleRate = sampleRate;
        this.profile = new ArrayList<>();
    }

    public Dive(){

    }

    public int getDiveNum() {
        return diveNum;
    }

    public void setDiveNum(int diveNum) {
        this.diveNum = diveNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Time entryTime) {
        this.entryTime = entryTime;
    }

    public int getSurfaceInterval() {
        return surfaceInterval;
    }

    public void setSurfaceInterval(int surfaceInterval) {
        this.surfaceInterval = surfaceInterval;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getAverageDepth() {
        return averageDepth;
    }

    public void setAverageDepth(int averageDepth) {
        this.averageDepth = averageDepth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDiveSite() {
        return diveSite;
    }

    public void setDiveSite(String diveSite) {
        this.diveSite = diveSite;
    }

    public DecimalFormat getLatitude() {
        return latitude;
    }

    public void setLatitude(DecimalFormat latitude) {
        this.latitude = latitude;
    }

    public DecimalFormat getLongitude() {
        return longitude;
    }

    public void setLongitude(DecimalFormat longitude) {
        this.longitude = longitude;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(int airTemp) {
        this.airTemp = airTemp;
    }

    public int getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(int bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public int getSurfaceTemp() {
        return surfaceTemp;
    }

    public void setSurfaceTemp(int surfaceTemp) {
        this.surfaceTemp = surfaceTemp;
    }

    public String getBuddy() {
        return buddy;
    }

    public void setBuddy(String buddy) {
        this.buddy = buddy;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public float getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(float tankVolume) {
        this.tankVolume = tankVolume;
    }

    public float getWorkingPressure() {
        return workingPressure;
    }

    public void setWorkingPressure(float workingPressure) {
        this.workingPressure = workingPressure;
    }

    public float getDoubleTank() {
        return doubleTank;
    }

    public void setDoubleTank(float doubleTank) {
        this.doubleTank = doubleTank;
    }

    public int getBarStart() {
        return barStart;
    }

    public void setBarStart(int barStart) {
        this.barStart = barStart;
    }

    public int getBarEnd() {
        return barEnd;
    }

    public void setBarEnd(int barEnd) {
        this.barEnd = barEnd;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getO2() {
        return o2;
    }

    public void setO2(int o2) {
        this.o2 = o2;
    }

    public int getHe() {
        return he;
    }

    public void setHe(int he) {
        this.he = he;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public List<SamplePoint> getProfile() {
        return profile;
    }

    public void addSamplePointToProfile(SamplePoint samplePoint) {
        this.profile.add(samplePoint);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
