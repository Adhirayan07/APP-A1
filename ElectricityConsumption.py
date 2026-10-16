"""Tutorial 10 - Question 4: Household electricity consumption."""
from functools import reduce


def calculate_bill(consumption, rate=6):
    """Return the bill for a sequence of unit values without mutating it."""
    daily_costs = map(lambda units: units * rate, consumption)
    return reduce(lambda total, cost: total + cost, daily_costs, 0)


def main():
    # Sample daily consumption in units.
    consumption = [8, 12, 9, 15, 11, 7, 14]

    # a) Find days with consumption greater than 10 units.
    high_consumption_days = list(filter(lambda units: units > 10, consumption))

    # b) Calculate each day's cost at ₹6 per unit.
    daily_costs = list(map(lambda units: units * 6, consumption))

    # c) Calculate total electricity consumption.
    total_consumption = reduce(
        lambda total, units: total + units, consumption, 0
    )

    # d) Calculate the bill through a pure function.
    total_bill = calculate_bill(consumption)

    print("Daily consumption (units):", consumption)
    print("Days above 10 units:", high_consumption_days)
    print("Daily cost (₹):", daily_costs)
    print("Total consumption (units):", total_consumption)
    print(f"Total bill at ₹6 per unit: ₹{total_bill}")
    print("Original consumption data remains unchanged:", consumption)


if __name__ == "__main__":
    main()
