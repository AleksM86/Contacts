package org.example;

import org.springframework.stereotype.Component;

@Component
public class ProfileWorker {
    private final StartWork startWork;

    public ProfileWorker(StartWork startWork) {
        this.startWork = startWork;
    }
    public void doWork(){
        startWork.startWork();
    }
}
