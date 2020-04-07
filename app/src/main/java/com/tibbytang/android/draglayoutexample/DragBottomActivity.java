package com.tibbytang.android.draglayoutexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tibbytang.android.drag.DragLayout;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

public class DragBottomActivity extends AppCompatActivity implements View.OnClickListener, DargItemViewBinder.DragViewClickListener {
    private DragLayout mDragLayout;
    private AppCompatButton mTopView;
    private AppCompatButton mCenterView;
    private AppCompatButton mBottomView;
    private AppCompatButton mThirdView;

    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mMultiTypeAdapter;
    private List<String> mList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        initView();
        initData();
    }


    private void initView() {
        mDragLayout = this.findViewById(R.id.main_drag_layout_view);
        mTopView = this.findViewById(R.id.move_top_view);
        mCenterView = this.findViewById(R.id.move_center_view);
        mBottomView = this.findViewById(R.id.move_bottom_view);
        mThirdView = this.findViewById(R.id.move_third_view);
        mRecyclerView = this.findViewById(R.id.bottom_drag_recycler_view);
        mTopView.setOnClickListener(this);
        mCenterView.setOnClickListener(this);
        mBottomView.setOnClickListener(this);
        mThirdView.setOnClickListener(this);
        mDragLayout.addDragStateListener(new DragLayout.DragStateListener() {
            @Override
            public void onDragStateChanged(DragLayout.DragState dragState) {
                if (dragState == DragLayout.DragState.DRAG_STATE_LEFT_OPEN) {
                    Toast.makeText(DragBottomActivity.this, "左边面板打开", Toast.LENGTH_SHORT).show();
                }
                if (dragState == DragLayout.DragState.DRAG_STATE_LEFT_CLOSE) {
                    Toast.makeText(DragBottomActivity.this, "左边面板关闭", Toast.LENGTH_SHORT).show();
                }

                if (dragState == DragLayout.DragState.DRAG_STATE_RIGHT_OPEN) {
                    Toast.makeText(DragBottomActivity.this, "右边面板打开", Toast.LENGTH_SHORT).show();
                }
                if (dragState == DragLayout.DragState.DRAG_STATE_RIGHT_CLOSE) {
                    Toast.makeText(DragBottomActivity.this, "右边面板关闭", Toast.LENGTH_SHORT).show();
                }

                if (dragState == DragLayout.DragState.DRAG_STATE_TOP_OPEN) {
                    Toast.makeText(DragBottomActivity.this, "顶部面板打开", Toast.LENGTH_SHORT).show();
                }
                if (dragState == DragLayout.DragState.DRAG_STATE_TOP_CLOSE) {
                    Toast.makeText(DragBottomActivity.this, "顶部面板关闭", Toast.LENGTH_SHORT).show();
                }

                if (dragState == DragLayout.DragState.DRAG_STATE_BOTTOM_OPEN) {
                    Toast.makeText(DragBottomActivity.this, "底部面板打开", Toast.LENGTH_SHORT).show();
                }
                if (dragState == DragLayout.DragState.DRAG_STATE_BOTTOM_CLOSE) {
                    Toast.makeText(DragBottomActivity.this, "底部面板关闭", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onDragEdgeChanged(DragLayout.DragEdgeState dragEdgeState) {
                if (dragEdgeState == DragLayout.DragEdgeState.DRAG_STATE_BOTTOM_TO_TOP_EDGE) {
                    Toast.makeText(DragBottomActivity.this, "滑动到顶部", Toast.LENGTH_SHORT).show();
                }
                if (dragEdgeState == DragLayout.DragEdgeState.DRAG_STATE_TOP_TO_BOTTOM_EDGE) {
                    Toast.makeText(DragBottomActivity.this, "滑动到底部", Toast.LENGTH_SHORT).show();
                }
                if (dragEdgeState == DragLayout.DragEdgeState.DRAG_STATE_LEFT_TO_RIGHT_EDGE) {
                    Toast.makeText(DragBottomActivity.this, "滑动到右边", Toast.LENGTH_SHORT).show();
                }
                if (dragEdgeState == DragLayout.DragEdgeState.DRAG_STATE_RIGHT_TO_LEFT_EDGE) {
                    Toast.makeText(DragBottomActivity.this, "滑动到左边", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onDragViewClick(View view,int position, boolean isOpen) {

            }
        });
    }

    private void initData() {
        mMultiTypeAdapter = new MultiTypeAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMultiTypeAdapter.register(String.class, new DargItemViewBinder(this));

        mList.add("Java开发");
        mList.add("android开发");
        mList.add("kotlin开发");
        mList.add("go 开发");
        mList.add("rust 开发");
        mList.add("php 开发");
        mList.add("python 开发");
        mList.add("javascript 开发");
        mList.add("html 开发");
        mList.add("css 开发");
        mList.add("typescript 开发");
        mList.add("ruby 开发");
        mList.add("spring 开发");
        mList.add("ktor 开发");
        mMultiTypeAdapter.setItems(mList);
        mRecyclerView.setAdapter(mMultiTypeAdapter);
    }

    @Override
    public void onClick(View v) {

        if (v == mTopView) {
            mDragLayout.moveBottomViewWithRatio(1.0f);
        }
        if (v == mBottomView) {
            mDragLayout.moveBottomViewWithRatio(0.0f);
        }
        if (v == mCenterView) {
            mDragLayout.moveBottomViewWithRatio(1.0f / 2.0f);
        }
        if (v == mThirdView) {
            mDragLayout.moveBottomViewWithRatio(1.0f / 3.0f);
        }
    }

    @Override
    public void onDragViewClick(int position) {
        Toast.makeText(this, mList.get(position), Toast.LENGTH_SHORT).show();
    }
}