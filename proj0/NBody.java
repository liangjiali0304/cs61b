public class NBody {

    /** return the radius of the universe in one file*/
    public static double readRadius(String file_name) {
        In in = new In(file_name);
        int planet_num = in.readInt();
        double r_universe = in.readDouble();
        return r_universe;
    }


    /** Given a txt file with planet info, return an array with planets defined*/
    public static Planet[] readPlanet(String file_name) {
        In in = new In(file_name);
        int planet_num = in.readInt();
        double r_universe = in.readDouble();

        /** Define a new array of size planet_num to store planets in txt file*/
        Planet[] Planet_arr = new Planet[planet_num];

        for (int i = 0; i < planet_num; i+= 1){
            /* Each line has the rank of a country, then its
             * name, then its production in metric tons, and
             * finally the fraction of world salt output it produces. */
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass  = in.readDouble();
            String img_name  = in.readString();
            String name = img_name.substring(0, img_name.length() - 4);
            Planet_arr[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,img_name);

        }
        return Planet_arr;
    }

    public static void main(String[] args) {

        double T  = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planet_arr = readPlanet(filename);
        System.out.println(T);

        /** universe img*/
        String imageToDraw = "images/starfield.jpg";


        /** Sets up the universe so it goes from
           * -100, -100 up to 100, 100 */
        StdAudio.play("audio/2001.mid");
        StdDraw.enableDoubleBuffering();

        double r_universe = readRadius(filename);
        StdDraw.setScale(-r_universe, r_universe);
        /* Clears the drawing window. */




        for (double time=0; time<=T;time+=dt ){
            /** Storing the X-, Y- dir forces for all planets*/
            double[] xForce = new double[planet_arr.length];
            double[] yForce = new double[planet_arr.length];

            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for (int i=0; i<planet_arr.length;i+=1) {
                /** Calculate all forces and update planets specs*/
                xForce[i] = planet_arr[i].calcNetForceExertedByX(planet_arr);
                yForce[i] = planet_arr[i].calcNetForceExertedByY(planet_arr);
                planet_arr[i].update(dt,xForce[i],yForce[i]);
                planet_arr[i].draw();}

            StdDraw.show();
            StdDraw.pause(10);
        }

        /** Print out final states of the universe*/
        StdOut.printf("%d\n", planet_arr.length);
        StdOut.printf("%.2e\n", r_universe);
        for (int i = 0; i < planet_arr.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet_arr[i].xxPos, planet_arr[i].yyPos, planet_arr[i].xxVel,
                    planet_arr[i].yyVel, planet_arr[i].mass, planet_arr[i].imgFileName);
        }
    }



}