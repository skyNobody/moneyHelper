package com.example.apptest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptest.R;
import com.example.apptest.bean.Tenant;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class TenantAdapter extends RecyclerView.Adapter<TenantAdapter.ViewHolder>{

    private List<Tenant> tenants;

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tenant_item, parent, false);
        TenantAdapter.ViewHolder viewHolder = new TenantAdapter.ViewHolder(view);
        return viewHolder;
    }

    public TenantAdapter(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tenant tenant = tenants.get(position);
        holder.roomId.setText(tenant.getRoomId());
        holder.rentName.setText(tenant.getName());
    }

    @Override
    public int getItemCount() {
        if (tenants == null) {
            return 0;
        }
        return tenants.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView roomId;
        TextView rentName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roomId = itemView.findViewById(R.id.leftTentAntText);
            rentName = itemView.findViewById(R.id.rightTentAntText);
        }
    }
}
