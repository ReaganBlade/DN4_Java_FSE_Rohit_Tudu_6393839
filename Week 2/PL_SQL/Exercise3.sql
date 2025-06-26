-- Exercise 3: Stored Procedures

-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- Question: Write a stored procedure ProcessMonthlyInterest that calculates and 
-- updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    CURSOR cust IS
        SELECT customer_id from customers
        FOR UPDATE;
BEGIN
    FOR record IN cust LOOP
        UPDATE customers
        SET cur_balance = cur_balance + cur_balance * 0.01
        WHERE customer_id = record.customer_id;
    END LOOP;

    COMMIT;
END;
/


DECLARE


BEGIN
    ProcessMonthlyInterest;

END;

-- Shorter solution

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE customers
    SET cur_balance = cur_balance + cur_balance * 0.01;

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;



-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- Question: Write a stored procedure UpdateEmployeeBonus that 
-- updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) IS
    CURSOR employee IS
        SELECT employee_id from employees
        WHERE dept = dept_name
        FOR UPDATE;

BEGIN
    FOR record IN employee LOOP
        UPDATE employees
        SET salary = salary + salary * (bonus_percent/100)
        WHERE employee_id = record.employee_id;

    END LOOP;
    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus(dept => 'Accounts', bonus_percent => 10);
END;



-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, 
-- checking that the source account has sufficient balance before making the transfer.

CREATE OR REPLACE PROCEDURE TransferFunds (
    src_acc_id IN NUMBER,
    dest_acc_id IN NUMBER,
    funds IN NUMBER
) IS 
    src_balance NUMBER;

BEGIN
    SELECT balance INTO src_balance
    FROM accounts
    WHERE account_id = src_acc_id
    FOR UPDATE;

    IF src_balance < funds THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account!');
    END IF;

    UPDATE accounts
    SET balance = balance - funds
    WHERE account_id = src_acc_id;

    UPDATE accounts
    SET balance = balance + funds
    WHERE account_id = dest_acc_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer of ' || funds || ' from account ' || src_acc_id || ' to account ' || dest_acc_id || ' completed.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20001, 'One or both accounts not found.');
    
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;

END;
/