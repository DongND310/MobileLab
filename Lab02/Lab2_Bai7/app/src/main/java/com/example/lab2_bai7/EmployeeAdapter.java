package com.example.lab2_bai7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Employee> employees;
    public EmployeeAdapter(Context context, ArrayList<Employee>
            objects) {
        this.context = context;
        this.employees = objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View employeeView = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(employeeView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.text_name.setText(employee.getFullName());
        if (employee.isManager())
        {
            holder.image_Manager.setVisibility(View.VISIBLE);
            holder.text_position.setVisibility(View.GONE);
        }
        else
        {
            holder.image_Manager.setVisibility(View.GONE);
            holder.text_position.setVisibility(View.VISIBLE);
            holder.text_position.setText(context.getString(R.string.staff));
        }
        if (position%2==0)
        {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_name;
        private TextView text_position;
        private ImageView image_Manager;
        private LinearLayout llParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.item_employee_tv_fullname);
            text_position = itemView.findViewById(R.id.item_employee_tv_position);
            image_Manager = itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = itemView.findViewById(R.id.item_employee_ll_parent);
        }
    }
}