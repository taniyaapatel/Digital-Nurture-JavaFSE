SET SERVEROUTPUT ON;

-- Scenario 1: Discount to loan interest rates for customers above 60
DECLARE
    v_age NUMBER;
BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, l.InterestRate, c.DOB 
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, loan_rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans 
            SET InterestRate = InterestRate - 1 
            WHERE LoanID = loan_rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Discount applied to LoanID: ' || loan_rec.LoanID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote to VIP based on balance
-- Note: Requires an IsVIP column. We simulate it with DBMS_OUTPUT or altering table
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

BEGIN
    FOR cust_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers 
            SET IsVIP = 'TRUE' 
            WHERE CustomerID = cust_rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Customer ' || cust_rec.CustomerID || ' is now VIP.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders for loans due within 30 days
BEGIN
    FOR due_rec IN (
        SELECT l.LoanID, c.Name, l.EndDate 
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || due_rec.Name || ', your loan (' || due_rec.LoanID || ') is due on ' || due_rec.EndDate);
    END LOOP;
END;
/
