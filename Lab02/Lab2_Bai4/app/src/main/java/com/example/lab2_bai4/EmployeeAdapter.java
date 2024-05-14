package com.example.lab2_bai4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Bai4_Employee> {
    private Activity context=null;
    private int layoutID;
    private List<Bai4_Employee> objects=null;
    public EmployeeAdapter(Activity context, int layoutID, List<Bai4_Employee>
            objects) {
        super(context, layoutID, objects);
        this.context = context;
        this.layoutID=layoutID;
        this.objects=objects;
    }
    @Override
    public int getCount(){
        return objects.size();
    }
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.item_employee, null,
                            false);
        }
        // Get item
        Bai4_Employee bai4Employee = getItem(position);
        // Get view
        TextView tvFullName = convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView tvPosition = convertView.findViewById(R.id.item_employee_tv_position);
        ImageView ivManager = convertView.findViewById(R.id.item_employee_iv_manager);
        LinearLayout llParent = convertView.findViewById(R.id.item_employee_ll_parent);

        if (bai4Employee.getFullName()!=null) {
            tvFullName.setText(bai4Employee.getFullName());
        }
        else tvFullName.setText("");
        // If this is a manager -> show icon manager. Otherwise, show Staff in tvPosition
        if (bai4Employee.isManager())
        {
            ivManager.setVisibility(View.VISIBLE);
            tvPosition.setVisibility(View.GONE);
        }
        else
        {
            ivManager.setVisibility(View.GONE);
            tvPosition.setVisibility(View.VISIBLE);
            tvPosition.setText(context.getString(R.string.staff));
        }
        // Show different color backgrounds for 2 continuous employees
        if (position%2==0)
        {
            llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            llParent.setBackgroundResource(R.color.light_blue);
        }
        return convertView;
    }
}
