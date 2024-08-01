package org.cloaiza.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
  private DateUtils() {
  }

  public static final Date getDate(String date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    try {
      return formatter.parse(date);
    } catch (ParseException e) {
      return null;
    }
  }
}
