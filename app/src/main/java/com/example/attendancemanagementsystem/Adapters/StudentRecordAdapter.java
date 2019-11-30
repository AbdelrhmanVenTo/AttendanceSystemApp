package com.example.attendancemanagementsystem.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.attendancemanagementsystem.Model.RecordModel.StudentsItem;
import com.example.attendancemanagementsystem.R;

import java.util.List;

public class StudentRecordAdapter extends RecyclerView.Adapter<StudentRecordAdapter.ViewHolder> {

    List<StudentsItem> itemList;

    public StudentRecordAdapter(List<StudentsItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mange_report_item,viewGroup,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        final StudentsItem studentsItem = itemList.get(pos);
        viewHolder.recodrdStudentName.setText(studentsItem.getName());
        viewHolder.recodrdStudentCode.setText(String.valueOf(studentsItem.getSid()));
        if(onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(pos,studentsItem);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(itemList==null)return 0;
        return itemList.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView recodrdStudentName ,recodrdStudentCode ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recodrdStudentName =itemView.findViewById(R.id.name);
            recodrdStudentCode = itemView.findViewById(R.id.code);
        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, StudentsItem studentsItem);
    }
}
