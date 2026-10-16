"""Tutorial 10 - Question 2: Employee salary revision using map/filter/reduce."""
from functools import reduce


def main():
    # Illustrative employee data: (name, monthly salary in rupees).
    employees = [
        ("Arun", 35000),
        ("Bala", 42000),
        ("Charan", 38000),
        ("Divya", 50000),
        ("Esha", 30000),
    ]

    # b) Identify employees earning below ₹40,000.
    eligible = list(filter(lambda employee: employee[1] < 40000, employees))

    # a) Give eligible employees a 10% increment; leave others unchanged.
    revised = list(
        map(
            lambda employee: (
                employee[0],
                round(employee[1] * 1.10, 2)
                if employee[1] < 40000
                else employee[1],
            ),
            employees,
        )
    )

    # c) Calculate total monthly salary expenditure after revision.
    total_expenditure = reduce(
        lambda total, employee: total + employee[1], revised, 0
    )

    print("Original employees and salaries:", employees)
    print("Eligible for increment:", eligible)
    print("Revised salaries:", revised)
    print(f"Total salary expenditure after revision: ₹{total_expenditure:,.2f}")
    print(
        "Functional programming applies the same clear operations to each record "
        "and returns new data instead of changing the original list."
    )


if __name__ == "__main__":
    main()
