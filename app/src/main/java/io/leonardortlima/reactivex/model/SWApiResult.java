
package io.leonardortlima.reactivex.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SWApiResult<T> {

  @SerializedName("count")
  @Expose
  private Integer count;
  @SerializedName("next")
  @Expose
  private String next;
  @SerializedName("previous")
  @Expose
  private String previous;
  @SerializedName("results")
  @Expose
  private List<T> results = new ArrayList<>();

  /**
   * @return The count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * @param count The count
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * @return The next
   */
  public String getNext() {
    return next;
  }

  /**
   * @param next The next
   */
  public void setNext(String next) {
    this.next = next;
  }

  /**
   * @return The previous
   */
  public String getPrevious() {
    return previous;
  }

  /**
   * @param previous The previous
   */
  public void setPrevious(String previous) {
    this.previous = previous;
  }

  /**
   * @return The results
   */
  public List<T> getResults() {
    return results;
  }

  /**
   * @param results The results
   */
  public void setResults(List<T> results) {
    this.results = results;
  }

  @Override
  public String toString() {
    return "SWApiResult{" +
            "count=" + count +
            ", next='" + next + '\'' +
            ", previous='" + previous + '\'' +
            ", results=" + results +
            '}';
  }
}
