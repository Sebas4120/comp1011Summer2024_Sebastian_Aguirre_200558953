package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12;

public class BallPlayer {

    public int id, draft_year, draft_round, draft_number;
    public String first_name, last_name, position, height, weight, jersey_number,
            college, country;
    public BallTeam team;

    @Override
    public String toString() {
        return "Player\n" +
                "id=" + id +
                "\ndraft_year=" + draft_year +
                "\ndraft_round=" + draft_round +
                "\ndraft_number=" + draft_number +
                "\nfirst_name='" + first_name + '\'' +
                "\nlast_name='" + last_name + '\'' +
                "\nposition='" + position + '\'' +
                "\nheight='" + height + '\'' +
                "\nweight='" + weight + '\'' +
                "\njersey_number='" + jersey_number + '\'' +
                "\ncollege='" + college + '\'' +
                "\ncountry='" + country + '\'' +
                "\n"+
                team.toString();

    }
}
