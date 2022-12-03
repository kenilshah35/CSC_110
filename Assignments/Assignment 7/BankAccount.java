
import java.util.*;

public class BankAccount {

  private int accountNumber;
  private String ownerName;
  private double balance;
  private boolean error;

  public BankAccount() {
    accountNumber    = 0;
    ownerName = "";
    balance = 0.0;
    error = false;
  }

  public BankAccount(int number, String name, double initialDeposit) {
    accountNumber    = number;
    ownerName = name;
    balance = initialDeposit;
    error = false;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int number) {
    accountNumber = number;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String name) {
    ownerName = name;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double newAmount) {
    balance = newAmount;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdrawal(double amount) {
    balance -= amount;
  }

  public void setError(boolean value) {
	  this.error = value;
  }

  public boolean equals(BankAccount other) {
	  if ((this.ownerName.equals(other.ownerName)) &&
	  				(this.accountNumber == other.accountNumber)) {
			if (this.balance != other.balance) {
				this.error = true;
				other.setError(true);
			}
			return true;
		}
		else return false;
	}

  public String toString() {
    return accountNumber + " " + ownerName + " " + balance;
  }
}
