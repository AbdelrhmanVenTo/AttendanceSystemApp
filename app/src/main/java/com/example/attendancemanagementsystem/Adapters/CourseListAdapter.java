package com.example.attendancemanagementsystem.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Model.ProfessorModel.CoursesItem;
import com.example.attendancemanagementsystem.R;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>{

    List<CoursesItem> coursesItems;

    public CourseListAdapter(List<CoursesItem> coursesItems) {
        this.coursesItems = coursesItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mange_dates_item,viewGroup,false);
        return new CourseListAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        final CoursesItem coursesItem = coursesItems.get(pos);
        viewHolder.dates.setText(coursesItem.getName());
        if(onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(pos,coursesItem);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(coursesItems==null)return 0;
        return coursesItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView dates;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dates=itemView.findViewById(R.id.datesItem);
        }
    }

    CourseListAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, CoursesItem courses);
    }
}
