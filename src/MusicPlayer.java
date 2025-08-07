import java.util.Scanner;

public class MusicPlayer implements Iphone {
    private static Scanner scanner = new Scanner(System.in);

    boolean musicPlayerStatus = false;
    boolean pause = false;
    boolean mute = false;
    String action;
    int soundVolume = 20;
    String music;

    public boolean isMusicPlayerStatus() {
        return musicPlayerStatus;
    }

    public void setMusicPlayerStatus(boolean musicPlayerStatus) {
        this.musicPlayerStatus = musicPlayerStatus;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }


    @Override
    public void checkPhone() throws PhoneExceptions {
        if (Main.phone.phoneStatus == true || Main.phone.isCallHold() == true)
            throw new PhoneExceptions("Ligação telefônica ativa, não é possível realizar a operação\n");
                if (musicPlayerStatus == false
                && (action.equalsIgnoreCase("pause")
                || action.equalsIgnoreCase("moveFoward")
                || action.equalsIgnoreCase("moveBack")
                || action.equalsIgnoreCase("repeat")
                || action.equalsIgnoreCase("mute")))
            throw new PhoneExceptions("Não existe música tocando no momento\n");

    }

    @Override
    public void find() {
        action = "find";
        keyboard();
        System.out.println("Digite nome da música");
        music = scanner.nextLine();
        System.out.println("Buscando pela múscica "+music+"\n");
        System.out.println("Tocar música (S ou N)?");
        String play = scanner.nextLine();
        if (play.equalsIgnoreCase("S") || play.equalsIgnoreCase("Sim"))
        {this.musicPlayerStatus = true;System.out.println("tocando a múscica "+music+"\n");}
        else {;}

    }

    @Override
    public void volume() {
        action = "volume";
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        }
        keyboard();
        System.out.println("Ajustar volume >> digite + ou -");
        String volumeAction = scanner.next();
        if (soundVolume + 2 > 100 || soundVolume - 2 <0)
        {System.out.println("Limite do volume atingido\n");}
        else {  if (volumeAction.equalsIgnoreCase("+")) {soundVolume=soundVolume+2;}
        else if (volumeAction.equalsIgnoreCase("-")) {soundVolume=soundVolume-2;}
        else{;}}
        System.out.println("Volume do som "+soundVolume+"%\n");
    }

    @Override
    public boolean keyboard() {
        System.out.println("Teclado ativo\n");
        return true;
    }

    public void playStop(){
        action = "playStop";
        try{
            checkPhone();
        } catch (PhoneExceptions ex){
            System.out.println(ex.getMessage());
            return;
        } if (musicPlayerStatus == false) {find();}
        else {System.out.println("Parando a  música "+music+"\n");musicPlayerStatus = false;}
    }

    public void pause() {
        action = "pause";
        try {
            checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            return;
        }
        if (this.pause == false) {
            this.pause = true;
            System.out.println("Pausando a música " + music+"\n");
        } else if (this.pause == true) {
            this.pause = false;
            System.out.println("Retomando a música " + music+"\n");
        }
    }

    public void moveFoward() {
        action = "moveFoward";
        try {
            checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Avançando a música " + music+"\n");
    }

    public void moveBack() {
        action = "moveBack";
        try {
            checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Retrocedendo a música " + music+"\n");
    }

    public void repeat() {
        action = "repeat";
        try {
            checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            return;
        } System.out.println("Repetindo a música " + music+"\n");
    }

    public void mute() {
        action = "mute";
        try {
            checkPhone();
        } catch (PhoneExceptions ex) {
            System.out.println(ex.getMessage());
            return;
        }
        if (mute == false) {
            mute = true;
            System.out.println("Mute ligado\n");
        } else if (mute == true) {
            mute = false;
            System.out.println("Mute desligado\n");
        }
    }

}




