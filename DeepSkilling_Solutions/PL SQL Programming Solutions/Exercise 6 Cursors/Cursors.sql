SET SERVEROUTPUT ON;

-- Scenario 1: GenerateMonthlyStatements
DECLARE
    CURSOR stmt_cur IS
        SELECT c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE);
BEGIN
    FOR rec IN stmt_cur LOOP
        DBMS_OUTPUT.PUT_LINE('Statement for ' || rec.Name || ': ' || 
                             rec.TransactionType || ' of $' || rec.Amount || 
                             ' on ' || rec.TransactionDate);
    END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR acc_cur IS SELECT AccountID, Balance FROM Accounts;
    v_fee NUMBER := 50; -- Example fee
BEGIN
    FOR rec IN acc_cur LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee applied to all accounts.');
END;
/

-- Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR loan_cur IS SELECT LoanID, InterestRate FROM Loans;
BEGIN
    FOR rec IN loan_cur LOOP
        -- Example policy: increase by 0.5%
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated based on new policy.');
END;
/
