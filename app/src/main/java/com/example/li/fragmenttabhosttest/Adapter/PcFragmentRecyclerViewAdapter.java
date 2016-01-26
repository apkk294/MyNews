package com.example.li.fragmenttabhosttest.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.li.fragmenttabhosttest.Bean.PcFragmentItemBean;
import com.example.li.fragmenttabhosttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.li on 2016/1/25.
 */
public class PcFragmentRecyclerViewAdapter extends RecyclerView.Adapter
        implements View.OnClickListener {

    private List<PcFragmentItemBean> mItems = new ArrayList<>();

    private Context mContext;

    private MyViewHolder viewHolder;

    private OnRecyclerViewItemClickListener mItemListener = null;

    public PcFragmentRecyclerViewAdapter(List<PcFragmentItemBean> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }

    @Override
    public void onClick(View v) {
        mItemListener.onItemClick(v, (int)v.getTag());
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener){
        mItemListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.pc_recyclerview_viewholder, parent, false);
        viewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mvh = (MyViewHolder) holder;
        mvh.getIvImage().setImageResource(mItems.get(position).getImage());
        mvh.getTvFirText().setText(mItems.get(position).getFirText());
        mvh.getTvSecText().setText(mItems.get(position).getSecText());
        mvh.itemView.setTag(position);
        switch (position) {
            case 0:
            case 1:
            case 4:
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) mvh.itemView.getLayoutParams();
                lp.setMargins(0,10,0,0);
                mvh.itemView.setLayoutParams(lp);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private View rootView;
        private TextView tvFirText, tvSecText;
        private ImageView ivImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            this.tvFirText = (TextView) rootView.findViewById(R.id.tvPcRvViewHolderFirText);
            this.tvSecText = (TextView) rootView.findViewById(R.id.tvPcRvViewHolderSecText);
            this.ivImage = (ImageView) rootView.findViewById(R.id.ivPcRvViewHolderImage);
        }

        public TextView getTvFirText() {
            return tvFirText;
        }

        public TextView getTvSecText() {
            return tvSecText;
        }

        public ImageView getIvImage() {
            return ivImage;
        }

    }

}