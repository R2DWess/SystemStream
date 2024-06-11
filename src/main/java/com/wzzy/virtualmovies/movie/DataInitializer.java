package com.wzzy.virtualmovies.movie;

import com.wzzy.virtualmovies.movie.service.MoviesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(MoviesService moviesService) {
        return args -> {

            Movie avatar = new Movie();
            avatar.setTitulo("Avatar");
            avatar.setAno(2009);
            avatar.setDuracaoEmMinutos(162);
            avatar.setGenero(Arrays.asList("Ação", "Aventura", "Fantasia"));
            avatar.setDiretor("James Cameron");
            avatar.setRoteiristas(Arrays.asList("James Cameron"));
            avatar.setAtores(Arrays.asList("Sam Worthington", "Zoe Saldana", "Sigourney Weaver", "Stephen Lang"));
            avatar.setPoster("https://xl.movieposterdb.com/09_08/2009/499549/xl_499549_cd69e2ea.jpg");
            avatar.setMetascore(83);

            moviesService.save(avatar);

            Movie iAmLegend = new Movie();
            iAmLegend.setTitulo("Eu Sou a Lenda");
            iAmLegend.setAno(2007);
            iAmLegend.setDuracaoEmMinutos(101);
            iAmLegend.setGenero(Arrays.asList("Drama", "Horror", "Ficção Científica"));
            iAmLegend.setDiretor("Francis Lawrence");
            iAmLegend.setRoteiristas(Arrays.asList("Mark Protosevich", "Akiva Goldsman", "Richard Matheson", "John William Corrington", "Joyce Hooper Corrington"));
            iAmLegend.setAtores(Arrays.asList("Will Smith", "Alice Braga", "Charlie Tahan", "Salli Richardson-Whitfield"));
            iAmLegend.setPoster("https://xl.movieposterdb.com/07_12/2007/480249/xl_480249_66680d6b.jpgs");
            iAmLegend.setMetascore(65);

            moviesService.save(iAmLegend);

            Movie trezentos = new Movie();
            iAmLegend.setTitulo("300");
            iAmLegend.setAno(2006);
            iAmLegend.setDuracaoEmMinutos(117);
            iAmLegend.setGenero(Arrays.asList("Ação", "Drama", "Fantasia"));
            iAmLegend.setDiretor("Zack Snyder");
            iAmLegend.setRoteiristas(Arrays.asList("Zack Snyder", "Kurt Johnstad", "Michael Gordon", "Frank Miller", "Lynn Varley"));
            iAmLegend.setAtores(Arrays.asList("Gerard Butler", "Lena Headey", "Dominic West", "David Wenham"));
            iAmLegend.setPoster("https://xl.movieposterdb.com/07_09/2006/0416449/xl_0416449_ebba784f.jpg");
            iAmLegend.setMetascore(52);

            moviesService.save(trezentos);

            Movie wolfOfWallStreet = new Movie();
            wolfOfWallStreet.setTitulo("O Lobo de Wall Street");
            wolfOfWallStreet.setAno(2013);
            wolfOfWallStreet.setDuracaoEmMinutos(180);
            wolfOfWallStreet.setGenero(Arrays.asList("Biografia", "Crime", "Drama"));
            wolfOfWallStreet.setDiretor("Martin Scorsese");
            wolfOfWallStreet.setRoteiristas(Arrays.asList("Terence Winter", "Jordan Belfort"));
            wolfOfWallStreet.setAtores(Arrays.asList("Leonardo DiCaprio", "Jonah Hill", "Margot Robbie", "Matthew McConaughey"));
            wolfOfWallStreet.setPoster("https://xl.movieposterdb.com/13_11/2013/993846/xl_993846_6b55e2ea.jpg");
            wolfOfWallStreet.setMetascore(75);

            moviesService.save(wolfOfWallStreet);

            Movie interstellar = new Movie();
            interstellar.setTitulo("Interestelar");
            interstellar.setAno(2014);
            interstellar.setDuracaoEmMinutos(169);
            interstellar.setGenero(Arrays.asList("Aventura", "Drama", "Ficção Científica"));
            interstellar.setDiretor("Christopher Nolan");
            interstellar.setRoteiristas(Arrays.asList("Jonathan Nolan", "Christopher Nolan"));
            interstellar.setAtores(Arrays.asList("Ellen Burstyn", "Matthew McConaughey", "Mackenzie Foy", "John Lithgow"));
            interstellar.setPoster("https://xl.movieposterdb.com/14_09/2014/816692/xl_816692_6fbec03a.jpg");
            interstellar.setMetascore(74);

            moviesService.save(interstellar);

            Movie pursuitOfHappyness = new Movie();
            pursuitOfHappyness.setTitulo("À Procura da Felicidade");
            pursuitOfHappyness.setAno(2006);
            pursuitOfHappyness.setDuracaoEmMinutos(117);
            pursuitOfHappyness.setGenero(Arrays.asList("Biografia", "Drama"));
            pursuitOfHappyness.setDiretor("Gabriele Muccino");
            pursuitOfHappyness.setRoteiristas(Arrays.asList("Steve Conrad"));
            pursuitOfHappyness.setAtores(Arrays.asList("Will Smith", "Jaden Smith"));
            pursuitOfHappyness.setPoster("https://xl.movieposterdb.com/07_12/2006/454921/xl_454921_9d11428d.jpg");

            moviesService.save(pursuitOfHappyness);

            Movie beforeSunrise = new Movie();
            beforeSunrise.setTitulo("Antes do Amanhecer");
            beforeSunrise.setAno(1995);
            beforeSunrise.setDuracaoEmMinutos(101);
            beforeSunrise.setGenero(Arrays.asList("Drama", "Romance"));
            beforeSunrise.setDiretor("Richard Linklater");
            beforeSunrise.setRoteiristas(Arrays.asList("Richard Linklater", "Kim Krizan"));
            beforeSunrise.setAtores(Arrays.asList("Ethan Hawke", "Julie Delpy"));
            beforeSunrise.setPoster("https://xl.movieposterdb.com/23_02/1995/112471/xl_before-sunrise-movie-poster_1fb3d59d.jpg");

            moviesService.save(beforeSunrise);

            Movie aboutTime = new Movie();
            aboutTime.setTitulo("Questão de Tempo");
            aboutTime.setAno(2013);
            aboutTime.setDuracaoEmMinutos(123);
            aboutTime.setGenero(Arrays.asList("Comédia", "Drama", "Fantasia"));
            aboutTime.setDiretor("Richard Curtis");
            aboutTime.setRoteiristas(Arrays.asList("Richard Curtis"));
            aboutTime.setAtores(Arrays.asList("Domhnall Gleeson", "Rachel McAdams"));
            aboutTime.setPoster("https://xl.movieposterdb.com/13_06/2013/2194499/xl_2194499_c0435606.jpg");

            moviesService.save(aboutTime);

            Movie prideAndPrejudice = new Movie();
            prideAndPrejudice.setTitulo("Orgulho e Preconceito");
            prideAndPrejudice.setAno(2005);
            prideAndPrejudice.setDuracaoEmMinutos(129);
            prideAndPrejudice.setGenero(Arrays.asList("Drama", "Romance"));
            prideAndPrejudice.setDiretor("Joe Wright");
            prideAndPrejudice.setRoteiristas(Arrays.asList("Jane Austen", "Deborah Moggach"));
            prideAndPrejudice.setAtores(Arrays.asList("Keira Knightley", "Matthew Macfadyen"));
            prideAndPrejudice.setPoster("https://m.media-amazon.com/images/S/pv-target-images/e5a295dcc5441e9a1fd5907e191578d510ed7f8be46c5e85a5dd51354bfd3cb6.jpg");

            moviesService.save(prideAndPrejudice);

            Movie matrix = new Movie();
            matrix.setTitulo("Matrix");
            matrix.setAno(1999);
            matrix.setDuracaoEmMinutos(136);
            matrix.setGenero(Arrays.asList("Ação", "Ficção Científica"));
            matrix.setDiretor("Lana Wachowski, Lilly Wachowski");
            matrix.setRoteiristas(Arrays.asList("Lana Wachowski", "Lilly Wachowski"));
            matrix.setAtores(Arrays.asList("Keanu Reeves", "Laurence Fishburne"));
            matrix.setPoster("https://xl.movieposterdb.com/06_11/1999/0133093/xl_145384_0133093_fd241228.jpg");

            moviesService.save(matrix);

            Movie spiritedAway = new Movie();
            spiritedAway.setTitulo("A Viagem de Chihiro");
            spiritedAway.setAno(2001);
            spiritedAway.setDuracaoEmMinutos(125);
            spiritedAway.setGenero(Arrays.asList("Animação", "Aventura", "Fantasia"));
            spiritedAway.setDiretor("Hayao Miyazaki");
            spiritedAway.setRoteiristas(Arrays.asList("Hayao Miyazaki"));
            spiritedAway.setAtores(Arrays.asList("Rumi Hiiragi", "Miyu Irino"));
            spiritedAway.setPoster("https://xl.movieposterdb.com/14_05/2001/245429/xl_245429_233c79aa.jpg");

            moviesService.save(spiritedAway);

            Movie cars = new Movie();
            spiritedAway.setTitulo("Carros");
            spiritedAway.setAno(2006);
            spiritedAway.setDuracaoEmMinutos(117);
            spiritedAway.setGenero(Arrays.asList("Animação", "Aventura", "Comédia"));
            spiritedAway.setDiretor("John Lasseter, Joe Ranft");
            spiritedAway.setRoteiristas(Arrays.asList("John Lasseter, Joe Ranft"));
            spiritedAway.setAtores(Arrays.asList("Owen Wilson", "Paul Newman"));
            spiritedAway.setPoster("https://xl.movieposterdb.com/15_12/2006/317219/xl_317219_18797820.jpg");

            moviesService.save(cars);

            Movie parasite = new Movie();
            parasite.setTitulo("Parasita");
            parasite.setAno(2019);
            parasite.setDuracaoEmMinutos(132);
            parasite.setGenero(Arrays.asList("Comédia", "Drama", "Thriller"));
            parasite.setDiretor("Bong Joon-ho");
            parasite.setRoteiristas(Arrays.asList("Bong Joon-ho", "Han Jin-won"));
            parasite.setAtores(Arrays.asList("Song Kang-ho", "Lee Sun-kyun"));
            parasite.setPoster("https://xl.movieposterdb.com/21_11/2019/6751668/xl_6751668_0d0409c5.jpg");

            moviesService.save(parasite);

            Movie arrival = new Movie();
            arrival.setTitulo("A Chegada");
            arrival.setAno(2016);
            arrival.setDuracaoEmMinutos(116);
            arrival.setGenero(Arrays.asList("Drama", "Ficção Científica"));
            arrival.setDiretor("Denis Villeneuve");
            arrival.setRoteiristas(Arrays.asList("Eric Heisserer"));
            arrival.setAtores(Arrays.asList("Amy Adams", "Jeremy Renner"));
            arrival.setPoster("https://xl.movieposterdb.com/22_10/2016/2543164/xl_arrival-movie-poster_a18b5408.jpg");

            moviesService.save(arrival);

            Movie childrenOfMen = new Movie();
            childrenOfMen.setTitulo("Filhos da Esperança");
            childrenOfMen.setAno(2006);
            childrenOfMen.setDuracaoEmMinutos(109);
            childrenOfMen.setGenero(Arrays.asList("Ação", "Drama", "Ficção Científica"));
            childrenOfMen.setDiretor("Alfonso Cuarón");
            childrenOfMen.setRoteiristas(Arrays.asList("Alfonso Cuarón", "Timothy J. Sexton"));
            childrenOfMen.setAtores(Arrays.asList("Clive Owen", "Julianne Moore"));
            childrenOfMen.setPoster("https://xl.movieposterdb.com/13_03/2006/206634/xl_206634_af29190c.jpg");

            moviesService.save(childrenOfMen);

            Movie bladeRunner2049 = new Movie();
            bladeRunner2049.setTitulo("Blade Runner 2049");
            bladeRunner2049.setAno(2017);
            bladeRunner2049.setDuracaoEmMinutos(164);
            bladeRunner2049.setGenero(Arrays.asList("Drama", "Mistério", "Ficção Científica"));
            bladeRunner2049.setDiretor("Denis Villeneuve");
            bladeRunner2049.setRoteiristas(Arrays.asList("Hampton Fancher", "Michael Green"));
            bladeRunner2049.setAtores(Arrays.asList("Ryan Gosling", "Harrison Ford"));
            bladeRunner2049.setPoster("https://xl.movieposterdb.com/23_02/2018/8151756/xl_blade-runner-2049-designing-the-world-of-blade-runner-2049-movie-poster_078b7954.jpg");

            moviesService.save(bladeRunner2049);

            Movie her = new Movie();
            her.setTitulo("Ela");
            her.setAno(2013);
            her.setDuracaoEmMinutos(126);
            her.setGenero(Arrays.asList("Drama", "Romance", "Ficção Científica"));
            her.setDiretor("Spike Jonze");
            her.setRoteiristas(Arrays.asList("Spike Jonze"));
            her.setAtores(Arrays.asList("Joaquin Phoenix", "Scarlett Johansson"));
            her.setPoster("https://xl.movieposterdb.com/13_11/2013/1798709/xl_1798709_48f9f547.jpg");

            moviesService.save(her);

            Movie punchDrunkLove = new Movie();
            punchDrunkLove.setTitulo("Embriagados de Amor");
            punchDrunkLove.setAno(2002);
            punchDrunkLove.setDuracaoEmMinutos(95);
            punchDrunkLove.setGenero(Arrays.asList("Comédia", "Drama", "Romance"));
            punchDrunkLove.setDiretor("Paul Thomas Anderson");
            punchDrunkLove.setRoteiristas(Arrays.asList("Paul Thomas Anderson"));
            punchDrunkLove.setAtores(Arrays.asList("Adam Sandler", "Emily Watson"));
            punchDrunkLove.setPoster("https://xl.movieposterdb.com/22_01/2002/272338/xl_272338_bb20bcda.jpg");

            moviesService.save(punchDrunkLove);

            Movie borat = new Movie();
            borat.setTitulo("Borat");
            borat.setAno(2006);
            borat.setDuracaoEmMinutos(84);
            borat.setGenero(Arrays.asList("Comédia"));
            borat.setDiretor("Larry Charles");
            borat.setRoteiristas(Arrays.asList("Sacha Baron Cohen", "Anthony Hines", "Peter Baynham", "Dan Mazer"));
            borat.setAtores(Arrays.asList("Sacha Baron Cohen", "Ken Davitian", "Luenell"));
            borat.setPoster("https://xl.movieposterdb.com/07_10/2006/443453/xl_443453_7ea199e5.jpg");

            moviesService.save(borat);

            Movie fiftyFifty = new Movie();
            fiftyFifty.setTitulo("50/50");
            fiftyFifty.setAno(2011);
            fiftyFifty.setDuracaoEmMinutos(100);
            fiftyFifty.setGenero(Arrays.asList("Comédia", "Drama", "Romance"));
            fiftyFifty.setDiretor("Jonathan Levine");
            fiftyFifty.setRoteiristas(Arrays.asList("Will Reiser"));
            fiftyFifty.setAtores(Arrays.asList("Joseph Gordon-Levitt", "Seth Rogen", "Anna Kendrick"));
            fiftyFifty.setPoster("https://xl.movieposterdb.com/21_02/2011/1306980/xl_1306980_1ac06c4e.jpg");

            moviesService.save(fiftyFifty);

            Movie rememberTheTitans = new Movie();
            rememberTheTitans.setTitulo("Duelo de Titãs");
            rememberTheTitans.setAno(2000);
            rememberTheTitans.setDuracaoEmMinutos(113);
            rememberTheTitans.setGenero(Arrays.asList("Biografia", "Drama", "Esportes"));
            rememberTheTitans.setDiretor("Boaz Yakin");
            rememberTheTitans.setRoteiristas(Arrays.asList("Gregory Allen Howard"));
            rememberTheTitans.setAtores(Arrays.asList("Denzel Washington", "Will Patton", "Wood Harris"));
            rememberTheTitans.setPoster("https://xl.movieposterdb.com/08_09/2000/210945/xl_210945_d59653b1.jpg");

            moviesService.save(rememberTheTitans);

        };
    }
}