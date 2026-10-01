import java.util.Scanner;

class Candidate {
    int Candidate_Id;
    String name;
    int aptitude;
    int technical;
    int communication;

    Candidate(int Candidate_Id, String name, int aptitude,
              int technical, int communication) {

        this.Candidate_Id = Candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class TopKCandidates {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read N and K
        int N = sc.nextInt();
        int K = sc.nextInt();

        Candidate[] candidates = new Candidate[N];

        // Read candidate details
        for (int i = 0; i < N; i++) {

            int id = sc.nextInt();
            String name = sc.next();

            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();

            candidates[i] = new Candidate(
                    id,
                    name,
                    aptitude,
                    technical,
                    communication
            );
        }

        // Sort candidates
        for (int i = 0; i < N - 1; i++) {

            for (int j = 0; j < N - i - 1; j++) {

                int score1 = candidates[j].getTotalScore();
                int score2 = candidates[j + 1].getTotalScore();

                // Higher score gets priority
                // If scores are equal, smaller ID gets priority
                if (score1 < score2 ||
                   (score1 == score2 &&
                    candidates[j].Candidate_Id >
                    candidates[j + 1].Candidate_Id)) {

                    Candidate temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }

        // Display Top K candidates
        for (int i = 0; i < K; i++) {

            System.out.println(
                candidates[i].Candidate_Id + " " +
                candidates[i].name + " " +
                candidates[i].getTotalScore()
            );
        }

        sc.close();
    }
}