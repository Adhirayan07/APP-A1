"""Tutorial 11 - Question 4: Vehicle motion using SymPy."""

import sympy as sp


def main():
    t = sp.symbols("t", real=True)
    s = t**3 - 6*t**2 + 9*t + 5

    velocity = sp.diff(s, t)
    acceleration = sp.diff(velocity, t)

    print("Displacement s(t):", s)
    print("Velocity v(t):", velocity)
    print("Acceleration a(t):", acceleration)

    rest_times = sp.solve(sp.Eq(velocity, 0), t)
    print("Time(s) when vehicle is momentarily at rest:", rest_times)

    # Sample interval; change these limits if specified by your instructor.
    start_time = 0
    end_time = 2
    displacement_change = sp.integrate(
        velocity, (t, start_time, end_time)
    )

    print(
        f"Change in displacement from {start_time} to {end_time} seconds:",
        displacement_change,
    )
    print("s(start time):", s.subs(t, start_time))
    print("s(end time):", s.subs(t, end_time))


if __name__ == "__main__":
    main()
