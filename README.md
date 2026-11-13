# Week 11

Solutions for Tutorial 11 (03-11-2026).

## Python — Socket Programming

1. `TCPStudentResultServer.py` — TCP server that receives a register number and returns the student's result.
2. `TCPStudentResultClient.py` — TCP client that sends a register number and displays the result.
3. `UDPTemperatureServer.py` — UDP server that receives and displays temperature readings.
4. `UDPTemperatureClient.py` — UDP client that sends sample temperature readings to the monitoring server.

Run the server first in one terminal, then run its client in another terminal:

```bash
python TCPStudentResultServer.py
python TCPStudentResultClient.py
```

```bash
python UDPTemperatureServer.py
python UDPTemperatureClient.py
```

TCP uses a reliable connection for student result requests. UDP is connectionless and has low overhead, which can be useful for frequent sensor updates where an occasional lost reading may be acceptable.

## Python — Symbolic Mathematics using SymPy

5. `SympyAlgebra.py` — defines symbolic variables, expands and factorises expressions, simplifies an expression, and solves a quadratic equation.
6. `VehicleMotionSympy.py` — differentiates the given displacement function to find velocity and acceleration, finds rest times, and integrates velocity over a sample interval.

Install SymPy and run:

```bash
python -m pip install sympy
python SympyAlgebra.py
python VehicleMotionSympy.py
```

## Python — Automata using automata-lib

7. `DFA_BinaryCode.py` — DFA that accepts binary strings ending in `01`.
8. `NFA_SubstringAB.py` — NFA that accepts strings containing the substring `ab`.

Install the library and run:

```bash
python -m pip install automata-lib
python DFA_BinaryCode.py
python NFA_SubstringAB.py
```

The programs include sample test inputs and print whether each string is accepted or rejected.

## Notes

- The student result records and temperature readings are sample data; replace them with values given by your instructor if needed.
- The quadratic equation in Question 3 is an illustrative example because the question does not specify a particular equation.
- Question 4 does not state integration limits, so the program uses 0 to 2 seconds as a sample interval. Change these limits if your instructor specifies another interval.
- TCP and UDP programs use Python's built-in `socket` module.
