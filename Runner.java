import javax.swing.*;

public class Runner {
    public Runner() {
        VirtualPet p = new VirtualPet();
        String ans = getAnswer("How are you (good, bad, meh, devious)", "Mood check");
        if (ans.equalsIgnoreCase("Good")) {
            p.face.setMessage("You should... NOW");
            p.face.setImage("angry");
            actTimes(999);
        }
        if (ans.equalsIgnoreCase("bad")) {
            p.face.setMessage("Good >:D");
            p.face.setImage("ecstatic");
            actTimes(999);
        }
        if (ans.equalsIgnoreCase("meh")) {
            p.face.setMessage("That's CRAZY bro!");
            p.face.setImage("shocked");
        }
        if (ans.equalsIgnoreCase("devious")) {
            p.face.setMessage("Bro DID NOT Just say that");
            p.face.setImage("astonished");
        }

        liveLoop(p);
        deathLoop(p, true);

        liveLoop(p);
        deathLoop(p, false); // resurrection disabled

        // String ans = getAnswer("", "");
        // if (ans.equalsIgnoreCase("")) {
        //     p.face.setMessage("");
        //     p.face.setImage("");
        // }
    }

    public void liveLoop(VirtualPet p){
        while (!p.deadCheck()){    
            String ans1 = getAnswer("What would you like me to do? (eat, run, sleep, socialm, drink)", "Activity");
            if (ans1.equalsIgnoreCase("eat")) {
                p.eat();
                actTimes(999);
            }
            if (ans1.equalsIgnoreCase("run")) {
                p.exercise();
                actTimes(999);
            }
            if (ans1.equalsIgnoreCase("sleep")) {
                p.sleep();
                actTimes(999);
            }
            if (ans1.equalsIgnoreCase("socialm")) {
                p.socialMedia();
                actTimes(1999);
            }
            if (ans1.equalsIgnoreCase("drink")) {
                p.drink();
                actTimes(999);
            }
        }
    }

    public void deathLoop(VirtualPet p, boolean first){
        while (p.deadCheck() && p.isActive()) {
            String ans2 = getAnswer("Your pet has died (oh no, resurrect, skeleton, give up)", "Postmortem");
            if (ans2.equalsIgnoreCase("oh no")) {
                p.face.setMessage("Sucks to suck");
                p.face.setImage("cry");
                actTimes(3500);
                p.face.setImage("skeleton");
            }
            if (ans2.equalsIgnoreCase("resurrect")) {
                if (first) {
                    p.resurrect();
                    actTimes(999);
                }
                else {
                    p.face.setMessage("You can't do that anymore");
                    p.face.setImage("skeleton");
                }
            }
            if (ans2.equalsIgnoreCase("skeleton")){
                p.skeleton();
                actTimes(999);
            }
            if (ans2.equalsIgnoreCase("give up")){
                p.giveUp();
                actTimes (999);
            }
        }
    }


    public void actTimes (int ms) {
        try {
            Thread.sleep(ms);
        } 
        catch(Exception e){

        }
    }

    public String getAnswer(String q, String t){
        String s = (String)JOptionPane.showInputDialog(
            new JFrame(),
            q,
            t,
            JOptionPane.PLAIN_MESSAGE
        );
        return s;
    }

    public static void main(String[] args) {
        new Runner();

    }
}
