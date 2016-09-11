
package io.leonardortlima.reactivex.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Planet {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("rotation_period")
  @Expose
  private String rotationPeriod;
  @SerializedName("orbital_period")
  @Expose
  private String orbitalPeriod;
  @SerializedName("diameter")
  @Expose
  private String diameter;
  @SerializedName("climate")
  @Expose
  private String climate;
  @SerializedName("gravity")
  @Expose
  private String gravity;
  @SerializedName("terrain")
  @Expose
  private String terrain;
  @SerializedName("surface_water")
  @Expose
  private String surfaceWater;
  @SerializedName("population")
  @Expose
  private String population;
  @SerializedName("residents")
  @Expose
  private List<String> residents = new ArrayList<String>();
  @SerializedName("films")
  @Expose
  private List<String> films = new ArrayList<String>();
  @SerializedName("created")
  @Expose
  private String created;
  @SerializedName("edited")
  @Expose
  private String edited;
  @SerializedName("url")
  @Expose
  private String url;

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
   * @return The rotationPeriod
   */
  public String getRotationPeriod() {
    return rotationPeriod;
  }

  /**
   * @param rotationPeriod The rotation_period
   */
  public void setRotationPeriod(String rotationPeriod) {
    this.rotationPeriod = rotationPeriod;
  }

  /**
   * @return The orbitalPeriod
   */
  public String getOrbitalPeriod() {
    return orbitalPeriod;
  }

  /**
   * @param orbitalPeriod The orbital_period
   */
  public void setOrbitalPeriod(String orbitalPeriod) {
    this.orbitalPeriod = orbitalPeriod;
  }

  /**
   * @return The diameter
   */
  public String getDiameter() {
    return diameter;
  }

  /**
   * @param diameter The diameter
   */
  public void setDiameter(String diameter) {
    this.diameter = diameter;
  }

  /**
   * @return The climate
   */
  public String getClimate() {
    return climate;
  }

  /**
   * @param climate The climate
   */
  public void setClimate(String climate) {
    this.climate = climate;
  }

  /**
   * @return The gravity
   */
  public String getGravity() {
    return gravity;
  }

  /**
   * @param gravity The gravity
   */
  public void setGravity(String gravity) {
    this.gravity = gravity;
  }

  /**
   * @return The terrain
   */
  public String getTerrain() {
    return terrain;
  }

  /**
   * @param terrain The terrain
   */
  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }

  /**
   * @return The surfaceWater
   */
  public String getSurfaceWater() {
    return surfaceWater;
  }

  /**
   * @param surfaceWater The surface_water
   */
  public void setSurfaceWater(String surfaceWater) {
    this.surfaceWater = surfaceWater;
  }

  /**
   * @return The population
   */
  public String getPopulation() {
    return population;
  }

  /**
   * @param population The population
   */
  public void setPopulation(String population) {
    this.population = population;
  }

  /**
   * @return The residents
   */
  public List<String> getResidents() {
    return residents;
  }

  /**
   * @param residents The residents
   */
  public void setResidents(List<String> residents) {
    this.residents = residents;
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

  @Override
  public String toString() {
    return "Planet{" +
            "name='" + name + '\'' +
            ", rotationPeriod='" + rotationPeriod + '\'' +
            ", orbitalPeriod='" + orbitalPeriod + '\'' +
            ", diameter='" + diameter + '\'' +
            ", climate='" + climate + '\'' +
            ", gravity='" + gravity + '\'' +
            ", terrain='" + terrain + '\'' +
            ", surfaceWater='" + surfaceWater + '\'' +
            ", population='" + population + '\'' +
            ", residents=" + residents +
            ", films=" + films +
            ", created='" + created + '\'' +
            ", edited='" + edited + '\'' +
            ", url='" + url + '\'' +
            '}';
  }
}
