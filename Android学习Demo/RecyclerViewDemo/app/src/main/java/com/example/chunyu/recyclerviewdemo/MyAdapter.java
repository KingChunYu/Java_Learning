package com.example.chunyu.recyclerviewdemo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by chunyu on 16/2/2.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] mDataset;

    private static class ViewHolerType {
        private static int HEADER_VIEWHOLDER = 0;
        private static int TEXTVIEW_VIEWHOLDER = 1;
        private static int IMAGEVIEW_VIEWHOLDER = 2;
    }

    // Provide a reference to the type of views that you are using
    // (custom viewholder)
    public class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public TextViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView;
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView;
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        if (viewType == ViewHolerType.TEXTVIEW_VIEWHOLDER) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.my_text_view, parent, false);
            // set the view's size, margins, paddings and layout parameters

            TextViewHolder vh = new TextViewHolder((TextView) v);
            return vh;
        } else if (viewType == ViewHolerType.IMAGEVIEW_VIEWHOLDER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.my_image_view, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ImageViewHolder vh = new ImageViewHolder(v);
            return vh;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.my_header_view, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ImageViewHolder vh = new ImageViewHolder(v);
            return vh;
        }

    }


    // 如果是Grid样式的话，想添加Header或者Footer的话，可以通过重写下面方法, 其实起作用的是 gridLayoutManager.setSpanSizeLookup,其内部接口返回的数值
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                //返回值代表position对应元素所占GridView的单元格子数
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == ViewHolerType.HEADER_VIEWHOLDER ? 3 : 1;

                }
            });
        }
    }

    // 如果是瀑布流样式（StaggeredGridLayoutManager）可以通过重写下面方法，进行header或者footer的添加
    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            if (holder.getLayoutPosition() == 0) {
                p.setFullSpan(true);
            } else {
                p.setFullSpan(false);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).mTextView.setText(mDataset[position]);
        } else if (holder instanceof ImageViewHolder) {

        } else if (holder instanceof HeaderViewHolder) {
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ViewHolerType.HEADER_VIEWHOLDER;
        }
        return (position % 2) == 0 ? ViewHolerType.IMAGEVIEW_VIEWHOLDER : ViewHolerType.TEXTVIEW_VIEWHOLDER;
    }
}