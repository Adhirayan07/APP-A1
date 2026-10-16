% Tutorial 10 - Question 5: Advanced programming course eligibility.
% A student must pass both Python Programming and Data Structures.

student_result(arun, python, pass).
student_result(arun, data_structures, pass).

student_result(bala, python, pass).
student_result(bala, data_structures, fail).

student_result(charan, python, pass).
student_result(charan, data_structures, pass).

student_result(divya, python, fail).
student_result(divya, data_structures, pass).

eligible_for_advanced_course(Student) :-
    student_result(Student, python, pass),
    student_result(Student, data_structures, pass).

% Query in SWI-Prolog:
% ?- eligible_for_advanced_course(Student).
% Expected answers: Student = arun ; Student = charan.
