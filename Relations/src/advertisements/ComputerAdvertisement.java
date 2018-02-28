package advertisements;

public class ComputerAdvertisement
{
    //simple fields
    private String computerType; //laptop, desktop, tablet, ...
    private double cpuSpeed; //ghz
    private int cpuCores;
    private boolean includesGPUCard;

    //constructor(s)
    public ComputerAdvertisement(String computerType, double cpuSpeed,
                                 int cpuCores, boolean includesGPUCard)
    {
        this.computerType = computerType;
        this.cpuSpeed = cpuSpeed;
        this.cpuCores = cpuCores;
        this.includesGPUCard = includesGPUCard;
    }

    //getters/setters
    public String getComputerType()
    {
        return computerType;
    }

    public double getCpuSpeed()
    {
        return cpuSpeed;
    }

    public int getCpuCores()
    {
        return cpuCores;
    }

    public boolean isIncludesGPUCard()
    {
        return includesGPUCard;
    }

    //equals(), hashcode()

    @Override
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
        //is this an instance of ComputerAdvertisement? (not a descendent)
        else if (!other.getClass().equals(this.getClass()))
        {
            return false;
        }
        //this is not reliable and is not symmetric
        /*else if (!(other instanceof ComputerAdvertisement))
        {
            return false;
        }*/
        else
        {
            ComputerAdvertisement otherAd = (ComputerAdvertisement)other;

            return this.computerType.equals(otherAd.computerType) &&
                    this.cpuCores == otherAd.cpuCores &&
                    this.cpuSpeed == otherAd.cpuSpeed;
        }
    }

    @Override
    public int hashCode()
    {
        return 0;
    }
}
