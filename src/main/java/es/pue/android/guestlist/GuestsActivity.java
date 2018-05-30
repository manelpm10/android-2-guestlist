package es.pue.android.guestlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import es.pue.android.guestlist.model.Guest;

public class GuestsActivity extends AppCompatActivity {

    private Button btnShowGuests;
    private ListView lvGuestlist;
    private ArrayList<Guest> guests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guests);

        guests = this.getGuests();

        GuestsArrayAdapter guestsAdapter = new GuestsArrayAdapter(this, R.layout.item_guest, guests);

        btnShowGuests = findViewById(R.id.btnShowGuests);
        btnShowGuests.setOnClickListener(this.getBtnShowGuestsListener(guestsAdapter));

        lvGuestlist = findViewById(R.id.guestlist);
        lvGuestlist.setOnItemClickListener(this.getLvGuestlistListener());
    }

    /**
     * Add static list of guests.
     *
     * @return List of guests
     */
    private ArrayList<Guest> getGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(new Guest("Ben", "931111111"));
        guests.add(new Guest("Christof", "932222222"));
        guests.add(new Guest("John", "933333333"));

        return guests;
    }

    /**
     * Action for button show guests.
     */
    private View.OnClickListener getBtnShowGuestsListener(final GuestsArrayAdapter guestsAdapter) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvGuestlist.setAdapter(guestsAdapter);
            }
        };
    }

    /**
     * Return listener for guests list view.
     */
    public AdapterView.OnItemClickListener getLvGuestlistListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(GuestsActivity.this, GuestDetailActivity.class);
                Guest guest = guests.get(position);
                i.putExtra(Constants.GUEST, guest);
                startActivity(i);
            }
        };
    }
}
