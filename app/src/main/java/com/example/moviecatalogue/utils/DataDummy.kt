package com.example.moviecatalogue.utils

import com.example.moviecatalogue.data.source.local.entity.EpisodeEntity
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.data.source.remote.response.EpisodeResponse
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse
import kotlin.random.Random

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            "M1",
            "The Greatest Showman",
            2017,
            7.6F,
            105,
            "Biography, Drama, Musical",
            "Orphaned, penniless, but ambitious and with a mind crammed with imagination and fresh ideas, the American entertainer, Phineas Taylor Barnum, will always be remembered as the man with the gift to blur the line between reality and fiction. Thirsty for innovation and hungry for success, the son of a tailor manages to open a wax museum; however, he soon shifts focus to the unique and the peculiar, introducing extraordinary, never-seen-before live acts on the circus stage. Now, some people call Barnum's rich collection of oddities, an outright freak show; but, when Phineas, obsessed for cheers and respectability, gambles everything on the opera singer, Jenny Lind, to appeal to a high-brow audience, he will lose sight of the most crucial aspect of his life: his family. Will Barnum, the greatest showman, risk it all to be accepted?",
            "https://upload.wikimedia.org/wikipedia/en/1/10/The_Greatest_Showman_poster.png",
            false
        )
        )

        movies.add(
            MovieEntity(
            "M2",
            "Who Am I",
            2014,
            7.5F,
            102,
            "Crime, Drama, Mystery",
            "Benjamin (TOM SCHILLING) is invisible, a nobody. This changes abruptly when he meets charismatic Max (ELYAS M'BAREK). Even though they couldn't seem more different from the outside, they share the same interest: hacking. Together with Max's friends, the impulsive Stephan (WOTAN WILKE MÖHRING) and paranoid Paul (ANTOINE MONOT), they form the subversive Hacker collective CLAY (CLOWNS LAUGHING @ YOU). CLAY provokes with fun campaigns and speaks for a whole generation. For the first time in his life, Benjamin is part of something and even the attractive Marie (HANNAH HERZSPRUNG) begins noticing him. But fun turns into deadly danger when CLAY appears on the BKA's (Bundeskriminalamt, Federal Criminal Police Office) as well as Europol's most wanted list. Hunted by Cybercrime investigator Hanne Lindberg (TRINE DYRHOLM), Benjamin is no longer a nobody, but instead one of the most wanted hackers in the world.",
            "https://upload.wikimedia.org/wikipedia/en/5/5c/Who_am_I_movie_poster.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M3",
            "How to Train Your Dragon: The Hidden World",
            2019,
            7.5F,
            104,
            "Animation, Action, Adventure",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "https://upload.wikimedia.org/wikipedia/en/f/fd/How_to_Train_Your_Dragon_3_poster.png",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M4",
            "2 Fast 2 Furious",
            2003,
            5.9F,
            107,
            "Action, Crime, Thriller",
            "EX LAPD cop Brian O'Conner (Paul Walker) teams up with his ex-con friend Roman Pearce (Tyrese Gibson) and works with undercover U.S. Customs Service agent Monica Fuentes (Eva Mendes) to bring Miami-based drug lord Carter Verone (Cole Hauser) down.",
            "https://upload.wikimedia.org/wikipedia/en/9/9d/Two_fast_two_furious_ver5.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M5",
            "Hansel & Gretel: Witch Hunters",
            2013,
            6.1F,
            88,
            "Action, Fantasy, Horror",
            "The siblings Hansel and Gretel are left alone in the woods by their father and captured by a dark witch in a candy house. However they kill the witch and escape from the spot. Years later, the orphans have become famous witch hunters. When eleven children go missing in a small village, the Mayor summons Hansel and Gretel to rescue them, and they save the red haired Mina from the local sheriff who wants to burn her, accusing Mina of witchcraft. Soon they discover that the Blood Moon will approach in three days and the powerful dark witch Muriel is responsible for the abduction of children. She intends to use the children together with a secret ingredient in a Sabbath to make the coven of witches protected against the fire. Meanwhile Hansel and Gretel disclose secrets about their parents.",
            "https://upload.wikimedia.org/wikipedia/en/8/88/Hansel_and_Gretel_Witch_Hunters_.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M6",
            "Iron Man",
            2008,
            7.9F,
            126,
            "Action, Adventure, Sci-Fi",
            "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters.",
            "https://assets-a1.kompasiana.com/items/album/2019/02/11/infosinopsisdotblogspot-5c61477bbde57513bc5d21a7.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M7",
            "Spider-Man: Far from Home",
            2019,
            7.5F,
            129,
            "Action, Adventure, Sci-Fi",
            "Our friendly neighborhood Super Hero decides to join his best friends Ned, MJ, and the rest of the gang on a European vacation. However, Peter's plan to leave super heroics behind for a few weeks are quickly scrapped when he begrudgingly agrees to help Nick Fury uncover the mystery of several elemental creature attacks, creating havoc across the continent.",
            "https://upload.wikimedia.org/wikipedia/en/b/bd/Spider-Man_Far_From_Home_poster.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M8",
            "The Dark Knight Rises",
            2012,
            8.4F,
            164,
            "Action, Adventure",
            "Despite his tarnished reputation after the events of The Dark Knight (2008), in which he took the rap for Dent's crimes, Batman feels compelled to intervene to assist the city and its Police force, which is struggling to cope with Bane's plans to destroy the city.",
            "https://upload.wikimedia.org/wikipedia/en/8/83/Dark_knight_rises_poster.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M9",
            "Joker",
            2019,
            8.4F,
            122,
            "Crime, Drama, Thriller",
            "Arthur Fleck works as a clown and is an aspiring stand-up comic. He has mental health issues, part of which involves uncontrollable laughter. Times are tough and, due to his issues and occupation, Arthur has an even worse time than most. Over time these issues bear down on him, shaping his actions, making him ultimately take on the persona he is more known as...Joker.",
            "https://upload.wikimedia.org/wikipedia/en/e/e1/Joker_%282019_film%29_poster.jpg",
                false
        )
        )

        movies.add(
            MovieEntity(
            "M10",
            "Despicable Me",
            2010,
            7.6F,
            95,
            "Animation, Comedy, Crime",
            "In a happy suburban neighborhood surrounded by white picket fences with flowering rose bushes, sits a black house with a dead lawn. Unbeknownst to the neighbors, hidden beneath this house is a vast secret hideout. Surrounded by a small army of minions, we discover Gru (Steve Carell), planning the biggest heist in the history of the world. He is going to steal the moon. Gru delights in all things wicked. Armed with his arsenal of shrink rays, freeze rays, and battle-ready vehicles for land and air, he vanquishes all who stand in his way. Until the day he encounters the immense will of three little orphaned girls who look at him and see something that no one else has ever seen: a potential Dad. The world's greatest villain has just met his greatest challenge: three little girls named Margo (Miranda Cosgrove), Edith (Dana Gaier), and Agnes (Elsie Fisher).",
            "https://m.media-amazon.com/images/M/MV5BMTY3NjY0MTQ0Nl5BMl5BanBnXkFtZTcwMzQ2MTc0Mw@@._V1_.jpg",
                false
        )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
            "TV1",
            "Money Heist",
            2017,
            8.3F,
            9,
            "Action, Crime, Mystery",
            "An enigmatic man, nicknamed The Professor, plans the biggest heist in history. To carry out this plan, he recruits eight of the country's top criminals who have nothing to lose: Tokyo, an experienced robber, Berlin, the ringleader, Moscow, the drilling expert, Rio, the computer scientist, Nairobi, the counterfeiter, Denver, son of Moscow, and Helsinki and Oslo, the Balkan war veterans.\n" +
                    "\n" +
                    "The goal is to infiltrate the Royal Mint of Spain in order to print €2.4 billion in less than 11 days, without spelling a single drop of blood. The group takes 67 hostages, including the daughter of the British Ambassador. With the mastermind working on the outside, they always manage to stay one step ahead of the police.",
            "https://timesofindia.indiatimes.com/thumb/75792614.cms?width=219&height=317&quality=80&imgsize=85583",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV2",
            "The Falcon and the Winter Soldier",
            2020,
            7.5F,
            6,
            "Action, Adventure, Drama",
            "Following the events of “Avengers: Endgame,” Sam Wilson/Falcon (Anthony Mackie) and Bucky Barnes/Winter Soldier (Sebastian Stan) team up in a global adventure that tests their abilities—and their patience—in Marvel Studios’ “The Falcon and The Winter Soldier.” The all-new series is directed by Kari Skogland; Malcolm Spellman is the head writer.",
            "https://terrigen-cdn-dev.marvel.com/content/prod/1x/falcws_lob_crd_03.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV3",
            "Game of Thrones",
            2011,
            9.3F,
            10,
            "Action, Adventure, Drama",
            "In the mythical continent of Westeros, several powerful families fight for control of the Seven Kingdoms. As conflict erupts in the kingdoms of men, an ancient enemy rises once again to threaten them all. Meanwhile, the last heirs of a recently usurped dynasty plot to take back their homeland from across the Narrow Sea.",
            "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV4",
            "Attack on Titan",
            2013,
            8.9F,
            25,
            "Animation, Action, Adventure",
            "Humans are nearly exterminated by giant creatures called Titans. Titans are typically several stories tall, seem to have no intelligence, devour human beings and, worst of all, seem to do it for the pleasure rather than as a food source. A small percentage of humanity survived by walling themselves in a city protected by extremely high walls, even taller than the biggest of titans. Flash forward to the present and the city has not seen a titan in over 100 years. Teenage boy Eren and his foster sister Mikasa witness something horrific as the city walls are destroyed by a colossal titan that appears out of thin air. As the smaller titans flood the city, the two kids watch in horror as their mother is eaten alive. Eren vows that he will murder every single titan and take revenge for all of mankind.",
            "https://m.media-amazon.com/images/M/MV5BMTY5ODk1NzUyMl5BMl5BanBnXkFtZTgwMjUyNzEyMTE@._V1_.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV5",
            "WandaVision",
            2021,
            8.1F,
            9,
            "Action, Comedy, Drama",
            "Blends the style of classic sitcoms with the MCU, in which Wanda Maximoff and Vision - two super-powered beings living their ideal suburban lives - begin to suspect that everything is not as it seems.",
            "https://m.media-amazon.com/images/M/MV5BYjJiZmE5ZDgtYWUxZi00MWI1LTg2MmEtZmUwZGE2YzRkNTE5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV6",
            "Black Mirror",
            2011,
            8.8F,
            3,
            "Drama, Sci-Fi, Thriller",
            "Set in a world only minutes from our own, \"Black Mirror\" unveils how modern technologies can backfire and be used against their makers, every episode set in a slightly different reality with different characters combating different types of technologies.",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/black-mirror-font-1513096756.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV7",
            "The Queen's Gambit",
            2020,
            8.6F,
            7,
            "Drama",
            "Nine year-old orphan Beth Harmon is quiet, sullen, and by all appearances unremarkable. That is, until she plays her first game of chess. Her senses grow sharper, her thinking clearer, and for the first time in her life she feels herself fully in control. By the age of sixteen, she's competing for the U.S. Open championship. But as Beth hones her skills on the professional circuit, the stakes get higher, her isolation grows more frightening, and the thought of escape becomes all the more tempting. Based on the book by Walter Tevis.",
            "https://m.media-amazon.com/images/M/MV5BM2EwMmRhMmUtMzBmMS00ZDQ3LTg4OGEtNjlkODk3ZTMxMmJlXkEyXkFqcGdeQXVyMjM5ODk1NDU@._V1_.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV8",
            "Grey's Anatomy",
            2005,
            7.6F,
            9,
            "Drama, Romance",
            "A medical based drama centered around Meredith Grey, an aspiring surgeon and daughter of one of the best surgeons, Dr. Ellis Grey. Throughout the series, Meredith goes through professional and personal challenges along with fellow surgeons at Seattle Grace Hospital.",
            "https://static.wikia.nocookie.net/greysanatomy/images/6/62/GAS16Poster.jpg/revision/latest?cb=20190919161955",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV9",
            "Dr. Stone",
            2019,
            8.2F,
            24,
            "Animation, Action, Adventure",
            "One fateful day, all of humanity was petrified by a blinding flash of light. After several millennia, high schooler Taiju awakens and finds himself lost in a world of statues. However, he's not alone. His science-loving friend Senku's been up and running for a few months and he's got a grand plan in mind, to kickstart civilization with the power of science.",
            "https://m.media-amazon.com/images/M/MV5BOTI4YWNlNzMtNWU3Yi00OTBmLWEyOTYtZjAyYTM5NWZkMWM4XkEyXkFqcGdeQXVyMTI2NTY3NDg5._V1_.jpg",
                false
        )
        )

        tvShows.add(
            TvShowEntity(
            "TV10",
            "Demon Slayer: Kimetsu no Yaiba",
            2019,
            8.7F,
            27,
            "Animation, Action, Fantasy",
            "From the earliest times, the humanity knows about human-flesh eating monsters, lurking in the darkness to devour an unfortunate soul that does not trust rumors. However, the rumors also mention an elite corps of demon hunters, skilled assassins, killing demons. Demon Slayer focuses on Tanjirou Kamado, who is still very young, but is the only man in his family. One day, Tanjirou decides to go down to the local village to make a little money, selling charcoal. When he returns back, he becomes an unwilling part of these horrifying rumors: his family is slaughtered and the only survivor, his sister Nezuko, is turned into demon. For some reason, Nezuko still acts as a human, which is the reason for Tanjirou to join demon slayers and cure his sister. Will he manage to join the elite corps and cure his sister?",
            "https://m.media-amazon.com/images/M/MV5BZjZjNzI5MDctY2Y4YS00NmM4LTljMmItZTFkOTExNGI3ODRhXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_.jpg",
                false
        )
        )

        return tvShows
    }

    fun generateDummyEpisodes(tvShowId: String, title: String, eps: Int): List<EpisodeEntity>{
        val episodes = ArrayList<EpisodeEntity>()

        for (episode in 1..eps){
            episodes.add(
                    EpisodeEntity(
                            "{$tvShowId}eps{$episode}",
                            tvShowId,
                            "$title Episode $episode",
                            Random.nextInt(40, 70)
                    )
            )
        }

        return episodes
    }

    fun generateRemoteDummyMovies(): List<MovieResponse>{
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "M1",
                "The Greatest Showman",
                2017,
                7.6F,
                105,
                "Biography, Drama, Musical",
                "Orphaned, penniless, but ambitious and with a mind crammed with imagination and fresh ideas, the American entertainer, Phineas Taylor Barnum, will always be remembered as the man with the gift to blur the line between reality and fiction. Thirsty for innovation and hungry for success, the son of a tailor manages to open a wax museum; however, he soon shifts focus to the unique and the peculiar, introducing extraordinary, never-seen-before live acts on the circus stage. Now, some people call Barnum's rich collection of oddities, an outright freak show; but, when Phineas, obsessed for cheers and respectability, gambles everything on the opera singer, Jenny Lind, to appeal to a high-brow audience, he will lose sight of the most crucial aspect of his life: his family. Will Barnum, the greatest showman, risk it all to be accepted?",
                "https://upload.wikimedia.org/wikipedia/en/1/10/The_Greatest_Showman_poster.png",
            )
        )

        movies.add(
            MovieResponse(
                "M2",
                "Who Am I",
                2014,
                7.5F,
                102,
                "Crime, Drama, Mystery",
                "Benjamin (TOM SCHILLING) is invisible, a nobody. This changes abruptly when he meets charismatic Max (ELYAS M'BAREK). Even though they couldn't seem more different from the outside, they share the same interest: hacking. Together with Max's friends, the impulsive Stephan (WOTAN WILKE MÖHRING) and paranoid Paul (ANTOINE MONOT), they form the subversive Hacker collective CLAY (CLOWNS LAUGHING @ YOU). CLAY provokes with fun campaigns and speaks for a whole generation. For the first time in his life, Benjamin is part of something and even the attractive Marie (HANNAH HERZSPRUNG) begins noticing him. But fun turns into deadly danger when CLAY appears on the BKA's (Bundeskriminalamt, Federal Criminal Police Office) as well as Europol's most wanted list. Hunted by Cybercrime investigator Hanne Lindberg (TRINE DYRHOLM), Benjamin is no longer a nobody, but instead one of the most wanted hackers in the world.",
                "https://upload.wikimedia.org/wikipedia/en/5/5c/Who_am_I_movie_poster.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M3",
                "How to Train Your Dragon: The Hidden World",
                2019,
                7.5F,
                104,
                "Animation, Action, Adventure",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://upload.wikimedia.org/wikipedia/en/f/fd/How_to_Train_Your_Dragon_3_poster.png"
            )
        )

        movies.add(
            MovieResponse(
                "M4",
                "2 Fast 2 Furious",
                2003,
                5.9F,
                107,
                "Action, Crime, Thriller",
                "EX LAPD cop Brian O'Conner (Paul Walker) teams up with his ex-con friend Roman Pearce (Tyrese Gibson) and works with undercover U.S. Customs Service agent Monica Fuentes (Eva Mendes) to bring Miami-based drug lord Carter Verone (Cole Hauser) down.",
                "https://upload.wikimedia.org/wikipedia/en/9/9d/Two_fast_two_furious_ver5.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M5",
                "Hansel & Gretel: Witch Hunters",
                2013,
                6.1F,
                88,
                "Action, Fantasy, Horror",
                "The siblings Hansel and Gretel are left alone in the woods by their father and captured by a dark witch in a candy house. However they kill the witch and escape from the spot. Years later, the orphans have become famous witch hunters. When eleven children go missing in a small village, the Mayor summons Hansel and Gretel to rescue them, and they save the red haired Mina from the local sheriff who wants to burn her, accusing Mina of witchcraft. Soon they discover that the Blood Moon will approach in three days and the powerful dark witch Muriel is responsible for the abduction of children. She intends to use the children together with a secret ingredient in a Sabbath to make the coven of witches protected against the fire. Meanwhile Hansel and Gretel disclose secrets about their parents.",
                "https://upload.wikimedia.org/wikipedia/en/8/88/Hansel_and_Gretel_Witch_Hunters_.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M6",
                "Iron Man",
                2008,
                7.9F,
                126,
                "Action, Adventure, Sci-Fi",
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters.",
                "https://assets-a1.kompasiana.com/items/album/2019/02/11/infosinopsisdotblogspot-5c61477bbde57513bc5d21a7.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M7",
                "Spider-Man: Far from Home",
                2019,
                7.5F,
                129,
                "Action, Adventure, Sci-Fi",
                "Our friendly neighborhood Super Hero decides to join his best friends Ned, MJ, and the rest of the gang on a European vacation. However, Peter's plan to leave super heroics behind for a few weeks are quickly scrapped when he begrudgingly agrees to help Nick Fury uncover the mystery of several elemental creature attacks, creating havoc across the continent.",
                "https://upload.wikimedia.org/wikipedia/en/b/bd/Spider-Man_Far_From_Home_poster.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M8",
                "The Dark Knight Rises",
                2012,
                8.4F,
                164,
                "Action, Adventure",
                "Despite his tarnished reputation after the events of The Dark Knight (2008), in which he took the rap for Dent's crimes, Batman feels compelled to intervene to assist the city and its Police force, which is struggling to cope with Bane's plans to destroy the city.",
                "https://upload.wikimedia.org/wikipedia/en/8/83/Dark_knight_rises_poster.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M9",
                "Joker",
                2019,
                8.4F,
                122,
                "Crime, Drama, Thriller",
                "Arthur Fleck works as a clown and is an aspiring stand-up comic. He has mental health issues, part of which involves uncontrollable laughter. Times are tough and, due to his issues and occupation, Arthur has an even worse time than most. Over time these issues bear down on him, shaping his actions, making him ultimately take on the persona he is more known as...Joker.",
                "https://upload.wikimedia.org/wikipedia/en/e/e1/Joker_%282019_film%29_poster.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "M10",
                "Despicable Me",
                2010,
                7.6F,
                95,
                "Animation, Comedy, Crime",
                "In a happy suburban neighborhood surrounded by white picket fences with flowering rose bushes, sits a black house with a dead lawn. Unbeknownst to the neighbors, hidden beneath this house is a vast secret hideout. Surrounded by a small army of minions, we discover Gru (Steve Carell), planning the biggest heist in the history of the world. He is going to steal the moon. Gru delights in all things wicked. Armed with his arsenal of shrink rays, freeze rays, and battle-ready vehicles for land and air, he vanquishes all who stand in his way. Until the day he encounters the immense will of three little orphaned girls who look at him and see something that no one else has ever seen: a potential Dad. The world's greatest villain has just met his greatest challenge: three little girls named Margo (Miranda Cosgrove), Edith (Dana Gaier), and Agnes (Elsie Fisher).",
                "https://m.media-amazon.com/images/M/MV5BMTY3NjY0MTQ0Nl5BMl5BanBnXkFtZTcwMzQ2MTc0Mw@@._V1_.jpg"
            )
        )

        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse>{
        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(
            TvShowResponse(
                "TV1",
                "Money Heist",
                2017,
                8.3F,
                9,
                "Action, Crime, Mystery",
                "An enigmatic man, nicknamed The Professor, plans the biggest heist in history. To carry out this plan, he recruits eight of the country's top criminals who have nothing to lose: Tokyo, an experienced robber, Berlin, the ringleader, Moscow, the drilling expert, Rio, the computer scientist, Nairobi, the counterfeiter, Denver, son of Moscow, and Helsinki and Oslo, the Balkan war veterans.\n" +
                        "\n" +
                        "The goal is to infiltrate the Royal Mint of Spain in order to print €2.4 billion in less than 11 days, without spelling a single drop of blood. The group takes 67 hostages, including the daughter of the British Ambassador. With the mastermind working on the outside, they always manage to stay one step ahead of the police.",
                "https://timesofindia.indiatimes.com/thumb/75792614.cms?width=219&height=317&quality=80&imgsize=85583"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV2",
                "The Falcon and the Winter Soldier",
                2020,
                7.5F,
                6,
                "Action, Adventure, Drama",
                "Following the events of “Avengers: Endgame,” Sam Wilson/Falcon (Anthony Mackie) and Bucky Barnes/Winter Soldier (Sebastian Stan) team up in a global adventure that tests their abilities—and their patience—in Marvel Studios’ “The Falcon and The Winter Soldier.” The all-new series is directed by Kari Skogland; Malcolm Spellman is the head writer.",
                "https://terrigen-cdn-dev.marvel.com/content/prod/1x/falcws_lob_crd_03.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV3",
                "Game of Thrones",
                2011,
                9.3F,
                10,
                "Action, Adventure, Drama",
                "In the mythical continent of Westeros, several powerful families fight for control of the Seven Kingdoms. As conflict erupts in the kingdoms of men, an ancient enemy rises once again to threaten them all. Meanwhile, the last heirs of a recently usurped dynasty plot to take back their homeland from across the Narrow Sea.",
                "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV4",
                "Attack on Titan",
                2013,
                8.9F,
                25,
                "Animation, Action, Adventure",
                "Humans are nearly exterminated by giant creatures called Titans. Titans are typically several stories tall, seem to have no intelligence, devour human beings and, worst of all, seem to do it for the pleasure rather than as a food source. A small percentage of humanity survived by walling themselves in a city protected by extremely high walls, even taller than the biggest of titans. Flash forward to the present and the city has not seen a titan in over 100 years. Teenage boy Eren and his foster sister Mikasa witness something horrific as the city walls are destroyed by a colossal titan that appears out of thin air. As the smaller titans flood the city, the two kids watch in horror as their mother is eaten alive. Eren vows that he will murder every single titan and take revenge for all of mankind.",
                "https://m.media-amazon.com/images/M/MV5BMTY5ODk1NzUyMl5BMl5BanBnXkFtZTgwMjUyNzEyMTE@._V1_.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV5",
                "WandaVision",
                2021,
                8.1F,
                9,
                "Action, Comedy, Drama",
                "Blends the style of classic sitcoms with the MCU, in which Wanda Maximoff and Vision - two super-powered beings living their ideal suburban lives - begin to suspect that everything is not as it seems.",
                "https://m.media-amazon.com/images/M/MV5BYjJiZmE5ZDgtYWUxZi00MWI1LTg2MmEtZmUwZGE2YzRkNTE5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV6",
                "Black Mirror",
                2011,
                8.8F,
                3,
                "Drama, Sci-Fi, Thriller",
                "Set in a world only minutes from our own, \"Black Mirror\" unveils how modern technologies can backfire and be used against their makers, every episode set in a slightly different reality with different characters combating different types of technologies.",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/black-mirror-font-1513096756.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV7",
                "The Queen's Gambit",
                2020,
                8.6F,
                7,
                "Drama",
                "Nine year-old orphan Beth Harmon is quiet, sullen, and by all appearances unremarkable. That is, until she plays her first game of chess. Her senses grow sharper, her thinking clearer, and for the first time in her life she feels herself fully in control. By the age of sixteen, she's competing for the U.S. Open championship. But as Beth hones her skills on the professional circuit, the stakes get higher, her isolation grows more frightening, and the thought of escape becomes all the more tempting. Based on the book by Walter Tevis.",
                "https://m.media-amazon.com/images/M/MV5BM2EwMmRhMmUtMzBmMS00ZDQ3LTg4OGEtNjlkODk3ZTMxMmJlXkEyXkFqcGdeQXVyMjM5ODk1NDU@._V1_.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV8",
                "Grey's Anatomy",
                2005,
                7.6F,
                9,
                "Drama, Romance",
                "A medical based drama centered around Meredith Grey, an aspiring surgeon and daughter of one of the best surgeons, Dr. Ellis Grey. Throughout the series, Meredith goes through professional and personal challenges along with fellow surgeons at Seattle Grace Hospital.",
                "https://static.wikia.nocookie.net/greysanatomy/images/6/62/GAS16Poster.jpg/revision/latest?cb=20190919161955"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV9",
                "Dr. Stone",
                2019,
                8.2F,
                24,
                "Animation, Action, Adventure",
                "One fateful day, all of humanity was petrified by a blinding flash of light. After several millennia, high schooler Taiju awakens and finds himself lost in a world of statues. However, he's not alone. His science-loving friend Senku's been up and running for a few months and he's got a grand plan in mind, to kickstart civilization with the power of science.",
                "https://m.media-amazon.com/images/M/MV5BOTI4YWNlNzMtNWU3Yi00OTBmLWEyOTYtZjAyYTM5NWZkMWM4XkEyXkFqcGdeQXVyMTI2NTY3NDg5._V1_.jpg"
            )
        )

        tvShows.add(
            TvShowResponse(
                "TV10",
                "Demon Slayer: Kimetsu no Yaiba",
                2019,
                8.7F,
                27,
                "Animation, Action, Fantasy",
                "From the earliest times, the humanity knows about human-flesh eating monsters, lurking in the darkness to devour an unfortunate soul that does not trust rumors. However, the rumors also mention an elite corps of demon hunters, skilled assassins, killing demons. Demon Slayer focuses on Tanjirou Kamado, who is still very young, but is the only man in his family. One day, Tanjirou decides to go down to the local village to make a little money, selling charcoal. When he returns back, he becomes an unwilling part of these horrifying rumors: his family is slaughtered and the only survivor, his sister Nezuko, is turned into demon. For some reason, Nezuko still acts as a human, which is the reason for Tanjirou to join demon slayers and cure his sister. Will he manage to join the elite corps and cure his sister?",
                "https://m.media-amazon.com/images/M/MV5BZjZjNzI5MDctY2Y4YS00NmM4LTljMmItZTFkOTExNGI3ODRhXkEyXkFqcGdeQXVyNjc3MjQzNTI@._V1_.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyEpisodes(tvShowId: String, title: String, eps: Int): List<EpisodeResponse>{
        val episodes = ArrayList<EpisodeResponse>()

        for (episode in 1..eps){
            episodes.add(
                EpisodeResponse(
                    "{$tvShowId}eps{$episode}",
                    tvShowId,
                    "$title Episode $episode",
                    Random.nextInt(40, 70)
                )
            )
        }

        return episodes
    }

    fun generateDummyTvShowWithEpisode(tvShow: TvShowEntity, isFav: Boolean): TvShowWithEpisode{
        tvShow.isFav = isFav
        return TvShowWithEpisode(tvShow, generateDummyEpisodes(tvShow.tvShowId, tvShow.title, tvShow.eps))
    }
}