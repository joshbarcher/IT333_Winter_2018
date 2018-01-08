package structures;

public class Bag<T>
{
    private T[] data;
    private int size;

    public Bag(int size)
    {
        data = (T[])new Object[size];
    }

    public boolean add(T element)
    {
        if (isFull())
        {
            return false;
        }

        data[size++] = element;
        return true;
    }

    //removes the first occurrence of the element
    public boolean remove(T element)
    {
        //search for my element - should this be contains()?
        for (int i = 0; i < size; i++)
        {
            if (data[i].equals(element))
            {
                //remove it...
            }
        }

        return false;
    }

    public int size()
    {
        return size;
    }

    public boolean isFull()
    {
        return size >= data.length;
    }
}
