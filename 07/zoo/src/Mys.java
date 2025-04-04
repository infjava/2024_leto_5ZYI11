public class Mys extends Zviera {
    @Override
    public void zozer(Jedlo<?> jedlo) {
        if (!(jedlo instanceof Syr)) {
            throw new ToNelubimException();
        }

        System.out.println("Myska zhryzkala ponuknute jedlo");
    }
}
