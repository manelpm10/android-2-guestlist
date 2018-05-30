package es.pue.android.guestlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.pue.android.guestlist.model.Guest;

public class GuestsArrayAdapter extends ArrayAdapter {
    ArrayList<Guest> guests;
    private int layoutId;
    private LayoutInflater inflater;

    public GuestsArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Guest> guests) {
        super(context, resource, guests);
        this.guests = guests;
        this.layoutId = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.guests.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        // 1. Load resource
        View view = this.inflater.inflate(this.layoutId, parent, false);

        // 2. Assign to widget the info for each guest
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvPhone);

        Guest guest = this.guests.get(position);
        tvName.setText(guest.getName());
        tvPhone.setText(guest.getPhoneNumber());

        // 3. Return view
        return view;
    }
}
