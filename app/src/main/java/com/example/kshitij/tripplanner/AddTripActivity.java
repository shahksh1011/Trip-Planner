package com.example.kshitij.tripplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

public class AddTripActivity extends AppCompatActivity {
    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        AutocompleteFilter.Builder autocompleteFilter = new AutocompleteFilter.Builder();
        autocompleteFilter.setCountry("USA");
        autocompleteFilter.setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES);
        autocompleteFragment.setFilter(autocompleteFilter.build());

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.d("PLACE", "Place: " + place.getName());
            }
            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.d("Place", "An error occurred: " + status);
            }
        });
    }
}
