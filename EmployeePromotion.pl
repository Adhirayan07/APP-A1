% Tutorial 10 - Question 6: Employee promotion eligibility.
% Requirements: at least 5 years' experience, training completed, rating >= 4.

employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

eligible_for_promotion(Name) :-
    employee(Name, Experience, completed, Rating),
    Experience >= 5,
    Rating >= 4.

% Query in SWI-Prolog:
% ?- eligible_for_promotion(Name).
% Expected answers: Name = ravi ; Name = meena.
