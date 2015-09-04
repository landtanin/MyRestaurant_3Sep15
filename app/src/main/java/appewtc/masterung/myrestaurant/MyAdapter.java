package appewtc.masterung.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 9/4/15 AD.
 */
public class MyAdapter extends BaseAdapter{

    private Context objContext;
    private String[] iconStrings, foodStrings, priceStrings;

    public MyAdapter(Context objContext, String[] iconStrings, String[] foodStrings, String[] priceStrings) {
        this.objContext = objContext;
        this.iconStrings = iconStrings;
        this.foodStrings = foodStrings;
        this.priceStrings = priceStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = objLayoutInflater.inflate(R.layout.food_listview, viewGroup, false);

        //Show Icon
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imvIcon);
        Picasso.with(objContext).load(iconStrings[i]).resize(60,60).into(iconImageView);

        //Show Food
        TextView foodTextView = (TextView) view1.findViewById(R.id.txtShowFood);
        foodTextView.setText(foodStrings[i]);

        //Show Price
        TextView priceTextView = (TextView) view1.findViewById(R.id.txtShowPrice);
        priceTextView.setText(priceStrings[i]);

        return view1;
    }   // getView
}   // Main Class
