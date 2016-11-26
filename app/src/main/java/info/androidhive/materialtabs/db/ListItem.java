package info.androidhive.materialtabs.db;

/**
 * Created by KBPark on 2016. 8. 13..
 */
public class ListItem
{
    private static final int NUM_OF_DATA = 2;

    Object[] mData = new Object[NUM_OF_DATA];

    public ListItem(String title, String date)
    {
        mData[0] = title;
        mData[1] = date;
    }

    public Object getTitle()
    {
        return mData[0];
    }

    public Object getDate()
    {
        return mData[1];
    }

    public Object[] getData()
    {
        return mData;
    }
}
