
package io.leonardortlima.reactivex.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class People {

  @SerializedName("birth_year")
  @Expose
  private String birthYear;
  @SerializedName("eye_color")
  @Expose
  private String eyeColor;
  @SerializedName("films")
  @Expose
  private List<String> films = new ArrayList<String>();
  @SerializedName("gender")
  @Expose
  private String gender;
  @SerializedName("hair_color")
  @Expose
  private String hairColor;
  @SerializedName("height")
  @Expose
  private String height;
  @SerializedName("homeworld")
  @Expose
  private String homeworld;
  @SerializedName("mass")
  @Expose
  private String mass;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("skin_color")
  @Expose
  private String skinColor;
  @SerializedName("created")
  @Expose
  private String created;
  @SerializedName("edited")
  @Expose
  private String edited;
  @SerializedName("species")
  @Expose
  private List<String> species = new ArrayList<>();
  @SerializedName("starships")
  @Expose
  private List<String> starships = new ArrayList<>();
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("vehicles")
  @Expose
  private List<String> vehicles = new ArrayList<>();

  /**
   * @return The birthYear
   */
  public String getBirthYear() {
    return birthYear;
  }

  /**
   * @param birthYear The birth_year
   */
  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  /**
   * @return The eyeColor
   */
  public String getEyeColor() {
    return eyeColor;
  }

  /**
   * @param eyeColor The eye_color
   */
  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  /**
   * @return The films
   */
  public List<String> getFilms() {
    return films;
  }

  /**
   * @param films The films
   */
  public void setFilms(List<String> films) {
    this.films = films;
  }

  /**
   * @return The gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender The gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * @return The hairColor
   */
  public String getHairColor() {
    return hairColor;
  }

  /**
   * @param hairColor The hair_color
   */
  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  /**
   * @return The height
   */
  public String getHeight() {
    return height;
  }

  /**
   * @param height The height
   */
  public void setHeight(String height) {
    this.height = height;
  }

  /**
   * @return The homeworld
   */
  public String getHomeworld() {
    return homeworld;
  }

  /**
   * @param homeworld The homeworld
   */
  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  /**
   * @return The mass
   */
  public String getMass() {
    return mass;
  }

  /**
   * @param mass The mass
   */
  public void setMass(String mass) {
    this.mass = mass;
  }

  /**
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The skinColor
   */
  public String getSkinColor() {
    return skinColor;
  }

  /**
   * @param skinColor The skin_color
   */
  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  /**
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * @param created The created
   */
  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * @return The edited
   */
  public String getEdited() {
    return edited;
  }

  /**
   * @param edited The edited
   */
  public void setEdited(String edited) {
    this.edited = edited;
  }

  /**
   * @return The species
   */
  public List<String> getSpecies() {
    return species;
  }

  /**
   * @param species The species
   */
  public void setSpecies(List<String> species) {
    this.species = species;
  }

  /**
   * @return The starships
   */
  public List<String> getStarships() {
    return starships;
  }

  /**
   * @param starships The starships
   */
  public void setStarships(List<String> starships) {
    this.starships = starships;
  }

  /**
   * @return The url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url The url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return The vehicles
   */
  public List<String> getVehicles() {
    return vehicles;
  }

  /**
   * @param vehicles The vehicles
   */
  public void setVehicles(List<String> vehicles) {
    this.vehicles = vehicles;
  }

}