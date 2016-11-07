package koncept;

/**
 * Created by Nikita on 14.7.2016.
 */
public class Koncept
{
    interface Int
    {
        public abstract void go();
    }

    abstract class Kk implements Int
    {
        public abstract void no();

        void ddd()
        {
            
        }

    }

    class Two extends Kk
    {

        @Override
        public void no()
        {

        }

        @Override
        public void go()
        {

        }
    }
}
