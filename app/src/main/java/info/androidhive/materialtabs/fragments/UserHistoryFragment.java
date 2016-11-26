package info.androidhive.materialtabs.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;

import info.androidhive.materialtabs.R;
import info.androidhive.materialtabs.db.DBAdapter;
import info.androidhive.materialtabs.db.ListDbHelper;
import info.androidhive.materialtabs.db.ListItem;


public class UserHistoryFragment extends android.support.v4.app.Fragment
{
    //--------- UserHistoryFragment ------//
    ListDbHelper helper;
    SQLiteDatabase db;

    ListView mListView;
    SwipeMenuCreator creator;

    static DBAdapter mAdapter;



    public UserHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.user_list, null);


        mListView = (ListView) view.findViewById(R.id.listView);


// -------------------------------- db open하고 CursorAdapter 초기화 -------------------------------------
        helper = new ListDbHelper(container.getContext(), "ListDB", null, 1);
        db = helper.getWritableDatabase(); //db open!

        String SELECT_SQL = "SELECT * FROM " + "ListTable";

        /**
         *  CursorAdapter의 인자로 보낼 Cursor객체.
         */
        Cursor cursor = db.rawQuery(SELECT_SQL, null);

        mAdapter = new DBAdapter(container.getContext(), cursor, true);
// ----------------------------------------------------------------------------------------------------


        // 4. listView에 adapter set
        mListView.setAdapter(mAdapter); // SwipeMenuListView 객체를 사용합니다!

        return view;


    }




//////////ffff////////////////////////////////////////////////////////////////////////////////
    public static void setListData(String title, String date)
    {
        ListItem aItem = new ListItem(title, date);
        mAdapter.addItemToDb(aItem);

    }

    private void deleteAll()
    {
        mAdapter.removeAllItem();
    }

    private void initCreator()
    {
        creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(getContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
                // set item width
                openItem.setWidth(dp2px(80));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);



                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(80));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
    }


    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getContext().getResources().getDisplayMetrics());
    }


}
