package io.leonardortlima.reactivex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.leonardortlima.reactivex.model.Person;

/**
 * @author leonardortlima
 * @since 2016-09-13
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

  private List<Person> mData;

  public PersonAdapter() {
    this.mData = new ArrayList<>();
  }

  public PersonAdapter(List<Person> data) {
    this.mData = data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View rootView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_person, parent, false);
    return new ViewHolder(rootView);

  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.peopleName.setText(mData.get(position).getName());
    holder.personDetails.setText(mData.get(position).getDetails());
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    TextView peopleName;
    TextView personDetails;

    public ViewHolder(View itemView) {
      super(itemView);

      peopleName = (TextView) itemView.findViewById(R.id.planet_name);
      personDetails = (TextView) itemView.findViewById(R.id.planet_climate);
    }
  }

  public void addPerson(Person person) {
    mData.add(person);
    notifyItemInserted(mData.size() - 1);
  }

  public void clearData() {
    int size = this.mData.size();
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        this.mData.remove(0);
      }

      this.notifyItemRangeRemoved(0, size);
    }
  }

}
