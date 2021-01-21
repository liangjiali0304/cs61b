public class PlanetTest {
    public static void main(String[] args) {
        Planet samh = new Planet(1,0,0,0,10,"");
        Planet aegir = new Planet(3,3,0,0,5,"");
        Planet rocinante = new Planet(5,-3,0,0,50,"");

        System.out.println(samh.calcDistance(rocinante));
        Planet[] arr = new Planet[]{samh,aegir,rocinante};

        System.out.println(samh.calcNetForceExertedByX(arr));
        System.out.println(samh.calcNetForceExertedByY(arr));
        System.out.println(NBody.readPlanet("../data/planets.txt")[2].imgFileName);
    }
}