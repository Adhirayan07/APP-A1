"""Tutorial 11 - Question 3: Symbolic algebra using SymPy."""

import sympy as sp


def main():
    x = sp.symbols("x")

    expression = (x + 2) * (x + 3)
    expanded = sp.expand(expression)
    print("Original expression:", expression)
    print("Expanded expression:", expanded)

    factorised = sp.factor(expanded)
    print("Factorised expression:", factorised)

    expression_to_simplify = (x**2 - 1) / (x - 1)
    simplified = sp.simplify(expression_to_simplify)
    print("Expression to simplify:", expression_to_simplify)
    print("Simplified expression:", simplified)

    # Example quadratic equation; the question does not specify its values.
    equation = sp.Eq(x**2 - 5*x + 6, 0)
    solutions = sp.solve(equation, x)
    print("Quadratic equation:", equation)
    print("Possible production quantities:", solutions)


if __name__ == "__main__":
    main()
