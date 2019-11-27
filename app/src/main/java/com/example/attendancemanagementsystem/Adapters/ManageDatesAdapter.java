package com.example.attendancemanagementsystem.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Model.DatesModel.DatesResponse;
import com.example.attendancemanagementsystem.R;

public class ManageDatesAdapter extends  RecyclerView.Adapter<ManageDatesAdapter.ViewHolder> {

    DatesResponse datesResponses;

    public ManageDatesAdapter(DatesResponse datesResponses) {
        this.datesResponses = datesResponses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mange_dates_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        final DatesResponse dates = datesResponses;
        viewHolder.date.setText((dates.getDates())[pos].toString());
        if(onItemClickListener!=null)
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(pos,dates);
                }
            });
    }

    @Override
    public int getItemCount() {
        if(datesResponses==null)return 0;
        return datesResponses.getDates().length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.datesItem);
        }
    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, DatesResponse dates);
    }
}

