public class Candidate {
    private final String name;
    private int votes;

    public Candidate(String name) {
        this.name = name == null ? "Todorhoigui" : name;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }
}