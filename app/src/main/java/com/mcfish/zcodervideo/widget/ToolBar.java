package com.mcfish.zcodervideo.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcfish.zcodervideo.R;


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/7/5
 * Description : 标题栏
 */


public class ToolBar extends RelativeLayout {
    private ImageView ivTopBarLeft;
    private TextView tvTopBarTitle;
    private TextView tvTopBarRight;
    private ImageView ivTopBarRight;


    public ToolBar(Context context) {
        this(context, null);
    }

    public ToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void initView() {
        ivTopBarLeft = findViewById(R.id.ivTopBarLeft);
        tvTopBarTitle = findViewById(R.id.tvTopBarTitle);
        tvTopBarRight = findViewById(R.id.tvTopBarRight);
        ivTopBarRight = findViewById(R.id.ivTopBarRight);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public ToolBar setTitle(String title) {
        tvTopBarTitle.setText(title);
        return this;
    }

    /**
     * 设置左边的icon
     *
     * @param id
     * @return
     */
    public ToolBar setLefticon(@DrawableRes int id) {
        ivTopBarLeft.setImageResource(id);
        return this;
    }

    /**
     * 设置右边的图标
     *
     * @param id
     * @return
     */
    public ToolBar setRighticon(@DrawableRes int id) {
        ivTopBarRight.setImageResource(id);
        return this;
    }

    /**
     * 设置右边显示的文字
     *
     * @param title
     * @return
     */
    public ToolBar setRightText(String title) {
        tvTopBarRight.setText(title);
        return this;
    }

    /**
     * 是否显示右边的文字
     *
     * @param isvisible
     * @return
     */
    public ToolBar showRightText(boolean isvisible) {
        tvTopBarRight.setVisibility(isvisible ? VISIBLE : GONE);
        return this;
    }

    /**
     * 是否显示右边的icon
     *
     * @param isvisible
     * @return
     */
    public ToolBar showRightImage(boolean isvisible) {
        ivTopBarRight.setVisibility(isvisible ? VISIBLE : GONE);
        return this;
    }

    /**
     * 是否显示左边的icon
     *
     * @param isvisible
     * @return
     */
    public ToolBar showLeftImage(boolean isvisible) {
        ivTopBarLeft.setVisibility(isvisible ? VISIBLE : GONE);
        return this;
    }

    public ToolBar setOnLeftImageListener(final OnLeftImageListener leftImageListener) {
        ivTopBarLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                leftImageListener.onClick();
            }
        });
        return this;
    }

    public ToolBar setOnRightTextListener(String text, final OnRightTextListener rightTextListener) {
        tvTopBarRight.setVisibility(VISIBLE);
        tvTopBarRight.setText(text);
        tvTopBarRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rightTextListener.onClick();
            }
        });
        return this;
    }

    public ToolBar setOnRightImageListener(final OnRightImageListener rightImageListener) {
        ivTopBarRight.setVisibility(VISIBLE);
        ivTopBarRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                rightImageListener.onClick();
            }
        });
        return this;
    }

    public interface OnLeftImageListener {
        void onClick();
    }

    public interface OnRightTextListener {
        void onClick();
    }

    public interface OnRightImageListener {
        void onClick();
    }

}
