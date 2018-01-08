package generics;

import wildcards.IColorable;
import wildcards.Shape;

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
