package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12;

import java.util.ArrayList;

public class Week12 {

    public static void main(String[] args) {
        BallDontLieAPI ballDontLieAPI = new BallDontLieAPI();

        BallDontLieAllPlayers values = ballDontLieAPI.example1();

        System.out.println(values.meta.next_cursor);
        System.out.println(values.meta.per_page);

        values.data.forEach(s->System.out.println(s.first_name + " " + s.last_name + " " + s.team.full_name));

    }
}
