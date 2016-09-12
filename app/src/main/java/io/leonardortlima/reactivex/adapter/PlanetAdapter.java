package io.leonardortlima.reactivex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.leonardortlima.reactivex.R;
import io.leonardortlima.reactivex.model.Planet;

/**
 * @author leonardortlima
 * @since 2016-08-21
 */
public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

  private List<Planet> planets;

  public PlanetAdapter() {
    this.planets = new ArrayList<>();
  }

  public PlanetAdapter(List<Planet> planets) {
    this.planets = planets;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View rootView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_planet, parent, false);
    return new ViewHolder(rootView);

  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.planetName.setText(planets.get(position).getName());
    holder.planetClimate.setText(planets.get(position).getClimate());
  }

  @Override
  public int getItemCount() {
    return planets.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    TextView planetName;
    TextView planetClimate;

    public ViewHolder(View itemView) {
      super(itemView);

      planetName = (TextView) itemView.findViewById(R.id.planet_name);
      planetClimate = (TextView) itemView.findViewById(R.id.planet_climate);
    }
  }

  public void addPlanet(Planet planet) {
    planets.add(planet);
    notifyItemInserted(planets.size() - 1);
  }

  public void clearData() {
    int size = this.planets.size();
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        this.planets.remove(0);
      }

      this.notifyItemRangeRemoved(0, size);
    }
  }

}
