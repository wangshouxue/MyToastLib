package com.example.toastlib;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @auther：wangshouxue
 * @qq:1556090086@qq.com
 * @date： 2019/9/27 10:37
 * @description：类作用描述
 */
public class CusToast {
    private static CusToast mToast;
    private Toast toast;
    private static Context mContext;
    private int textSize=10;
    private boolean isHasImg=false;//是否显示图片
    private int res=-1;//图片资源
//    private int imgLocation=-1;//图片显示的位置，0-文字左边，1-文字顶部，2-文字右边，3-文字底部
    private int location=Gravity.BOTTOM;//弹窗显示的位置

    public CusToast() {
    }
    public static CusToast getToast(Context context) {
        if (mToast == null) {
            mToast = new CusToast();
        }
        mContext = context;
        return mToast;
    }

    public CusToast setTextSize(int textSize) {
        this.textSize = textSize;
        return mToast;
    }

    //弹窗显示的位置，默认底部
    public CusToast setLocation(int location) {
        this.location = location;
        return mToast;
    }

    public CusToast hasImg(boolean isHasImg){
        this.isHasImg=isHasImg;
        return mToast;
    }
    public CusToast setImg(int res){
        this.res=res;
        return mToast;
    }
//    public CusToast setImg(int res,int imgLocation){
//        this.res=res;
//        this.imgLocation=imgLocation;
//        return mToast;
//    }
    /**
     * 显示
     */
    public void ToastShow(String str) {
        View view = null;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        if (isHasImg){
            view=inflater.inflate(R.layout.imgtoast, null);
            ImageView img = (ImageView) view.findViewById(R.id.imgToast);
            img.setImageResource(res); // 设置显示tp
            TextView text = (TextView) view.findViewById(R.id.tv_Toast);
            text.setText(str); // 设置显示文字
            text.setTextSize(textSize);
        }else {
            view=inflater.inflate(R.layout.tvtoast, null);
            TextView text = view.findViewById(R.id.tvToast);
            text.setText(str); // 设置显示文字
            text.setTextSize(textSize);
        }
        toast = new Toast(mContext);
        if (location==Gravity.BOTTOM){
            toast.setGravity(location, 0, 30); // Toast显示的位置
        }else {
            toast.setGravity(location, 0, 0); // Toast显示的位置
        }
        toast.setDuration(Toast.LENGTH_SHORT); // Toast显示的时间
        toast.setView(view);
        toast.show();
    }

    public void ToastCancel() {
        if (toast != null) {
            toast.cancel();
        }
    }
}
