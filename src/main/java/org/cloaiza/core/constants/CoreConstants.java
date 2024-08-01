package org.cloaiza.core.constants;

public final class CoreConstants {
  private CoreConstants() {
  }

  public static final String TIMEZONE = "America/Bogota";

  public static final String DATE_ERROR = "Error date";

  public static final String SCHEDULER_CRON = "0 0 0 * * ?";
  public static final String SCHEDULER_INIT = "Init schedule - Date: {}";
  public static final String SCHEDULER_ERROR = "End schedule - Date: {}, ERROR: {}";
  public static final String SCHEDULER_OK = "End schedule - Date: {}, SUCCESS: {}";

  public static final String TRANSACTION_BROKER_OK = "Transaction brokered successfully";
  public static final String TRANSACTION_BROKER_ERROR = "Error brokering transaction";

  public static final String TRANSACTION_CREATE_ERROR = "Error creating transaction";
  public static final String TRANSACTION_CREATE_OK = "Transaction created successfully";

  public static final String TRANSACTION_SUMMARY_EMPTY = "Transaction summary is empty";
  public static final String TRANSACTION_SUMMARY_ERROR = "Error retrieving transaction summary - Error: {}";
  public static final String TRANSACTION_SUMMARY_OK = "Transaction summary retrieved successfully";

}
