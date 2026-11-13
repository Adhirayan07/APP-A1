"""Q6: NFA that accepts strings containing the substring 'ab'.

Install dependency:
    python -m pip install automata-lib
"""

from automata.fa.nfa import NFA


def main():
    nfa = NFA(
        states={"q0", "q1", "q2"},
        input_symbols={"a", "b"},
        transitions={
            "q0": {"a": {"q0", "q1"}, "b": {"q0"}},
            "q1": {"b": {"q2"}},
            "q2": {"a": {"q2"}, "b": {"q2"}},
        },
        initial_state="q0",
        final_states={"q2"},
    )

    test_strings = ["ab", "aab", "bab", "abba", "aa", "bbb", "ba", ""]

    print("NFA: accepts strings containing 'ab'")
    for value in test_strings:
        try:
            accepted = nfa.accepts_input(value)
            print(f"{value!r}: {'Accepted' if accepted else 'Rejected'}")
        except Exception as error:
            print(f"{value!r}: Invalid input ({error})")


if __name__ == "__main__":
    main()
