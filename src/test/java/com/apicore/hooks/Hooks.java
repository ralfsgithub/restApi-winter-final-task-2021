package com.apicore.hooks;

import cucumber.api.java.After;

import java.io.IOException;

public class Hooks {

    @After("@HookAfterScenrarioExample")
    public static void hookAfterScenrarioExample() throws IOException {
        System.out.println("after scenario hook");
    }
}
