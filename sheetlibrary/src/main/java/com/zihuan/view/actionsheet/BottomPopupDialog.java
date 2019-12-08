//package com.zihuan.view.actionsheet;
//
//import android.content.Context;
//import android.graphics.drawable.BitmapDrawable;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnTouchListener;
//import android.view.WindowManager;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class BottomPopupDialog {
//    public PopupWindow mPopupWindow;
//
//    RecyclerView recycleView;
//    TextView tvDismiss;
//
//    BottomSheetAdapter mBottomAdapter;
//    List<String> mFieldList = new ArrayList<>();
//    private Context mContext;
//    View showAsDropDown;
//
//    @SuppressWarnings("deprecation")
//    public BottomPopupDialog(Context context, View rootView, ViewOnItemClick onItemClick) {
//        View view = LayoutInflater.from(context).inflate(R.layout.sheet_list_layout, null);
//        recycleView = view.findViewById(R.id.recycleView);
//        tvDismiss = view.findViewById(R.id.tv_dismiss);
//        showAsDropDown = rootView;
//        mContext = context;
//        mPopupWindow = new PopupWindow(context);
//        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
//        mPopupWindow.setWidth(WindowManager.LayoutParams.FILL_PARENT);
//        mPopupWindow.setHeight(WindowManager.LayoutParams.FILL_PARENT);
//        mPopupWindow.setTouchable(true);
//        mPopupWindow.setFocusable(true);
//        mPopupWindow.setOutsideTouchable(true);
//        mPopupWindow.setContentView(view);
//        // 第一个参数是要将PopupWindow放到的View，第二个参数是位置，第三第四是偏移值
//        RecycleLayout.INSTANCE.initVertical(recycleView);
//        mBottomAdapter = new BottomSheetAdapter( context);
//        recycleView.setAdapter(mBottomAdapter);
//        mPopupWindow.getContentView().setOnTouchListener(new OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                mPopupWindow.setFocusable(false);
//                mPopupWindow.dismiss();
//                return true;
//            }
//        });
//    }
//
//    public void setData(List<String> list) {
//        mFieldList.addAll(list);
//        mBottomAdapter.update(mFieldList);
//    }
//
//    public void dismiss() {
//        if (mPopupWindow != null && mPopupWindow.isShowing()) {
//            mPopupWindow.dismiss();
//        }
//    }
//
//    public void showPopup() {
//        mPopupWindow.showAtLocation(showAsDropDown, Gravity.BOTTOM, 0, 0);
//    }
//}
