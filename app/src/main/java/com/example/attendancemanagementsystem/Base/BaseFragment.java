package com.example.attendancemanagementsystem.Base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;

public class BaseFragment extends Fragment {

    MaterialDialog dialog;
    protected BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= ((BaseActivity) context);
    }

    public MaterialDialog showMessage(int titleResId, int messageResId, int posResText){
        return activity.showMessageInt(titleResId,messageResId,posResText);

    }
    public MaterialDialog showMessage(String title,String message,String posText){

        return activity.showMessageString(title,message,posText);
    }
    public MaterialDialog showConfirmationMessage(int titleResId,
                                                  int contentResId,
                                                  int posTextResId,
                                                  MaterialDialog.SingleButtonCallback onPos
    ){
        return
                activity.showConfirmationMessageInt(titleResId,contentResId,posTextResId,onPos);

    }

    public MaterialDialog showProgressBar(int titleResId, int contentResId){
        return activity.showProgressBar(titleResId,contentResId);
    }

    public void hideProgressBar(){
        activity.hideProgressBar();
    }


}
