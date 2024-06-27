package com.teky.jpfxcrmapp.controller;

import com.teky.jpfxcrmapp.view.AppView;

public abstract class BaseController {

    protected AppView appView;

    public abstract void newActivity();

    public abstract void listActivity();

    public void setAppView(AppView appView) {
        this.appView = appView;
    }
}
