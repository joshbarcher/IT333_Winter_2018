package hash_tables;

import java.util.Random;

public class TestHashTables
{
    public static void main(String[] args)
    {
        Random random = new Random();

        HashTable<Integer> numberTable = new HashTable<>();

        for (int i = 1; i <= 100; i++)
        {
            numberTable.add(random.nextInt(1000));
        }

        numberTable.printUsedSpaces();

        for (int i = 0 ; i < 1000; i++)
        {
            System.out.println(i + ": " + numberTable.contains(i));
        }

        for (int i = 0; i < 500; i++)
        {
            numberTable.remove(i);
        }

        numberTable.printUsedSpaces();

        for (int i = 0 ; i < 1000; i++)
        {
            System.out.println(i + ": " + numberTable.contains(i));
        }

        for (int element : numberTable)
        {
            System.out.println(element);
        }
    }
}
