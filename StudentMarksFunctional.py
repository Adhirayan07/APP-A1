"""Tutorial 10 - Question 1: Student marks using functional programming."""
from functools import reduce


def main():
    # Sample marks; replace these values with the actual student marks.
    marks = [45, 67, 89, 34, 100, 50]

    # a) Keep students who scored 50 marks or above.
    qualified_marks = list(filter(lambda mark: mark >= 50, marks))

    # b) Add 5 grace marks without allowing a mark to exceed 100.
    revised_marks = list(map(lambda mark: min(mark + 5, 100), marks))

    # c) Find the total of the revised marks.
    total_marks = reduce(lambda total, mark: total + mark, revised_marks, 0)

    print("Original marks:", marks)
    print("Marks of students scoring 50 or above:", qualified_marks)
    print("Marks after grace marks:", revised_marks)
    print("Total revised marks:", total_marks)
    print("Lambda functions make the small operations concise.")


if __name__ == "__main__":
    main()
