public class VirtualPet {
    
    VirtualPetFace face;
    int hunger = 0;
    int thirst = 0;
    int sleepiness = 0;
    int attention = 25;
    boolean isDead;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hello.");
    }
    
    // e's hungy
    public void eat() {
        if (hunger == 0){
            face.setMessage("I've been overfed");
            face.setImage("pushingdaisies");
            isDead = true;
        } 
        else {
            if (hunger > 10) {
            hunger = hunger - 10;
            }
            else {
                hunger = 0;
            }
            face.setMessage("Yum, thanks");
            face.setImage("normal");
        }

        sleepiness += 4;
        attention += 5;
        thirst += 1;
        deathCheck();
        savethePets();
    }

    public void drink() {

    }
    
    // go touch some grass !!! googogogogogogo
    public void exercise() {
        hunger += 3;
        sleepiness += 7;
        attention -= 3;
        thirst += 5;

        face.setMessage("despair");
        face.setImage("exercising");
        try {Thread.sleep(2000);} catch(Exception e){}
        face.setImage("tired");

        deathCheck();
        savethePets();
    }
    
    // eepy
    public void sleep() {
        hunger += 1;
        attention += 1; // the pet dreams of you (a sort of torment)
        thirst += 4;
        if (sleepiness>40){
            sleepiness -= 20;
        }
        else {
            sleepiness = 0;
        }

        face.setMessage("I'm sleeping");
        face.setImage("asleep");

        deathCheck();
        savethePets();
    }

    public void socialMedia() {
        hunger += 3;
        sleepiness -= 3;
        attention -= 23;
        thirst += 8;

        face.setMessage("I probably shouldn't be doing this right now");
        face.setImage("enraged");

        deathCheck();
        savethePets();
    }

    

    // Reminder function 
    public void savethePets() {
        if (hunger >= 10 && hunger < 15){
            face.setMessage("I'm getting hungry, you should feed me");
            face.setImage("starving");
            try {Thread.sleep(2000);} catch(Exception e){}
        }
        if (sleepiness >= 50 && sleepiness < 70){
            face.setMessage("I'm getting sleepy, I should probably get some rest...");
            face.setImage("tired");
            try {Thread.sleep(2000);} catch(Exception e){}
        }
        if (attention <= 10 && attention > 0) {
            face.setMessage("I need more attention");
            face.setImage("skeleton");
            try {Thread.sleep(2000);} catch(Exception e){}
        }
        else if (attention >= 50 && attention < 60) {
            face.setMessage("I'm receiving too much attention");
            face.setImage("skeleton");
            try {Thread.sleep(2000);} catch(Exception e){}
        }
        if (thirst >= 20 && thirst > 30) {
            face.setMessage("I am running out of water");
            face.setImage("thirsty");
            try {Thread.sleep(2000);} catch(Exception e){}
        }
    }


    // resets the pet, can only be called in the first instance of your pet dying as it does not show up second time
    public void resurrect(){
        hunger = 0;
        sleepiness = 0;
        attention = 30;
        thirst = 0;
        isDead = false;
        face.setMessage("Bro that's cheating");
        face.setImage("astonished");
    }

    public void skeleton(){
        face.setMessage("Skeletor");
        face.setImage("skelton");
    }

    // Your pet has died :(
    public void deathCheck () {
        if (deadCheck()) {
            try {Thread.sleep(1000);} catch(Exception e){}
            face.setMessage("I'm dead");
            face.setImage("dead");
        }
    }

    // Returns a boolean on whether or not your pet has died, flexible because you can add conditions
    public boolean deadCheck() {
        if (hunger > 15 || sleepiness > 69 || attention < 1 || attention > 59 || thirst > 40){
            isDead = true;
        }
        return isDead;
    }

} // end Virtual Pet
