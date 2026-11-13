"""Q3: Expand, factorise, simplify expressions and solve a quadratic."""

import sympy as sp


def main():
    x = sp.symbols("x")

    # Define and expand an algebraic expression.
    expression = (x + 2) * (x + 3)
    expanded = sp.expand(expression)
    print("Original expression:", expression)
    print("Expanded expression:", expanded)

    # Factorise the expanded expression.
    factorised = sp.factor(expanded)
    print("Factorised expression:", factorised)

    # Simplify an expression.
    expression_to_simplify = (x**2 - 1) / (x - 1)
    simplified = sp.simplify(expression_to_simplify)
    print("Expression to simplify:", expression_to_simplify)
    print("Simplified expression:", simplified)

    # Example production equation: x^2 - 5x + 6 = 0.
    equation = sp.Eq(x**2 - 5*x + 6, 0)
    solutions = sp.solve(equation, x)
    print("Quadratic equation:", equation)
    print("Possible production quantities:", solutions)


if __name__ == "__main__":
    main()
