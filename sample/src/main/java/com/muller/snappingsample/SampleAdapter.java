package com.muller.snappingsample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private List<String> items;
	private List<Integer> colors;

	public SampleAdapter(List<String> items) {
		this.items = items;

		colors = new ArrayList<>();
		colors.add(Color.RED);
		colors.add(Color.CYAN);
		colors.add(Color.YELLOW);
		colors.add(Color.GREEN);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LinearLayout view = new LinearLayout(parent.getContext());
		TextView textView = new TextView(parent.getContext());
		textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
		textView.setTypeface(null, Typeface.BOLD);

		view.addView(textView);
		view.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
		view.setGravity(Gravity.CENTER 	);
		return new ItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder recyclerViewHolder, int position) {
		ItemViewHolder viewHolder = (ItemViewHolder)recyclerViewHolder;
		LinearLayout view = (LinearLayout)viewHolder.itemView;

		int backgroundColor = colors.get(position % colors.size());
		view.setBackgroundColor(backgroundColor);

		viewHolder.textView.setText(items.get(position));
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	protected class ItemViewHolder extends RecyclerView.ViewHolder {
		protected TextView textView;

		public ItemViewHolder(View itemView) {
			super(itemView);
			textView = (TextView)((ViewGroup)itemView).getChildAt(0);
		}
	}
}
