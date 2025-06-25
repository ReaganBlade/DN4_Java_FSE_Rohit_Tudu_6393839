-- Exercise 1: Control Structures

-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

DECLARE
    CURSOR cust IS
        SELECT customer_id FROM customers
        WHERE age > 60
        FOR UPDATE;

BEGIN
    FOR record IN cust LOOP
        UPDATE customers
        SET loan_interest = loan_interest - loan_interest * 0.01
        WHERE customer_id = record.customer_id;
    END LOOP;

    COMMIT;
END;


-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- oQuestion: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.

DECLARE
    CURSOR cust IS
        SELECT customer_id FROM customers
        WHERE balance > 10000
        FOR UPDATE;

BEGIN
    FOR record in cust LOOP
        UPDATE customers
        SET IsVIP = 1
        WHERE customer_id = record.customer_id;

    END LOOP;

    COMMIT;
END;

-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- oQuestion: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

DECLARE
    CURSOR loan_due_cursor IS
        SELECT customer_id, customer_name, loan_due_date
        FROM customers
        WHERE loan_due_date BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR record IN loan_due_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || record.customer_name || 
                             ', your loan is due on ' || TO_CHAR(record.loan_due_date, 'DD-Mon-YYYY') || 
                             '. Please make the necessary arrangements.');
    END LOOP;
END;
