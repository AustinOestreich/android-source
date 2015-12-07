package io.bloc.android.blocly.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;

/**
 * Created by Austin on 12/6/2015.
 */
public class RssItemListFragment extends Fragment implements ItemAdapter.DataSource {

    @Override
    public RssItem getRssItem(ItemAdapter itemAdapter, int position) {
        return null;
    }

    @Override
    public RssFeed getRssFeed(ItemAdapter itemAdapter, int position) {
        return null;
    }

    @Override
    public int getItemCount(ItemAdapter itemAdapter) {
        return 0;
    }

    public static interface Delegate{
        public void onItemExpanded(RssItemListFragment rssItemListFragment, RssItem rssItem);
        public void onItemContracted(RssItemListFragment rssItemListFragment,RssItem rssItem);
        public void onItemVisitClicked(RssItemListFragment rssItemListFragment, RssItem rssItem);
    }

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    private RssFeed currentFeed;
    private List<RssItem> currentItems = new ArrayList<RssItem>();
    private WeakReference<Delegate> delegate;



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // #6
        delegate = new WeakReference<Delegate>((Delegate) activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemAdapter = new ItemAdapter();
        itemAdapter.setDataSource(this);
        itemAdapter.setDelegate(this);
    }


}
