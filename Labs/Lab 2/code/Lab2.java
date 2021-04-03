package code;

public class Lab2 {
	
	/* 50 COMPETENCY POINTS
	 * Question 1: Balance after one day
	 * 
	 * Given a starting loan balance, and an annual interest rate, return
	 * the balance after the interest has been added.
	 * 
	 * Compute a daily rate by dividing the annual rate by the number of days in a year, 365.
	 * 
	 * To compute the new balance, add one to the daily rate, then multiply by the balance.
	 */
	public double question1(double balance, double annualRate) {
		double dailyRate = annualRate / 365;
		double newBalance = (1 + dailyRate) * balance;
		return newBalance;  // change the return value!
	}

	/* **********************************************************************************
	 * THIS ONE IS DONE FOR YOU - STUDY HOW IT IS DEFINED - IT MAY HELP YOU IN QUESTION 4
	 * **********************************************************************************
	 * 0 COMPETENCY POINTS
	 * Question 2: Balance after several days
	 * 
	 * Given a starting loan balance, an annual interest rate, and a number of
	 * days, return the balance after the interest has been added to the balance
	 * after each of those days.
	 * 
	 *  HINT: use a loop and the method from question 1.
	 */
	public double question2(double balance, double rate, int days) {
		for (int i=0; i<days; i=i+1) {
			balance = question1(balance, rate);
		}
		return balance;
	}
	
	/* 50 COMPETENCY POINTS
	 * Question 3: Balance at end of period (payment made at end of period)
	 * 
	 * Given a starting loan balance, an annual interest rate, a number of days,
	 * and a payment that is made at the END of the period, return the remaining
	 * loan balance (i.e. after interest has compounded daily during the period,
	 * and the payment has been deducted at the end).
	 * 
	 * HINT: use the method from question 2
	 * 
	 */
	public double question3(double balance, double rate, int days, double payment) {
			double remainingLoanBalance = question2(balance ,rate , days);
			remainingLoanBalance = remainingLoanBalance - payment; 
		return remainingLoanBalance;  // change the return value!
	}

	/* 50 COMPETENCY POINTS
	 * Question 4: Balance at the end of several periods
	 * 
	 * Given a starting loan balance, an annual interest rate, a number of days,
	 * a payment that is made at the END of the period, and the number of periods,
	 * return the remaining loan balance.
	 * 
	 * HINT: use a loop and the method from question 3.
	 * 
	 */	
	public double question4(double balance, double rate, int daysPerPeriod, double payment, int periods) {
		for (int i = 0;i < periods;i++){
			balance = question3(balance, rate, daysPerPeriod, payment);
		}
		return balance;  // change the return value!
	}

	/* PROFICIENCY
	 * Question 5: How many periods until loan is paid off
	 * 
	 * Determine how many payments need to be made to pay off the entire loan amount.
	 * 
	 *  Determine how many payments are needed by repeated making payments as long as the
	 *  balance is greater than zero.  Once the balance is zero or negative, return the
	 *  number of payments that were made.
	 *  
	 */	
	public int question5(double balance, double rate, int daysPerPeriod, double payment) {
		int numberOfPayments = 0;
		for (;balance > 0; numberOfPayments++){
			balance = question3(balance, rate, daysPerPeriod, payment);
		}
		return numberOfPayments;  // change the return value!
	}
}
