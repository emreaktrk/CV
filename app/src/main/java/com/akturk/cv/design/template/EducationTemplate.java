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
import com.akturk.cv.model.Education;
import com.akturk.cv.model.Experince;
import com.akturk.cv.ui.base.BaseFragment;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.store.DataStore;
import com.kinvey.java.store.StoreType;

import java.util.List;


public class EducationTemplate extends BaseFragment implements Template {

    private RecyclerView _list;

    @Override protected int getLayoutResId() {
        return R.layout.template_education;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        _list = layout.findViewById(R.id.education_list);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadExperinces();
    }

    public void loadExperinces() {
        DataStore<Education> collection = DataStore.collection("education", Education.class, StoreType.NETWORK, Client.sharedInstance());
        collection.find(new KinveyListCallback<Education>() {
            @Override public void onSuccess(List<Education> list) {
                _list.setLayoutManager(new LinearLayoutManager(getContext()));
                _list.setAdapter(new Adapter(list));
            }

            @Override public void onFailure(Throwable throwable) {

            }
        });
    }

    private final static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<Education> _education;

        private Adapter(List<Education> education) {
            _education = education;
        }

        @Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row_education, parent, false);

            return new Holder(row);
        }

        @Override public void onBindViewHolder(Holder holder, int position) {
            Education education = _education.get(position);

            holder._card.setBold(education._content);
            holder._card.setInfo(education._subcontent);
        }

        @Override public int getItemCount() {
            return _education.size();
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
