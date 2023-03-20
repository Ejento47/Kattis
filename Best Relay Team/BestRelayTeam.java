import java.util.*;

class BestRelayTeam {
    String name;
    double firstleg;
    double otherleg;

    // Instance
    public BestRelayTeam(String name, double firstleg, double otherleg){
        this.name = name;
        this.firstleg = firstleg;
        this.otherleg = otherleg;
    }
    public String getName(){ return name; }
    public double getFirstleg(){ return firstleg; }
    public double getOtherleg(){ return otherleg; }

    //methods for sorting the array of the teams according to their respective time in ascending order
    static List<BestRelayTeam> FirstlegSort(List<BestRelayTeam> team){
        team.sort(Comparator.comparingDouble(BestRelayTeam::getFirstleg));
        return team;
    }
    static List<BestRelayTeam> OtherlegSort(List<BestRelayTeam> team){
        team.sort(Comparator.comparingDouble(BestRelayTeam::getOtherleg));
        return team;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_runners = sc.nextInt();
        //create list to store members and time into it
        List<BestRelayTeam> team = new ArrayList<>();


        for (int i = 0; i < num_runners; i++){
            String name = sc.next();
            double firstleg = sc.nextDouble();
            double otherleg = sc.nextDouble();
            // create a temp variable for storing instance objects and add in the team array
            BestRelayTeam temp = new BestRelayTeam(name,firstleg,otherleg);
            team.add(temp);
        }
        // sort team according the first leg time in ascending order
        FirstlegSort(team);

        double fastest_time = 1000000;
        List<BestRelayTeam> best_team = new ArrayList<>();

        // determine the best time and best team // btr to create a new method??
        for(int i = 0; i < num_runners; i++){
            List<BestRelayTeam> team_otherleg = new ArrayList(team); // create another array with team
            BestRelayTeam firstleg_member = team_otherleg.remove(i); // since index 0 is fastest firstleg
            OtherlegSort(team_otherleg);

            double timecheck = firstleg_member.getFirstleg();
            List<BestRelayTeam> teamcheck = new ArrayList(Arrays.asList(firstleg_member));

            for(int j = 0; j < 3; j++){
                timecheck +=  team_otherleg.get(j).getOtherleg();
                teamcheck.add(team_otherleg.get(j));
            }

            if (timecheck < fastest_time){
                fastest_time = timecheck;
                best_team = teamcheck;
            }
        }

        System.out.println(fastest_time);
        for(int i = 0; i < 4; i++){
            System.out.println(best_team.get(i).getName());
        }
    }
}