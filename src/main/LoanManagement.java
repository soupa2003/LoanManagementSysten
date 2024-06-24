package main;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;
import dao.loanImpl;
import entity.Loan;
import exception.*;
public class LoanManagement {
    public static void main(String[] args) {
        loanImpl loanService = new loanImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Apply Loan");
            System.out.println("2. Get All Loans");
            System.out.println("3. Get Loan by ID");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
            case 1:
                System.out.println("Enter Loan ID:");
                int loanId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Customer ID:");
                int customerId = scanner.nextInt();
                System.out.println("Enter Principal Amount:");
                BigDecimal principalAmount = scanner.nextBigDecimal();
                System.out.println("Enter Interest Rate:");
                BigDecimal interestRate = scanner.nextBigDecimal();
                System.out.println("Enter Loan Term (in years):");
                int loanTerm = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Loan Type:");
                String loanType = scanner.nextLine();

                Loan newLoan = new Loan(loanId, customerId, principalAmount, interestRate, loanTerm, loanType, "pending");
                loanService.applyLoan(newLoan);
                break;


                case 2:
                    Collection<Loan> loans = loanService.getAllLoan();
                    System.out.println("All Loans:");
                    for (Loan loan : loans) {
                        System.out.println(loan);
                    }
                    break;

                case 3:
                    System.out.println("Enter Loan ID:");
                    loanId = scanner.nextInt();
                    try {
                        Loan loan = loanService.getLoanById(loanId);
                        if (loan != null) {
                            System.out.println(loan);
                        } else {
                            throw new InvalidLoanException("Loan not found.");
                        }
                    } catch (InvalidLoanException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                 
                case 4:
                    System.out.println("Enter Loan ID to calculate interest:");
                    loanId = scanner.nextInt();
                    try {
                        double interest = loanService.calculateInterest(loanId);
                        System.out.println("Interest amount for Loan ID " + loanId + ": ₹" + interest);
                    } catch (InvalidLoanException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
