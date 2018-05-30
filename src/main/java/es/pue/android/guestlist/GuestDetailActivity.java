package es.pue.android.guestlist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.pue.android.guestlist.model.Guest;

public class GuestDetailActivity extends AppCompatActivity {
    Guest guest = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_detail);

        guest = (Guest) getIntent().getSerializableExtra(Constants.GUEST);
        //String guest = i.getStringExtra("guestName");

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(guest.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SYSTEM", "Guest detail activity destroyed");
    }

    public void callGuest(View view) {
        Intent sendIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + guest.getPhoneNumber()));
        /*
         * Other way
         *
         * sendIntent.setAction(Intent.ACTION_DIAL);
         * sendIntent.setData(Uri.parse("tel:" + guest.getPhoneNumber());
         */

        try {
            startActivity(sendIntent);
        } catch(SecurityException sex) {
            Toast.makeText(this, R.string.litsPermissionProblem, Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(this, R.string.litsGeneralProblem, Toast.LENGTH_LONG).show();
        }
    }
}
