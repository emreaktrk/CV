package com.akturk.cv.design.template;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akturk.cv.R;
import com.akturk.cv.design.molecule.CardMolecule;
import com.akturk.cv.model.Experince;
import com.akturk.cv.ui.base.BaseFragment;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.store.DataStore;
import com.kinvey.java.store.StoreType;

import java.util.List;


public class ExperinceTemplate extends BaseFragment implements Template {

    private RecyclerView _list;

    @Override protected int getLayoutResId() {
        return R.layout.template_experice;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        _list = layout.findViewById(R.id.experince_list);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadExperinces();
    }

    public void loadExperinces() {
        DataStore<Experince> collection = DataStore.collection("experince", Experince.class, StoreType.CACHE, Client.sharedInstance());
        collection.find(new KinveyListCallback<Experince>() {
            @Override public void onSuccess(List<Experince> list) {
                _list.setLayoutManager(new LinearLayoutManager(getContext()));
                _list.setAdapter(new Adapter(list));
            }

            @Override public void onFailure(Throwable throwable) {

            }
        });
    }

    private final static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<Experince> _experinces;

        private Adapter(List<Experince> experinces) {
            _experinces = experinces;
        }

        @Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row_experince, parent, false);

            return new Holder(row);
        }

        @Override public void onBindViewHolder(Holder holder, int position) {
            Experince experince = _experinces.get(position);

            holder._card.setBold(experince._profession);
            holder._card.setCompleter(" at " + experince._company);
            holder._card.setInfo(
                    new StringBuilder()
                            .append(experince._startDate)
                            .append(" - ")
                            .append(experince._endDate)
                            .append(" | ")
                            .append(experince._location));
        }

        @Override public int getItemCount() {
            return _experinces.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            private CardMolecule _card;

            Holder(View itemView) {
                super(itemView);

                _card = (CardMolecule) itemView;
            }
        }
    }
}
