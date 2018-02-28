package advertisements;

public class TestAds
{
    public static void main(String[] args)
    {
        ComputerAdvertisement desktop = new ComputerAdvertisement(
                "Desktop", 3.4, 4, true);
        ComputerAdvertisement laptop = new ComputerAdvertisement(
                "Laptop", 3.7, 4, false);
        OnlineComputerAdvertisement anotherDesktop = new OnlineComputerAdvertisement(
                "Desktop", 3.4, 4, false);
        ComputerAdvertisement theLastDesktop = new ComputerAdvertisement(
                "Desktop", 3.4, 4, true);

        //test our equivalence relation
        System.out.println("a.equals(a): " + desktop.equals(desktop)); //reflexive?
        System.out.println("a.equals(b): " + desktop.equals(anotherDesktop) +
                           ", b.equals(a): " + anotherDesktop.equals(desktop)); //symmetric?
        System.out.println("a.equals(b): " + desktop.equals(anotherDesktop) +
                           ", b.equals(c): " + anotherDesktop.equals(theLastDesktop) +
                           ", a.equals(c): " + desktop.equals(theLastDesktop)); //transitive?

    }
}
