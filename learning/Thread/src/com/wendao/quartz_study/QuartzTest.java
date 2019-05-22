package com.wendao.quartz_study;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * quartz learning
 * 
 * @author china
 *
 */
public class QuartzTest {

  public void run() throws Exception {

    // 1. First we must get a reference to a scheduler
    SchedulerFactory sf = new StdSchedulerFactory();
    // 2. 从工厂中获取 调度器
    Scheduler sched = sf.getScheduler();

    
    // computer a time that is on the next round minute
    Date runTime = evenMinuteDate(new Date());


    // 3. define the job and tie it to our HelloJob class
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    // 4. Trigger the job to run on the next round minute
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // 5. Tell quartz to schedule the job using our trigger
    sched.scheduleJob(job, trigger);
    System.out.println(job.getKey() + " will run at: " + runTime);

    // 6. Start up the scheduler (nothing can actually run until the
    // scheduler has been started)
    sched.start();


    // wait long enough so that the scheduler as an opportunity to
    // run the job!
    try {
      // wait 5 seconds to show job
      Thread.sleep(5L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }

    // shut down the scheduler
    System.out.println("------- Shutting Down ---------------------");
    sched.shutdown(true);
    System.out.println("------- Shutdown Complete -----------------");
  }

  public static void main(String[] args) throws Exception {

    QuartzTest example = new QuartzTest();
    example.run();

  }

}

