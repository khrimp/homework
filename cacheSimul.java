public class cacheSimul {
    public static void simulate(int cacheSize, String cities)
    {
        int hit = 100;
        int miss = 500;
        if (cacheSize == 0)
        {
            System.out.println("total time:" + cities.length() * miss);
            System.out.println("hits:" + "0");
            System.out.println("misses:" + cities.length());
            return;
        }
        int hits = 0;
        int misses = 0;
        int answer = 0;
        cities = cities.toLowerCase();
        StringBuilder cache = new StringBuilder();

        for (int i = 0; i < cities.length(); i++)
        {
            String name = "" + cities.charAt(i);

            if (cache.toString().contains(name))
            {
                answer += hit;
                hits += 1;
                cache = new StringBuilder(cache.toString().replaceAll(name, ""));
                cache.append(name);
            }
            else
            {
                answer += miss;
                misses += 1;
                if (cache.length() == cacheSize)
                {
                    cache = new StringBuilder(cache.substring(1));
                    cache.append(name);
                }
                else cache.append(name);
            }
        }
        System.out.println("total time:" + answer);
        System.out.println("hits:" + hits);
        System.out.println("misses:" + misses);
    }

    public static void main (String[] args)
    {
        String string = "Hello, my name is Hanseongwoo. I'm studying at" +
                "Tech university of korea. thank you.";
        simulate(0, string);
        System.out.println();
        simulate(10, string);
    }

}
