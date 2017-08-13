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
import com.akturk.cv.design.molecule.DotMolecule;
import com.akturk.cv.model.Language;
import com.akturk.cv.ui.base.BaseFragment;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.store.DataStore;
import com.kinvey.java.store.StoreType;

import java.util.List;


public class LanguagesTemplate extends BaseFragment implements Template {

    private RecyclerView _list;

    @Override protected int getLayoutResId() {
        return R.layout.template_languages;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        _list = layout.findViewById(R.id.languages_list);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadExperinces();
    }

    public void loadExperinces() {
        DataStore<Language> collection = DataStore.collection("languages", Language.class, StoreType.NETWORK, Client.sharedInstance());
        collection.find(new KinveyListCallback<Language>() {
            @Override public void onSuccess(List<Language> list) {
                _list.setLayoutManager(new LinearLayoutManager(getContext()));
                _list.setAdapter(new Adapter(list));
            }

            @Override public void onFailure(Throwable throwable) {
            }
        });
    }

    private final static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<Language> _languages;

        private Adapter(List<Language> education) {
            _languages = education;
        }

        @Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row_language, parent, false);

            return new Holder(row);
        }

        @Override public void onBindViewHolder(Holder holder, int position) {
            Language language = _languages.get(position);

            holder._card.setBold(language._content);
        }

        @Override public int getItemCount() {
            return _languages.size();
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
