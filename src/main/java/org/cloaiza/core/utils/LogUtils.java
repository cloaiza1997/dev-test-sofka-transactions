package org.cloaiza.core.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {

  private LogUtils() {
  }

  public static void info(String message, Object... arguments) {
    log.info("*** " + message + " ***", arguments);
  }

  public static void error(String message, Object... arguments) {
    log.error("*** " + message + " ***", arguments);
  }
}
