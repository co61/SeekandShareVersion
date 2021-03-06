package fr.c7regne.seekandsharedrawer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public class AddViewListAnnounce extends AppCompatActivity {
    /***
     * This class create a linear view for a quick viw of the post that the user can read
     * We display here the title, the content, the date, the city, the publisher name
     */

    private final int textColor = Color.BLACK;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    public LinearLayout addAnnounceUser(final Activity activity, String Title, String Date, String City, String DP, String SP, String Content, String UserName, String UserId) {

        //principal linearlayout
        LinearLayout newLL = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        int margin = dpToPx(15, activity.getApplicationContext());
        layoutParams.setMargins(margin, margin, margin, margin);
        newLL.setLayoutParams(layoutParams);
        newLL.setBackgroundResource(R.drawable.corner);
        newLL.setOrientation(LinearLayout.VERTICAL);
        int padding = dpToPx(10, activity.getApplicationContext());
        newLL.setPadding(padding, padding, padding, padding);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            newLL.setElevation(6);
            newLL.setTranslationZ(10);
        }

        //title textview
        TextView textViewTitle = new TextView(activity);
        LinearLayout.LayoutParams title_linear = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewTitle.setLayoutParams(title_linear);
        textViewTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewTitle.setText(Title);
        textViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(9, activity.getApplicationContext()));
        textViewTitle.setTextColor(textColor);


        //linearlayout orientation horizontal for textview DP SP
        LinearLayout LLHoriz = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LLHoriz.setLayoutParams(layoutParams2);
        LLHoriz.setOrientation(LinearLayout.VERTICAL);
        LLHoriz.setOrientation(LinearLayout.HORIZONTAL);

        //DP textview
        TextView textViewDP = new TextView(activity);
        LinearLayout.LayoutParams textViewContentParams2 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewContentParams2.weight = (float) 0.5;
        textViewDP.setLayoutParams(textViewContentParams2);
        textViewDP.setText(DP);
        textViewDP.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(4, activity.getApplicationContext()));
        textViewDP.setTextColor(textColor);

        //SP textview
        TextView textViewSP = new TextView(activity);
        textViewSP.setLayoutParams(textViewContentParams2);
        textViewSP.setText(SP);
        textViewSP.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(4, activity.getApplicationContext()));
        textViewSP.setTextColor(textColor);
        //fin linearLayout
        LLHoriz.addView(textViewDP);
        LLHoriz.addView(textViewSP);

        //Content textview
        TextView textViewContent = new TextView(activity);
        LinearLayout.LayoutParams textViewContentParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(54, activity.getApplicationContext()));
        textViewContent.setLayoutParams(textViewContentParams);
        textViewContent.setText(Content);
        textViewContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(6, activity.getApplicationContext()));
        textViewContent.setTextColor(textColor);

        //linearlayout orientation horizontal for textview date and publisher name
        LinearLayout LLHoriz2 = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LLHoriz.setLayoutParams(layoutParams3);
        LLHoriz.setOrientation(LinearLayout.VERTICAL);
        LLHoriz.setOrientation(LinearLayout.HORIZONTAL);

        //Date textview
        TextView textViewDate = new TextView(activity);
        LinearLayout.LayoutParams textViewDate2 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewDate2.weight = (float) 0.4;
        textViewDate.setLayoutParams(textViewDate2);
        textViewDate.setText(Date);
        textViewDate.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(4, activity.getApplicationContext()));
        textViewDate.setPadding(0, 0, 0, dpToPx(2, activity.getApplicationContext()));
        textViewDate.setTextColor(textColor);

        //Date textview
        TextView textViewPlace = new TextView(activity);
        LinearLayout.LayoutParams textViewplace2 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewplace2.weight = (float) 0.3;
        textViewPlace.setLayoutParams(textViewplace2);
        textViewPlace.setText(City);
        textViewPlace.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(4, activity.getApplicationContext()));
        textViewPlace.setPadding(0, 0, 0, dpToPx(2, activity.getApplicationContext()));
        textViewPlace.setTextColor(textColor);

        //PublisherName
        TextView textViewPublisherName = new TextView(activity);
        textViewPublisherName.setLayoutParams(textViewDate2);
        textViewPublisherName.setText(UserName);
        textViewPublisherName.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        textViewPublisherName.setTextSize(TypedValue.COMPLEX_UNIT_SP, spToPx(4, activity.getApplicationContext()));
        textViewPublisherName.setTextColor(textColor);

        //adding element to view
        LLHoriz2.addView(textViewDate);
        LLHoriz2.addView(textViewPlace);
        LLHoriz2.addView(textViewPublisherName);
        //end linearLayout

        //adding element to view
        newLL.addView(textViewTitle);
        newLL.addView(LLHoriz);
        newLL.addView(textViewContent);
        newLL.addView(LLHoriz2);


        return newLL;
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }



}

