package com.example.notification.sync;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.notification.utilities.NotificationUtils;
import com.google.common.util.concurrent.ListenableFuture;

public class MyWorker extends Worker {


    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("Worker","dgdhdgdfg") ;
        ReminderTasks.executeTask(getApplicationContext(), ReminderTasks.ACTION_CHARGING_REMINDER);

        return Result.success();
    }
}
