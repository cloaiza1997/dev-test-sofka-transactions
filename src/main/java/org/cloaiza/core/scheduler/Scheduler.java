package org.cloaiza.core.scheduler;

import java.time.LocalDate;
import java.time.ZoneId;

import org.cloaiza.core.constants.CoreConstants;
import org.cloaiza.core.utils.LogUtils;
import org.cloaiza.transactions.controllers.TransactionController;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * @see https://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html
 */
@ApplicationScoped
public class Scheduler {

  @Inject
  TransactionController transactionController;

  @Scheduled(cron = CoreConstants.SCHEDULER_CRON, timeZone = CoreConstants.TIMEZONE)
  public void scheduleTransactionDailySummary() {

    String date = LocalDate.now(ZoneId.of(CoreConstants.TIMEZONE)).toString();

    LogUtils.info(CoreConstants.SCHEDULER_INIT, date);

    transactionController
        .getTransactionDailySummary(date)
        .subscribe()
        .with(
            result -> LogUtils.info(CoreConstants.SCHEDULER_OK, date, result),
            throwable -> LogUtils.error(CoreConstants.SCHEDULER_ERROR, date, throwable));
  }
}
