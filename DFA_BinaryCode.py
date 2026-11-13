"""Tutorial 11 - Question 5: DFA accepting binary strings ending in 01."""

from automata.fa.dfa import DFA


def main():
    dfa = DFA(
        states={"q0", "q1", "q2"},
        input_symbols={"0", "1"},
        transitions={
            "q0": {"0": "q1", "1": "q0"},
            "q1": {"0": "q1", "1": "q2"},
            "q2": {"0": "q1", "1": "q0"},
        },
        initial_state="q0",
        final_states={"q2"},
    )

    test_strings = ["01", "101", "1101", "0", "10", "011", "111", ""]

    for value in test_strings:
        try:
            accepted = dfa.accepts_input(value)
            print(f"{value!r}: {'Accepted' if accepted else 'Rejected'}")
        except Exception as error:
            print(f"{value!r}: Invalid input ({error})")


if __name__ == "__main__":
    main()
