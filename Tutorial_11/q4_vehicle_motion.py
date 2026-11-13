"""Q4: Find velocity, acceleration, rest times and displacement change."""

import sympy as sp


def main():
    t = sp.symbols("t", real=True)

    # Displacement function given in the question.
    s = t**3 - 6*t**2 + 9*t + 5

    # Velocity is the first derivative of displacement.
    velocity = sp.diff(s, t)

    # Acceleration is the derivative of velocity.
    acceleration = sp.diff(velocity, t)

    print("Displacement s(t):", s)
    print("Velocity v(t):", velocity)
    print("Acceleration a(t):", acceleration)

    # The vehicle is momentarily at rest when velocity is zero.
    rest_times = sp.solve(sp.Eq(velocity, 0), t)
    print("Time(s) when vehicle is momentarily at rest:", rest_times)

    # Sample interval because the question does not specify exact limits.
    start_time = 0
    end_time = 2

    # Integrating velocity gives change in displacement over the interval.
    displacement_change = sp.integrate(
        velocity, (t, start_time, end_time)
    )
    print(
        f"Change in displacement from {start_time} to {end_time} seconds:",
        displacement_change,
    )

    # Also show the displacement at both endpoints for verification.
    print("s(start time):", s.subs(t, start_time))
    print("s(end time):", s.subs(t, end_time))


if __name__ == "__main__":
    main()
