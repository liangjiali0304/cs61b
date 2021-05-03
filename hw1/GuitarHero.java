/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static final double CONCERT_D = CONCERT_A * Math.pow(2, 4.0 / 12.0);

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        String tune = "A Bb B C C# D Eb E F F# G G# ";
        // make it 37
        tune += tune + tune + "A";
        /* create two guitar strings, for concert A and C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);
        GuitarString stringD = new GuitarString(CONCERT_D);
        GuitarString [] strings = new GuitarString[37];
        String [] tunes_arr = tune.split(" ");

        for (double i=0; i < 37.0; i++){
            strings[(int)i] = new GuitarString(
                    440.0 * Math.pow(2.0, (i - 24.0) / 12.0));
        }



        int [] key_pressed = new int[10];

        while (true) {
            int array_size = 0;

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                // find out the key index pressed
                int key_inx = keyboard.indexOf(key);
                if ( key_inx >= 0 && key_inx < 37) {
                    strings[key_inx].pluck();
                    key_pressed[array_size] = key_inx;
                    array_size++;
                    System.out.println(tunes_arr[key_inx]);
                }
            }

            double sum_harmony = 0;
            // Where it makes the harmony
            for (GuitarString str : strings){
                sum_harmony += str.sample();
            }
            //double sample = strings[0].sample() + strings[1].sample() + strings[2].sample();
            StdAudio.play(sum_harmony);
            /* play the sample on standard audio */


            /* advance the simulation of each guitar string by one step */
            for (GuitarString str : strings){
                str.tic();
            }
        }
    }
}