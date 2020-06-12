package com.example.notification.sync;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;



import java.util.concurrent.TimeUnit;



public class ReminderUtilities {


    private static final int REMINDER_INTERVAL_MINUTES = 1;
    private static final int REMINDER_INTERVAL_SECONDS = (int) (TimeUnit.MINUTES.toSeconds(REMINDER_INTERVAL_MINUTES));
    private static final int SYNC_FLEXTIME_SECONDS = REMINDER_INTERVAL_SECONDS;

    private static final String REMINDER_JOB_TAG = "hydration_reminder_tag";

    private static boolean sInitialized;

    public static void scheduleChargingReminder( Context context) {

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .build();



        PeriodicWorkRequest request =
                // Executes MyWorker every 15 minutes
                new PeriodicWorkRequest.Builder(MyWorker.class, 15, TimeUnit.MINUTES)
                        .setConstraints(constraints)
                        .build();

        WorkManager.getInstance(context).enqueueUniquePeriodicWork("request",ExistingPeriodicWorkPolicy.REPLACE,request);

//        Driver driver = new GooglePlayDriver(context);
//        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);
//
//        /* Create the Job to periodically create reminders to drink water */
//        Job constraintReminderJob = dispatcher.newJobBuilder()
//                /* The Service that will be used to write to preferences */
//                .setService(WaterReminderFirebaseJobService.class)
//                /*
//                 * Set the UNIQUE tag used to identify this Job.
//                 */
//                .setTag(REMINDER_JOB_TAG)
//                /*
//                 * Network constraints on which this Job should run. In this app, we're using the
//                 * device charging constraint so that the job only executes if the device is
//                 * charging.
//                 *
//                 * In a normal app, it might be a good idea to include a preference for this,
//                 * as different users may have different preferences on when you should be
//                 * syncing your application's data.
//                 */
//                .setConstraints(Constraint.DEVICE_CHARGING)
//                /*
//                 * setLifetime sets how long this job should persist. The options are to keep the
//                 * Job "forever" or to have it die the next time the device boots up.
//                 */
//                .setLifetime(Lifetime.FOREVER)
//                /*
//                 * We want these reminders to continuously happen, so we tell this Job to recur.
//                 */
//                .setRecurring(true)
//                /*
//                 * We want the reminders to happen every 15 minutes or so. The first argument for
//                 * Trigger class's static executionWindow method is the start of the time frame
//                 * when the
//                 * job should be performed. The second argument is the latest point in time at
//                 * which the data should be synced. Please note that this end time is not
//                 * guaranteed, but is more of a guideline for FirebaseJobDispatcher to go off of.
//                 */
//                .setTrigger(Trigger.executionWindow(
//                        REMINDER_INTERVAL_SECONDS,
//                        REMINDER_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS))
//                /*
//                 * If a Job with the tag with provided already exists, this new job will replace
//                 * the old one.
//                 */
//                .setReplaceCurrent(true)
//                /* Once the Job is ready, call the builder's build method to return the Job */
//                .build();
//
//        /* Schedule the Job with the dispatcher */
//        dispatcher.schedule(constraintReminderJob);

        /* The job has been initialized */

    }

}
