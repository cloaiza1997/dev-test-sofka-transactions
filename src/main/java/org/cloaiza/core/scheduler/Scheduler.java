package org.cloaiza.core.scheduler;

import java.time.LocalDate;
import java.time.ZoneId;

import org.cloaiza.core.constants.CoreConstants;
import org.cloaiza.transactions.controllers.TransactionController;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @see https://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html
 */
@ApplicationScoped
@Slf4j
public class Scheduler {

  @Inject
  TransactionController transactionController;

  @Scheduled(cron = "0 0 0 * * ?", timeZone = CoreConstants.TIMEZONE)
  public void scheduleTransactionDailySummary() {

    String date = LocalDate.now(ZoneId.of(CoreConstants.TIMEZONE)).toString();

    log.info("*** Init schedule - Date: {} ***", date);

    transactionController
        .getTransactionDailySummary(date)
        .subscribe()
        .with(
            result -> log.info("*** End schedule - Date: {}, SUCCESS: {} ***", date, result),
            throwable -> log.error("*** End schedule - Date: {}, ERROR: {} ***", date, throwable));
  }
}
