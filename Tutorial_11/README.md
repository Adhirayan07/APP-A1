# Tutorial 11 — Python Networking, SymPy and Automata

**Date in question sheet:** 03-11-2026

This folder contains working reference solutions for all six questions in Tutorial 11.

## Files

| Question | Files | What it demonstrates |
|---|---|---|
| 1 | `q1_tcp_server.py`, `q1_tcp_client.py` | TCP request/response for student results |
| 2 | `q2_udp_server.py`, `q2_udp_client.py` | UDP temperature transmission |
| 3 | `q3_sympy_algebra.py` | Symbolic expansion, factorisation, simplification and solving |
| 4 | `q4_vehicle_motion.py` | Differentiation, rest times and definite integration |
| 5 | `q5_dfa_binary_01.py` | DFA accepting binary strings ending in `01` |
| 6 | `q6_nfa_substring_ab.py` | NFA accepting strings containing `ab` |

## Setup

Use Python 3. Install the two third-party libraries:

```bash
python -m pip install sympy automata-lib
```

TCP and UDP examples use Python's built-in `socket` library, so no extra package is required for Q1 and Q2.

## How to run

Open a terminal in this folder. For Q1 and Q2, start the server in one terminal first, then run the matching client in a second terminal.

### Q1 — TCP

Terminal 1:
```bash
python q1_tcp_server.py
```
Terminal 2:
```bash
python q1_tcp_client.py
```
The sample register numbers are `RA101`, `RA102`, and `RA103`. Change the dictionary in the server to use other sample records.

### Q2 — UDP

Terminal 1:
```bash
python q2_udp_server.py
```
Terminal 2:
```bash
python q2_udp_client.py
```
The client sends three sample temperature readings and then an `END` message.

### Q3 — SymPy algebra

```bash
python q3_sympy_algebra.py
```
The program demonstrates the expression `(x + 2)(x + 3)`, its factorised form, simplification, and the example quadratic equation `x² - 5x + 6 = 0`.

### Q4 — Vehicle motion

```bash
python q4_vehicle_motion.py
```
The displacement function is exactly the one in the question: `s(t) = t³ - 6t² + 9t + 5`. The sample integration interval is 0 to 2 seconds; edit the interval variables in the program if your instructor specifies another interval.

### Q5 — DFA

```bash
python q5_dfa_binary_01.py
```
The DFA accepts binary strings ending in `01`. The alphabet is `{0, 1}`; an empty string is rejected.

State meaning:
- `q0`: start / no useful suffix
- `q1`: most recent symbol is `0`
- `q2`: string currently ends in `01` (accepting)

Transition table:

| State | Input 0 | Input 1 |
|---|---|---|
| q0 | q1 | q0 |
| q1 | q1 | q2 |
| q2 | q1 | q0 |

### Q6 — NFA

```bash
python q6_nfa_substring_ab.py
```
The NFA accepts strings over `{a, b}` that contain `ab` anywhere.

State meaning:
- `q0`: keep scanning for the start of the substring
- `q1`: an `a` has been found; the next symbol may complete `ab`
- `q2`: substring `ab` has been found (accepting)

Transition table:

| State | Input a | Input b |
|---|---|---|
| q0 | {q0, q1} | {q0} |
| q1 | ∅ | {q2} |
| q2 | {q2} | {q2} |

## Viva points

- **TCP** is connection-oriented and provides reliable, ordered delivery. It suits a result request where the complete response must reach the client.
- **UDP** is connectionless and has low overhead. It can suit frequent sensor updates where a newer reading may be more useful than retransmitting an older lost reading. UDP itself does not guarantee delivery or order.
- **SymPy** performs symbolic mathematics, so it manipulates expressions rather than only calculating with fixed numeric values.
- **Differentiation** of displacement gives velocity; differentiating velocity gives acceleration. Definite integration of velocity over a time interval gives change in displacement.
- A **DFA** has exactly one next state for each state/input-symbol pair.
- An **NFA** may have multiple possible next states for one input symbol. A string is accepted if at least one path reaches an accepting state.

These are sample implementations and sample data. Replace the student records and sample readings with values required by your lab instructor, if provided.
