## Requirements

Classes

1. User
2. ExpenseType
3. Expense -> maintained per user both ways
4. ex u1 paid 1000 split bw u1 and u2
5. then,
6. u1 -> GETSBACK -> 500 -> u2
7. u2 -> OWES -> 500  -> U1
8. <user, <user2, expense>> -> can be updated on payment easily
9. Strategies -> equal, exact, percent -> how user  split is happening
10. Commands -> with a command factory