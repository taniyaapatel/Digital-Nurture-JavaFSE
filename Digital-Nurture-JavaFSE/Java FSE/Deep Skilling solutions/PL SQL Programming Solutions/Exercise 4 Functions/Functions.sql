-- Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge(p_dob IN DATE) 
RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/

-- Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_principal IN NUMBER,
    p_annual_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_installment NUMBER;
BEGIN
    v_monthly_rate := (p_annual_rate / 100) / 12;
    v_months := p_years * 12;
    
    IF v_monthly_rate = 0 THEN
        RETURN p_principal / v_months;
    END IF;
    
    v_installment := (p_principal * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) / 
                     (POWER(1 + v_monthly_rate, v_months) - 1);
                     
    RETURN ROUND(v_installment, 2);
END;
/

-- Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
