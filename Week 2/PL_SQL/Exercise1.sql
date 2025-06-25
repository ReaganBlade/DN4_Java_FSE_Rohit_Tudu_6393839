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
        SET loan_interest = loan_interest - loan_interest * 0.1
        WHERE customer_id = record.customer_id;
    END LOOP;

    COMMIT;
END;


