package org.openjfx;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
  private LocalDate localDate;
  private LocalTime localTime;
  private double expense;
  private double income;

  public Transaction(LocalDate localDate, LocalTime localTime, double expense, double income) {
    this.localDate = localDate;
    this.localTime = localTime;
    this.expense = expense;
    this.income = income;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }
  public LocalTime getLocalTime() {
    return localTime;
  }
  public double getExpense() {
    return expense;
  }
  public double getIncome() {
    return income;
  }




}
