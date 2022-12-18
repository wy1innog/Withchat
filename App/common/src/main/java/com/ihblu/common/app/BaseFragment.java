package com.ihblu.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Description:
 * @Author: wy1in
 * @Date: 2022/12/18
 */
public abstract class BaseFragment extends Fragment {
    private View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            int layId = getContentLayoutId();
            mRoot = inflater.inflate(layId, container, false);
            initWidget(mRoot);
        } else {
            if (mRoot.getParent() != null) {
                ((ViewGroup)mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract int getContentLayoutId();

    protected void initWidget(View root) {

    }

    protected void initData() {

    }

    protected void initArgs(Bundle bundle) {}

    /**
     * 返回按键触发时调用
     * @return 返回True表示我已处理返回逻辑，Activity不用自己finish
     * 返回False表示我没有处理，需要Activity来处理
     */
    public boolean onBackPressed() {
        return false;
    }
}
