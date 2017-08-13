package com.akturk.cv.design.template;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akturk.cv.R;
import com.akturk.cv.design.molecule.TopicMolecule;
import com.akturk.cv.model.Certification;
import com.akturk.cv.model.Course;
import com.akturk.cv.ui.base.BaseFragment;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.store.DataStore;
import com.kinvey.java.store.StoreType;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;


public class CoursesAndCertificationsTemplate extends BaseFragment implements Template {

    private RecyclerView _list;

    @Override protected int getLayoutResId() {
        return R.layout.template_coursesandcertifications;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        _list = layout.findViewById(R.id.coursesandcertifications_list);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData();
    }

    private void loadData() {
        Observable
                .zip(
                        Observable.create(new Observable.OnSubscribe<List<Course>>() {
                            @Override public void call(Subscriber<? super List<Course>> subscriber) {
                                loadCourses(subscriber);
                            }
                        }),
                        Observable.create(new Observable.OnSubscribe<List<Certification>>() {
                            @Override public void call(Subscriber<? super List<Certification>> subscriber) {
                                loadCertifications(subscriber);
                            }
                        }),
                        new Func2<List<Course>, List<Certification>, List<Object>>() {
                            @Override public List<Object> call(List<Course> courses, List<Certification> certifications) {
                                ArrayList<Object> list = new ArrayList<>();
                                list.addAll(courses);
                                list.addAll(certifications);
                                return list;
                            }
                        })
                .subscribe(new Subscriber<List<Object>>() {
                    @Override public void onCompleted() {

                    }

                    @Override public void onError(Throwable e) {

                    }

                    @Override public void onNext(List<Object> objects) {
                        _list.setLayoutManager(new LinearLayoutManager(getContext()));
                        _list.setAdapter(new Adapter(objects));
                    }
                })
                .unsubscribe();
    }

    private void loadCourses(final Subscriber<? super List<Course>> subscriber) {
        DataStore<Course> collection = DataStore.collection("courses", Course.class, StoreType.NETWORK, Client.sharedInstance());
        collection.find(new KinveyListCallback<Course>() {
            @Override public void onSuccess(List<Course> list) {
                subscriber.onNext(list);
                subscriber.unsubscribe();
            }

            @Override public void onFailure(Throwable throwable) {

            }
        });
    }

    private void loadCertifications(final Subscriber<? super List<Certification>> subscriber) {
        DataStore<Certification> collection = DataStore.collection("certifications", Certification.class, StoreType.NETWORK, Client.sharedInstance());
        collection.find(new KinveyListCallback<Certification>() {
            @Override public void onSuccess(List<Certification> list) {
                subscriber.onNext(list);
                subscriber.unsubscribe();
            }

            @Override public void onFailure(Throwable throwable) {

            }
        });
    }

    private final static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<Object> _coursesandcertifications;

        private Adapter(List<Object> education) {
            _coursesandcertifications = education;
        }

        @Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row_coursesandcertifications, parent, false);

            return new Holder(row);
        }

        @Override public void onBindViewHolder(Holder holder, int position) {
            Object object = _coursesandcertifications.get(position);

            if (object instanceof Course) {
                Course course = (Course) object;
                holder._card.setBold(course._content);
                holder._card.setCompleter(" at " + course._company);
            } else if (object instanceof Certification) {
                Certification certification = (Certification) object;
                holder._card.setBold(certification._content);
                holder._card.setCompleter(" at " + certification._company);
            }
        }

        @Override public int getItemCount() {
            return _coursesandcertifications.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            private TopicMolecule _card;

            Holder(View itemView) {
                super(itemView);

                _card = (TopicMolecule) itemView;
            }
        }
    }
}
