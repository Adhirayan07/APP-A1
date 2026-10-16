# Week 10

Solutions for Tutorial 10 (15-10-2026).

## Python — Functional Programming

1. `StudentMarksFunctional.py` — `filter()`, `map()`, `reduce()`, lambda functions, and grace marks capped at 100.
2. `EmployeeSalaryIncrement.py` — identifies employees earning below ₹40,000, applies a 10% increment, and totals the revised salaries.
3. `ProductDiscount.py` — pure function for the 20% discount on products above ₹1,000; shows that the original price list is unchanged.
4. `ElectricityConsumption.py` — filters high-consumption days, computes daily costs, totals consumption, and calculates the bill using a pure function.

Run a Python program from this folder:

```bash
python StudentMarksFunctional.py
python EmployeeSalaryIncrement.py
python ProductDiscount.py
python ElectricityConsumption.py
```

The Python programs contain illustrative sample data because the tutorial does not provide input values for Questions 1–4.

## Prolog — Facts and Rules

5. `CourseEligibility.pl` — eligible students must pass both Python and Data Structures.
6. `EmployeePromotion.pl` — promotion requires at least 5 years of experience, completed training, and a rating of at least 4.
7. `ParkingAllocation.pl` — retrieves available slots for a specified vehicle type.

Open a file with SWI-Prolog, for example:

```bash
swipl -s CourseEligibility.pl
```

Then enter the query shown in the file, without the leading comment marker. For example:

```prolog
eligible_for_advanced_course(Student).
```
