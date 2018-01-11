package generics;

import wildcards.IColorable;
import wildcards.Shape;

//Type T must be a descendant of Shape and implement IColorable
public class DataStorage<T extends Shape & IColorable>
{
    private T data;

    public DataStorage(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }
}
