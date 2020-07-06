package com.edison.algorithm.core.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * @Description TODO
 * @Date 2020/5/13下午11:05
 * @Created by edsiongeng
 */
@Slf4j
public class CustomRecursiveAction extends RecursiveAction {
    private String workload = "";
    private final static int THRESHOLD = 4;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }


    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {

        }

    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());
        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));
        return subtasks;

    }


    private void processing(String work) {
        String result = work.toUpperCase();
        log.info(" this was procssed by " + Thread.currentThread().getName());
    }
}
