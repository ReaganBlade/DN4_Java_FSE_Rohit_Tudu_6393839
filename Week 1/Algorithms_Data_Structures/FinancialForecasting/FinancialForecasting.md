Sure, here's the result in simple Markdown format:

---

## Time Complexity

The recursive method:

```java
public static double futureValue(double principle, double rate, int time) {
    if (time == 0) return principle;
    return futureValue(principle * (1 + rate), rate, time - 1);
}
```

### Time Complexity: O(n)

* The function makes one recursive call for each period.
* There are no repeated subproblems or branching.
* Therefore, the time complexity is linear: **O(n)**, where **n** is the number of periods.

### Space Complexity: O(n)

* Each recursive call adds a new frame to the call stack.
* For **n** periods, the call stack depth will be **n**.
* This may lead to a stack overflow if **n** is very large.

---

## Optimization of Recursive Algorithm

Although the recursive approach works fine for small **n**, it is not suitable for large values due to call stack limitations.

### Optimization Strategy: Use Iteration Instead of Recursion

An iterative version avoids recursion and uses constant space.

```java
public static double futureValueIterative(double principle, double rate, int time) {
    for (int i = 0; i < time; i++) {
        principle *= (1 + rate);
    }
    return principle;
}
```

### Time Complexity: O(n)

* Still makes one calculation per period.

### Space Complexity: O(1)

* No extra space is used except for a few variables.
* Safe for large **n**.

---

## Summary

| Aspect                 | Recursive                | Iterative                           |
| ---------------------- | ------------------------ | ----------------------------------- |
| Time Complexity        | O(n)                     | O(n)                                |
| Space Complexity       | O(n)                     | O(1)                                |
| Risk of Stack Overflow | Yes                      | No                                  |
| Best Use Case          | Small n, simple problems | Large n, performance-critical cases |


