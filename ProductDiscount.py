"""Tutorial 10 - Question 3: Pure function and festival discount."""


def discounted_price(price):
    """Return a 20% discounted price for prices above ₹1,000."""
    if price > 1000:
        return round(price * 0.80, 2)
    return price


def main():
    # Sample product prices in rupees.
    product_prices = [500, 1200, 2500, 999, 1500]

    # c) Find products whose original price is above ₹1,000.
    eligible_products = list(
        filter(lambda price: price > 1000, product_prices)
    )

    # b) Apply the pure function to each price using map().
    revised_prices = list(map(discounted_price, product_prices))

    print("Original product prices:", product_prices)
    print("Products eligible for discount:", eligible_products)
    print("Prices after discount:", revised_prices)
    print("The original list remains unchanged:", product_prices)


if __name__ == "__main__":
    main()
