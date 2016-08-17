package io.edgarcode.sort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;

import io.edgarcode.sort.innersort.Sort;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_sort);
        int childCount = layout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = layout.getChildAt(i);
            child.setOnClickListener(this);
        }

    }
    Sort sort = null;
    @Override
    public void onClick(final View v) {

        switch (v.getId()) {
            case R.id.btn_bubble:
                sort = SortFactory.getInstance().createSort("bubble");
                break;
            case R.id.btn_choose:
                sort = SortFactory.getInstance().createSort("choose");
                break;
            case R.id.btn_insert:
                sort = SortFactory.getInstance().createSort("insert");
                break;
            case R.id.btn_quick:
                sort = SortFactory.getInstance().createSort("quick");
                break;
            case R.id.btn_merge:
                sort = SortFactory.getInstance().createSort("merge");
                break;
            case R.id.btn_heap:
                sort = SortFactory.getInstance().createSort("heap");
                break;
            case R.id.btn_shell:
                sort = SortFactory.getInstance().createSort("shell");
                break;
            case R.id.btn_radix:
                sort = SortFactory.getInstance().createSort("radix");
                break;
            case R.id.btn_binarytree:
                sort = SortFactory.getInstance().createSort("binarytree");
                break;
            case R.id.btn_counting:
                sort = SortFactory.getInstance().createSort("counting");
                break;
            default:
                break;

        }
        Observable.just(sort)
                .map(new Func1<Sort, Long>() {
                    @Override
                    public Long call(Sort sort) {
                        Log.i(sort.getClass().getSimpleName(), "sort before " + Arrays.toString(sort.data));
                        long startTime = System.currentTimeMillis();
                        sort.exec();
                        long endTime = System.currentTimeMillis();
                        Log.i(sort.getClass().getSimpleName(), "sort after " + Arrays.toString(sort.data));
                        return new Long(endTime - startTime);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Toast.makeText(getApplicationContext(), "用时"+aLong.longValue()+"毫秒", Toast.LENGTH_LONG).show();
                        Button btn = (Button)v;
                        String sourceText = btn.getText().toString();
                        int endIndex = sourceText.indexOf("[");
                        endIndex = endIndex == -1 ? sourceText.length() : endIndex;
                        sourceText = new String(sourceText.substring(0,endIndex));
                        StringBuilder sb = new StringBuilder(sourceText).append("[").append(aLong.longValue()).append("ms]");
                        btn.setText(sb.toString());
                    }
                });
    }
}
