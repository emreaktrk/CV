package com.akturk.cv.design.template;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akturk.cv.R;
import com.akturk.cv.design.molecule.BulletMolecule;
import com.akturk.cv.model.Link;
import com.akturk.cv.ui.base.BaseFragment;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.store.DataStore;
import com.kinvey.java.store.StoreType;

import java.util.List;


public class LinksTemplate extends BaseFragment implements Template {

    private RecyclerView _list;

    @Override protected int getLayoutResId() {
        return R.layout.template_links;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        _list = layout.findViewById(R.id.links_list);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadExperinces();
    }

    public void loadExperinces() {
        DataStore<Link> collection = DataStore.collection("links", Link.class, StoreType.NETWORK, Client.sharedInstance());
        collection.find(new KinveyListCallback<Link>() {
            @Override public void onSuccess(List<Link> list) {
                _list.setLayoutManager(new LinearLayoutManager(getContext()));
                _list.setAdapter(new Adapter(list));
            }

            @Override public void onFailure(Throwable throwable) {
            }
        });
    }

    private final static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<Link> _links;

        private Adapter(List<Link> links) {
            _links = links;
        }

        @Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row_links, parent, false);

            return new Holder(row);
        }

        @Override public void onBindViewHolder(Holder holder, int position) {
            Link link = _links.get(position);

            holder._card.setBold(link._endpoint + link._resource);
        }

        @Override public int getItemCount() {
            return _links.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            private BulletMolecule _card;

            Holder(View itemView) {
                super(itemView);

                _card = (BulletMolecule) itemView;
            }
        }
    }
}
