package info.androidhive.materialtabs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import info.androidhive.materialtabs.R;


public class UserTrashFragment extends Fragment implements View.OnClickListener
{
    TextView textTotal;
    TextView text100L;
    TextView text50L;
    TextView text10L;

    Button plus100L;
    Button plus50L;
    Button plus10L;

    Button minus100L;
    Button minus50L;
    Button minus10L;

    private int count100L;
    private int count50L;
    private int count10L;

    public UserTrashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //View view = inflater.inflate(R.layout.user_trash, container, false);
        View view = inflater.inflate(R.layout.user_trash, null);

        textTotal = (TextView) view.findViewById(R.id.textTotal);
        text100L = (TextView) view.findViewById(R.id.text100L);
        text50L = (TextView) view.findViewById(R.id.text50L);
        text10L = (TextView) view.findViewById(R.id.text10L);

        plus100L = (Button) view.findViewById(R.id.plus100L);
        plus50L = (Button) view.findViewById(R.id.plus50L);
        plus10L = (Button) view.findViewById(R.id.plus10L);
        minus100L = (Button) view.findViewById(R.id.minus100L);
        minus50L = (Button) view.findViewById(R.id.minus50L);
        minus10L = (Button) view.findViewById(R.id.minus10L);

        plus100L.setOnClickListener(this);
        plus50L.setOnClickListener(this);
        plus10L.setOnClickListener(this);
        minus100L.setOnClickListener(this);
        minus50L.setOnClickListener(this);
        minus10L.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    public int getTotal()
    {
        return (count100L * 100) + (count50L * 50) + (count10L * 10);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.plus100L : text100L.setText("" + (++count100L)); break;
            case R.id.minus100L :
                if((count100L > 0) && (getTotal() > 0))
                {
                    text100L.setText("" + (--count100L));
                }
                break;
            case R.id.plus50L : text50L.setText("" + (++count50L)); break;
            case R.id.minus50L :
                if((count50L > 0) && (getTotal() > 0))
                {
                    text50L.setText("" + (--count50L));
                }
                break;

            case R.id.plus10L : text10L.setText("" + (++count10L)); break;
            case R.id.minus10L :
                if((count10L > 0) && (getTotal() > 0))
                {
                    text10L.setText("" + (--count10L));
                }
                break;
        }

        textTotal.setText("" + getTotal());
    }
}
