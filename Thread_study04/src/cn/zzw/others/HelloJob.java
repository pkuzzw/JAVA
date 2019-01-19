package cn.zzw.others;
/**
 * 任务
 * @author zzw
 */


import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
        throws JobExecutionException {
    	System.out.println("-------------Start-------------");
        System.out.println("Hello World! - " + new Date());
    	System.out.println("-------------Start-------------");

    }

}
