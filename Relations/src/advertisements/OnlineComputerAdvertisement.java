package advertisements;

public class OnlineComputerAdvertisement extends ComputerAdvertisement
{
    //other fields here...

    public OnlineComputerAdvertisement(String computerType, double cpuSpeed,
                                       int cpuCores, boolean includesGPUCard)
    {
        super(computerType, cpuSpeed, cpuCores, includesGPUCard);
    }

    public boolean equals(Object other)
    {

        if (other == null)
        {
            return false;
        }
        else if (this == other)
        {
            return true;
        }
        else if (!(other instanceof OnlineComputerAdvertisement))
        {
            return false;
        }
        else
        {
            //for now...
            return true;
        }
    }
}
